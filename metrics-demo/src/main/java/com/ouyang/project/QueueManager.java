package com.ouyang.project;

import com.codahale.metrics.Gauge;
import com.codahale.metrics.MetricRegistry;

import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by ouyang on 2018/1/25.
 */
public class QueueManager {
    private final Queue<String> queue;

    public QueueManager(MetricRegistry metrics, String name) {
        this.queue = new LinkedList<>();
        metrics.register(MetricRegistry.name(QueueManager.class, name, "size"),
                new Gauge<Integer>() {
                    @Override
                    public Integer getValue() {
                        return queue.size();
                    }
                });
    }
}
