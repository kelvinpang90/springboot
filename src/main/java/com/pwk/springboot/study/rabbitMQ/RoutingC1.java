package com.pwk.springboot.study.rabbitMQ;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RoutingC1 {
    private final static String EXCHANGE_NAME = "direct_logs";
    private final static String[] LOG_LEVEL = {"ERROR"};

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //声明一个类型为direct的exchange
        channel.exchangeDeclare(EXCHANGE_NAME,"direct");
        //获取一个临时队列
        String queueName = channel.queueDeclare().getQueue();
        for (String logLevel:LOG_LEVEL)
            //根据routekey(logLevel)将queue和exchange绑定起来，使当前channel的消费者只接受指定routekey传来的信息
            channel.queueBind(queueName,EXCHANGE_NAME,logLevel);
        System.out.println("Consumer 1 waiting for message...");

        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body,"UTF-8");
                System.out.println("Received message:"+envelope.getRoutingKey()+" "+message);
                //通知队列，信息处理完成，可以从队列中删除；
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        channel.basicConsume(queueName,true,consumer);
    }
}
