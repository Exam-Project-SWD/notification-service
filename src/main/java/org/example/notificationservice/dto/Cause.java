package org.example.notificationservice.dto;

import org.example.notificationservice.enums.BadWeatherType;

public interface Cause {
    BadWeatherType type();

    Object details();
}
