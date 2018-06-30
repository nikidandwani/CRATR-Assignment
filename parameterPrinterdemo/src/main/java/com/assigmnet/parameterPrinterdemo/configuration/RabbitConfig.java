package com.assigmnet.parameterPrinterdemo.configuration;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig
{
    public static final String QUEUE_PARAMETERS = "parameters-queue";
    public static final String QUEUE_DEAD_PARAMETERS = "dead-queue";
    public static final String EXCHANGE_PARAMETERS = "parameters-exchange";

    @Bean
    Queue paramQueue() {
        return QueueBuilder.durable(QUEUE_PARAMETERS).build();
    }

    @Bean
    Queue deadLetterQueue() {
        return QueueBuilder.durable(QUEUE_DEAD_PARAMETERS).build();
    }

  /*  @Bean
    Exchange parameterExchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE_PARAMETERS).build();
    }*/
/*
    @Bean
    Binding binding(Queue paramQueue, TopicExchange parameterExchange) {
        return BindingBuilder.bind(paramQueue).to(parameterExchange).with(QUEUE_PARAMETERS);
    }*/
}
