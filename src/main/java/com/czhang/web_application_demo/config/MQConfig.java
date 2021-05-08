package com.czhang.web_application_demo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static com.czhang.web_application_demo.constants.MovieServiceConstants.MQ_COMMENTS_QUEUQ;

@Configuration
public class MQConfig {

    @Bean
    public Queue messageQueue() {
       return new Queue(MQ_COMMENTS_QUEUQ, true);
    }

    @Bean
    public MessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
