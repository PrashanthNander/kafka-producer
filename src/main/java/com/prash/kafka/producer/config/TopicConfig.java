package com.prash.kafka.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {

    @Value("${kafka.order.topic.name}")
    private String orderTopic;

    @Bean
    public NewTopic orderTopic() {
        return TopicBuilder
                .name(orderTopic)
                .replicas(1)
                .partitions(3)
                .build();
    }

}
