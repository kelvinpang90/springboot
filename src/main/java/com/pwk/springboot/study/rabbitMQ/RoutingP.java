package com.pwk.springboot.study.rabbitMQ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RoutingP {
    private final static String EXCHANGE_NAME = "direct_logs";
    private final static String[] LOG_LEVEL = {"DEBUG","WARNING","INFO","ERROR"};
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //声明一个类型为direct的exchange，在消费者端同样需要这样做
        channel.exchangeDeclare(EXCHANGE_NAME,"direct");
        for (String logLevel:LOG_LEVEL){
            for (int i = 0;i<3;i++){
                //根据exchange和routekey将信息发送出去
                channel.basicPublish(EXCHANGE_NAME,logLevel,null,(logLevel+" message").getBytes("UTF-8"));
            }
        }
        channel.close();
        connection.close();
    }
}
