package com.ouyang.project.rabbitmq.subscribe;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by ouyang on 2018/1/20.
 */
public class EmitLogDirect {
    private static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "direct");

        channel.basicPublish(EXCHANGE_NAME, "info", null, "info message...".getBytes());
        System.out.println(" [x] Sent 'info':'info message...'");
        channel.basicPublish(EXCHANGE_NAME, "warn", null, "warn message...".getBytes());
        System.out.println(" [x] Sent 'warn':'warn message...'");
        channel.basicPublish(EXCHANGE_NAME, "info", null, "info message 2...".getBytes());
        System.out.println(" [x] Sent 'info':'info message 2...'");
        channel.basicPublish(EXCHANGE_NAME, "warn", null, "warn message 2...".getBytes());
        System.out.println(" [x] Sent 'warn':'warn message 2...'");
        channel.basicPublish(EXCHANGE_NAME, "error", null, "error message...".getBytes());
        System.out.println(" [x] Sent 'error':'error message...'");

        channel.close();
        connection.close();
    }
}
