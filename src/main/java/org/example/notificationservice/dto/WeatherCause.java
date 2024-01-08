package org.example.notificationservice.dto;

import org.example.notificationservice.enums.BadWeatherType;

public record WeatherCause(BadWeatherType type, Weather.Condition details) implements Cause {
}
