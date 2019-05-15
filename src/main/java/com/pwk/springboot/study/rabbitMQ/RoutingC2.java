package com.pwk.springboot.study.rabbitMQ;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RoutingC2 {
    private final static String EXCHANGE_NAME = "direct_logs";
    private final static String[] LOG_LEVEL = {"DEBUG","WARNING","INFO"};

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME,"direct");
        String queueName = channel.queueDeclare().getQueue();
        for (String logLevel:LOG_LEVEL)
            channel.queueBind(queueName,EXCHANGE_NAME,logLevel);
        System.out.println("Consumer 2 waiting for message...");

        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body,"UTF-8");
                System.out.println("Received message:"+envelope.getRoutingKey()+" "+message);
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        channel.basicConsume(queueName,true,consumer);
    }
}
