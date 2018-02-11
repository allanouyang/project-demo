package com.ouyang.project;

import com.codahale.metrics.Counter;
import com.codahale.metrics.MetricRegistry;

/**
 * Created by ouyang on 2018/1/26.
 */
public class Counters {

    private Counter pendingJobs;

    public Counters(MetricRegistry metrics) {
        pendingJobs = metrics.counter(MetricRegistry.name(QueueManager.class, "pending-jobs"));
    }

//    public void addJob(Job job) {
//        pendingJobs.inc();
//        queue.offer(job);
//    }
//
//    public Job takeJob() {
//        pendingJobs.dec();
//        return queue.take();
//    }
}
