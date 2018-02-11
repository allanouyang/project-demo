package com.ouyang.project.storm.spouts;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichSpout;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 * Created by ouyang on 2018/2/3.
 */
public class WordReader implements IRichSpout {

    private SpoutOutputCollector collector;
    private FileReader reader;
    private boolean completed = false;
//    private TopologyContext context;

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("line"));
    }

    @Override
    public Map<String, Object> getComponentConfiguration() {
        return null;
    }

    @Override
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        try {
//            this.context = topologyContext;
            String file = map.get("wordsFile").toString();
            this.reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error reading file ["+map.get("wordFile")+"]");
        }
        this.collector = spoutOutputCollector;
    }

    @Override
    public void close() {
        System.out.println("close ...... ");
    }

    @Override
    public void activate() {
        System.out.println("activate ...... ");
    }

    @Override
    public void deactivate() {
        System.out.println("deactivate ...... ");
    }

    @Override
    public void nextTuple() {
        if(completed) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            return;
        }
        String str;
        BufferedReader bufferedReader = new BufferedReader(reader);
        try {
            while ((str = bufferedReader.readLine()) != null) {
                this.collector.emit(new Values(str), str);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading tuple",e);
        } finally {
            completed = true;
        }
    }

    @Override
    public void ack(Object o) {
        System.out.println("ack:" + o + " ...... ");
    }

    @Override
    public void fail(Object o) {
        System.out.println("fail:" + o + " ...... ");
    }
}
