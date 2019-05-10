package com.pwk.springboot.rabbitmq.receiver;

import com.pwk.springboot.config.LogRabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = LogRabbitMQConfig.QUEUE_ALL_LOG)
public class AllReceiver {
    @RabbitHandler
    public void process(String context){
        System.out.println("all receiver..."+context);
    }
}
