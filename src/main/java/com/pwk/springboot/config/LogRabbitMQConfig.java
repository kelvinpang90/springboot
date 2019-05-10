package com.pwk.springboot.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogRabbitMQConfig {
    public final static String QUEUE_ALL_LOG = "log.info";
    public final static String QUEUE_ERROR_LOG = "log.error";
    public final static String QUEUE_WARN_LOG = "log.warn";

    public final static String EXCHANGE = "log";

    public final static String ROUTING_KEY_ALL = "log.#";
    public final static String ROUTING_KEY_ERROR = "log.error";
    public final static String ROUTING_KEY_WARN = "log.warn";

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
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding bindAll(){
        return BindingBuilder.bind(logAll()).to(exchange()).with(ROUTING_KEY_ALL);
    }

    @Bean
    public Binding bindError(){
        return BindingBuilder.bind(logError()).to(exchange()).with(ROUTING_KEY_ERROR);
    }
}
