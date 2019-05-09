package com.pwk.springboot.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogRabbitMQConfig {
    private final static String QUEUE_ALL_LOG = "log.#";
    private final static String QUEUE_ERROR_LOG = "log.error";

    @Bean
    public Queue logError(){
        return new Queue(QUEUE_ERROR_LOG);
    }

    @Bean
    public Queue logAll(){
        return new Queue(QUEUE_ALL_LOG);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("log");
    }

    @Bean
    public Binding bindAll(){
        return BindingBuilder.bind(logAll()).to(exchange()).with(QUEUE_ALL_LOG);
    }

    @Bean
    public Binding bindError(){
        return BindingBuilder.bind(logError()).to(exchange()).with(QUEUE_ERROR_LOG);
    }
}
