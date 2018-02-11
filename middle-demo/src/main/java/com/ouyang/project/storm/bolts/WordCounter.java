package com.ouyang.project.storm.bolts;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Tuple;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ouyang on 2018/2/3.
 */
public class WordCounter implements IRichBolt {

    Integer id;
    String name;
    Map<String, Integer> counters;
    private OutputCollector collector;

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        counters = new HashMap<>();
        this.collector = outputCollector;
        this.name = topologyContext.getThisComponentId();
        this.id = topologyContext.getThisTaskId();
    }

    @Override
    public void execute(Tuple tuple) {
        String str = tuple.getString(0);
        if (counters.containsKey(str)) {
            Integer c = counters.get(str) + 1;
            counters.put(str, c);
        } else {
            counters.put(str, 1);
        }


        //对元组作为应答
        collector.ack(tuple);
    }

    @Override
    public void cleanup() {
        System.out.println("-- 单词数 【"+name+"-"+id+"】 --");
        counters.forEach((k, v) -> System.out.println(k+": "+v));

    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {

    }

    @Override
    public Map<String, Object> getComponentConfiguration() {
        return null;
    }
}
