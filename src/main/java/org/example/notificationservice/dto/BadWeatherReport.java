package org.example.notificationservice.dto;

import java.util.List;

public record BadWeatherReport(int customerId, List<Cause> causes) {
}
