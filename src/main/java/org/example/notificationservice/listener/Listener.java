package org.example.notificationservice.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.notificationservice.dto.BadWeatherReport;
import org.example.notificationservice.entity.User;
import org.example.notificationservice.service.EmailService;
import org.example.notificationservice.service.UserService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class Listener {
    private final UserService userService;
    private final EmailService emailService;

    @KafkaListener(topics = "BAD_WEATHER", containerFactory = "badWeatherContainerFactory")
    public void badWeatherListener(BadWeatherReport badWeatherReport) {
        log.info("Received bad weather report: {}", badWeatherReport);

        User user = userService.getUser(badWeatherReport.customerId());
        log.info("User: {}", user);

        emailService.sendEmail(user);
    }

    @KafkaListener(topics = "CHANGED_CUSTOMER", containerFactory = "userContainerFactory")
    public void changedCustomerListener(User user) {
        log.info("Received changed customer: {}", user);
        if (user.getEmail() == null) {
            log.info("Email is null, not persisting user until email field is made nullable.");
            return;
        }
        userService.saveUser(user);
    }

    @KafkaListener(topics = "DELETED_CUSTOMER", containerFactory = "integerContainerFactory")
    public void deletedCustomerListener(Integer id) {
        log.info("Received deleted customer: {}", id);
        userService.deleteUser(id);
    }
}
