package org.example.notificationservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.example.notificationservice.enums.Topic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig {
    @Bean
    public NewTopic badWeatherTopic() {
        return new NewTopic(Topic.BAD_WEATHER.getTopicName(), 1, (short) 1);
    }
}
