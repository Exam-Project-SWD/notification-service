package org.example.notificationservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

@Configuration
public class EmailConfig {
    @Value("${spring.mail.username}")
    private String from;

    @Bean
    public SimpleMailMessage templateSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setSubject("Poor weather might affect your delivery");
        message.setText("""
                Dear %s,
                                
                The weather at your location is frankly awful, and it's possible that your delivery might experience some delays, but hopefully not.
                                
                As a reminder, don't forget to tip your delivery person.
                                
                Best regards,
                MTOGO Delivery Service""");
        return message;
    }
}
