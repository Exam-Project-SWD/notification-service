package org.example.notificationservice;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

@Disabled
@SpringBootTest
@EmbeddedKafka(partitions = 1)
class NotificationServiceApplicationTests {

    @Test
    void contextLoads() {
    }

}
