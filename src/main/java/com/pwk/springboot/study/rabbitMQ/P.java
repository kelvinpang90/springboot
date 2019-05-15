package com.pwk.springboot.study.rabbitMQ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class P {
    private final static String QUEUE_NAME = "HELLO";
    private final static String EXCHANGE_NAME = "LOGS";
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
//        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
        for(int i = 0;i<5;i++){
            String message = "Hello World "+i;
            //发布消息，可以指定交换器名字和根据参数s1（routingkey），判断传给哪一个队列
            channel.basicPublish(EXCHANGE_NAME,"C1",null,message.getBytes("UTF-8"));
            System.out.println("Producer sent:"+message);
        }
        channel.close();
        connection.close();
    }
}
