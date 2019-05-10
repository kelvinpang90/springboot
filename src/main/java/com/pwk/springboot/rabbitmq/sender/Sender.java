package com.pwk.springboot.rabbitmq.sender;

import com.pwk.springboot.config.LogRabbitMQConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    @Autowired
    private AmqpTemplate template;

    public void send(){
        String context = "error log";
        this.template.convertAndSend(LogRabbitMQConfig.EXCHANGE, LogRabbitMQConfig.ROUTING_KEY_ERROR,context);

        context = "info log";
        this.template.convertAndSend(LogRabbitMQConfig.EXCHANGE,LogRabbitMQConfig.ROUTING_KEY_ALL,context);
        
        context = "warn log";
        this.template.convertAndSend(LogRabbitMQConfig.EXCHANGE,LogRabbitMQConfig.ROUTING_KEY_WARN,context);
    }
}
