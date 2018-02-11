package com.ouyang.project.storm;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;
import com.ouyang.project.storm.bolts.WordCounter;
import com.ouyang.project.storm.bolts.WordNormalizer;
import com.ouyang.project.storm.spouts.WordReader;

/**
 * Created by ouyang on 2018/2/3.
 */
public class TopologyMain {

    public static void main(String[] args) throws Exception {
        //定义拓扑
        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("word-reader", new WordReader());
        builder.setBolt("word-normalizer", new WordNormalizer()).shuffleGrouping("word-reader");
        builder.setBolt("word-counter", new WordCounter(), 2).fieldsGrouping("word-normalizer", new Fields("word"))
                .allGrouping("word-normalizer", "signals");

        //配置
        Config conf = new Config();
        conf.put("wordsFile", "/Users/ouyang/IdeaProjects/space-ky-demo/project-demo/middle-demo/src/main/resources/words.txt");
        conf.setDebug(false);

        //运行拓扑
        conf.put(Config.TOPOLOGY_MAX_SPOUT_PENDING, 1);
        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("Getting-Started-Topologie", conf, builder.createTopology());
        Thread.sleep(1000L);
        cluster.shutdown();
    }
}
