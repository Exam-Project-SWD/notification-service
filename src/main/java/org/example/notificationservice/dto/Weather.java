package org.example.notificationservice.dto;

import java.util.List;

public record Weather(Coordinates coord, List<Condition> weather, Main main, int visibility,
                      Wind wind,
                      Clouds clouds, Rain rain, Snow snow) {
    public record Coordinates(double lon, double lat) {
    }

    public record Main(double temp, double feels_like, double temp_min, double temp_max, int pressure, int humidity) {
    }

    public record Wind(double speed, int deg, double gust) {
    }

    public record Clouds(int all) {
    }

    public record Rain(double _1h, double _3h) {
    }

    public record Snow(double _1h, double _3h) {
    }

    public record Condition(int id, String main, String description, String icon) {
    }
}
