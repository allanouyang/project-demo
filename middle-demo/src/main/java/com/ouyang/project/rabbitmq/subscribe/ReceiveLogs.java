package com.ouyang.project.rabbitmq.subscribe;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by ouyang on 2018/1/20.
 */
public class ReceiveLogs {

    private final static String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);

        //获取队列名
        String queueName = channel.queueDeclare().getQueue();
        channel.basicQos(1);

        //绑定队列
        channel.queueBind(queueName, EXCHANGE_NAME, "");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
                try {
                    Thread.sleep(20000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                channel.basicAck(envelope.getDeliveryTag(), false);

            }
        };


        boolean autoAck = false;
        channel.basicConsume(queueName, autoAck, consumer);

    }
}
