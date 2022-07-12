package com.mert.config;

//class that's responsible for creating topics.

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean //gets instantiated runs.
    public NewTopic mertTopic(){
        return TopicBuilder.name("mert").build();

    }
}
