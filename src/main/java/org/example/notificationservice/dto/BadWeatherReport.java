package org.example.notificationservice.dto;

import java.util.List;

// We use WeatherCause instead of Cause to simplify deserialization.
// If we add more cause types, we'll need a factory method to pick the right type based on the type field.
// This is a future refactoring.
public record BadWeatherReport(int customerId, List<WeatherCause> causes) {
}
