package org.example.notificationservice.service;

import jakarta.mail.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {
    private final JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String from;

    public void sendEmail(String to, String subject, String text) {
        try {
            javaMailSender.send(mimeMessage -> {
                mimeMessage.setFrom(from);
                mimeMessage.setRecipients(Message.RecipientType.TO, to);
                mimeMessage.setSubject(subject);
                mimeMessage.setText(text);
            });
        } catch (Exception e) {
            log.error("Failed to send email", e);
        }
    }
}
