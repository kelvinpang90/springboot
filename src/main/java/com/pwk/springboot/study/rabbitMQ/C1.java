package com.pwk.springboot.study.rabbitMQ;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class C1 {
    private final static String QUEUE_NAME = "HELLO";
    private final static String EXCHANGE_NAME = "LOGS";
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        //声明一个交换器以及定义交换器类型
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
        //创建一个临时队列，队列会随着断开消费者而被立即删除
        String queueName = channel.queueDeclare().getQueue();
        System.out.println("QueueName="+queueName);
        //绑定队列与交换器，只接受参数s2（routingkey）指定的消息
        channel.queueBind(queueName,EXCHANGE_NAME,"C1");
        //队列每次只传一个信息
        channel.basicQos(1);

        System.out.println("Consumer 1 waiting for message...");
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body,"UTF-8");
                System.out.println("Consumer 1 received:"+message);
                try {
                    doSomething();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("consumer 1 job done");
                    //消息处理完成确认
                    channel.basicAck(envelope.getDeliveryTag(),false);
                }
            }
        };
        //执行消费者
        channel.basicConsume(queueName,true,consumer);
    }

    public static void doSomething() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
    }
}
