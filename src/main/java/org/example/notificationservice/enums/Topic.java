package org.example.notificationservice.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Topic {
    BAD_WEATHER("BAD_WEATHER"),
    CHANGED_CUSTOMER("CHANGED_CUSTOMER"),
    DELETED_CUSTOMER("DELETED_CUSTOMER");

    // Value for the topic name is in case we want to change the casing of the topics in the future, but keep enums in uppercase by convention
    private final String topicName;
}
