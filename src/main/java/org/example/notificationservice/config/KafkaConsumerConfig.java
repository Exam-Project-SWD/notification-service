package org.example.notificationservice.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.example.notificationservice.dto.BadWeatherReport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Map;

@Configuration
public class KafkaConsumerConfig {
    @Bean
    public Map<String, Object> consumerConfigs() {
        return Map.of(
                ConsumerConfig.GROUP_ID_CONFIG, "notification-service",
                ConsumerConfig.CLIENT_ID_CONFIG, "notification-service",
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class,
                JsonDeserializer.TYPE_MAPPINGS, "bad-weather-report:org.example.notificationservice.dto.BadWeatherReport"
        );
    }

    @Bean
    public ConsumerFactory<String, BadWeatherReport> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, BadWeatherReport> badWeatherContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, BadWeatherReport> containerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        containerFactory.setConsumerFactory(consumerFactory());
        return containerFactory;
    }
}
