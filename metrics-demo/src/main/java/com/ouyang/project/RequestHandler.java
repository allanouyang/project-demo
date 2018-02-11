package com.ouyang.project;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.sun.tools.internal.ws.processor.model.Request;
import com.sun.tools.internal.ws.processor.model.Response;

/**
 * Created by ouyang on 2018/1/26.
 */
public class RequestHandler {

    private Meter requests = null;

    public RequestHandler(MetricRegistry metrics) {
        requests = metrics.meter("requests");
    }

    public void handleRequest(Request request, Response response) {
        requests.mark();
        // etc
    }
}
