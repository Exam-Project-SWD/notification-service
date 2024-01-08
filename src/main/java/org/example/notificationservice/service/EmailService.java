package org.example.notificationservice.service;

import jakarta.mail.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.notificationservice.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {
    private final JavaMailSender javaMailSender;
    private final SimpleMailMessage templateSimpleMessage;
    @Value("${spring.mail.username}")
    private String from;

    // Uses template.
    public void sendEmail(User user) {
        SimpleMailMessage message = new SimpleMailMessage(templateSimpleMessage);
        message.setTo(user.getEmail());
        message.setText(String.format(message.getText(), user.getFirstName()));
        javaMailSender.send(message);
    }

    // General purpose method for sending emails.
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
