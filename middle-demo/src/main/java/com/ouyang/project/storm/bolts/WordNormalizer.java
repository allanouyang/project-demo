package com.ouyang.project.storm.bolts;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ouyang on 2018/2/3.
 */
public class WordNormalizer implements IRichBolt {

    Integer id;
    String name;
    private OutputCollector collector;

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        this.collector = outputCollector;
        this.name = topologyContext.getThisComponentId();
        this.id = topologyContext.getThisTaskId();
    }

    @Override
    public void execute(Tuple tuple) {
        String sentence = tuple.getString(0);
        String[] words = sentence.split(" ");
        for (String word: words) {
            word = word.trim();
            if(!word.isEmpty()) {
                word = word.toLowerCase();
                //发布这个单词
                List<Tuple> a = new ArrayList<>();
                a.add(tuple);
                collector.emit(a, new Values(word));
            }
        }
        //测试全部数据流 signals
        if (tuple.getSourceStreamId().equals("signals")) {
            System.out.println("【"+name+"-"+id+"】signals...");
        } else if (tuple.getSourceStreamId().equals("default")) {
            System.out.println("【"+name+"-"+id+"】default...");
        }
        //对元组做出应答
        collector.ack(tuple);
    }

    @Override
    public void cleanup() {
        System.out.println("cleanup ...... ");
    }

    /**
     * 这个*bolt*只会发布“word”域
     * @param outputFieldsDeclarer
     */
    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("word"));
    }

    @Override
    public Map<String, Object> getComponentConfiguration() {
        return null;
    }
}
