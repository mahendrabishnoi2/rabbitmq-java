package com.example.rabbitmqnonblocking.rabbitconfig;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableRabbit
public class Config {
    @Bean
    Queue queue() {
        return new Queue(Queues.NON_BLOCKING_TEST, true);
    }

    @Bean
    public ConnectionFactory rabbitConnectionFactory(RabbitProperties rabbitProperties) {
        com.rabbitmq.client.ConnectionFactory rabbitConnectionFactory = new com.rabbitmq.client.ConnectionFactory();
//        rabbitConnectionFactory.setHost(rabbitProperties.getHost());
//        rabbitConnectionFactory.setPort(rabbitProperties.getPort());
//        rabbitConnectionFactory.setUsername(rabbitProperties.getUsername());
//        rabbitConnectionFactory.setPassword(rabbitProperties.getPassword());
        rabbitConnectionFactory.useNio();
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(rabbitConnectionFactory);
        return cachingConnectionFactory;
    }

    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }
}
