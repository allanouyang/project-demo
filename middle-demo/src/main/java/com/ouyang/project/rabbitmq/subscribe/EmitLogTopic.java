package com.ouyang.project.rabbitmq.subscribe;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by ouyang on 2018/1/20.
 */
public class EmitLogTopic {

    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] args) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);


        channel.basicPublish(EXCHANGE_NAME, "quick.orange.rabbit", null, "quick.orange.rabbit message ...".getBytes());
        System.out.println(" [x] Sent 'quick.orange.rabbit':'quick.orange.rabbit message ...'");
        channel.basicPublish(EXCHANGE_NAME, "lazy.orange.elephant", null, "lazy.orange.elephant message ...".getBytes());
        System.out.println(" [x] Sent 'lazy.orange.elephant':'lazy.orange.elephant message ...'");
        channel.basicPublish(EXCHANGE_NAME, "quick.orange.fox", null, "quick.orange.fox message ...".getBytes());
        System.out.println(" [x] Sent 'quick.orange.fox':'quick.orange.fox message ...'");
        channel.basicPublish(EXCHANGE_NAME, "lazy.brown.fox", null, "lazy.brown.fox message ...".getBytes());
        System.out.println(" [x] Sent 'lazy.brown.fox':'lazy.brown.fox message ...'");
        channel.basicPublish(EXCHANGE_NAME, "lazy.orange.male.rabbit", null, "lazy.orange.male.rabbit message ...".getBytes());
        System.out.println(" [x] Sent 'lazy.orange.male.rabbit':'lazy.orange.male.rabbit message ...'");
        channel.basicPublish(EXCHANGE_NAME, "lazy.pink.rabbit", null, "lazy.pink.rabbit message ...".getBytes());
        System.out.println(" [x] Sent 'lazy.pink.rabbit':'lazy.pink.rabbit message ...'");

        channel.close();
        connection.close();

    }
}
