package com.ouyang.project.flume;

import org.apache.flume.Event;
import org.apache.flume.EventDeliveryException;
import org.apache.flume.api.RpcClient;
import org.apache.flume.api.RpcClientFactory;
import org.apache.flume.event.EventBuilder;

import java.nio.charset.Charset;

/**
 * Created by ouyang on 2018/2/2.
 */
public class MyRpcClientFacade {

    private RpcClient client;
    private String hostname;
    private int port;

    public void init(String hostname, int port) {
        // Setup the RPC connection
        this.hostname = hostname;
        this.port = port;
        this.client = RpcClientFactory.getDefaultInstance(hostname, port);
        // Use the following method to create a thrift client (instead of the above line):
        // this.client = RpcClientFactory.getThriftInstance(hostname, port);
    }

    public void sendDataToFlume(String data) {
        //create a Flume Event object that encapsulates the sample data
        Event event = EventBuilder.withBody(data, Charset.forName("UTF-8"));
        try {
            //Send the event
            client.append(event);
        } catch (EventDeliveryException e) {
            //clean up and recreate the client
            this.client.close();
            this.client = null;
            this.client = RpcClientFactory.getDefaultInstance(hostname, port);
            e.printStackTrace();
        }

    }

    public void cleanUp() {
        this.client.close();
    }

}
