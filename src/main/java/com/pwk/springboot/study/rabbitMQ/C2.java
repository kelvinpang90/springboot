package com.pwk.springboot.study.rabbitMQ;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class C2 {
    private final static String QUEUE_NAME = "HELLO";
    private final static String EXCHANGE_NAME = "LOGS";
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
        String queueName = channel.queueDeclare().getQueue();
        System.out.println("QueueName="+queueName);

        channel.queueBind(queueName,EXCHANGE_NAME,"C2");
        channel.basicQos(1);

        System.out.println("Consumer 2 waiting for message...");
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body,"UTF-8");
                System.out.println("Consumer 2 received:"+message);
                try {
                    C1.doSomething();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("Consumer 2 job done");
                    channel.basicAck(envelope.getDeliveryTag(),false);
                }
            }
        };
        channel.basicConsume(queueName,true,consumer);
    }
}
