package org.example.control;

import org.example.model.Location;

import java.time.Instant;

public interface WeatherProvider {
    void GetWeather(Location location, Instant instant);
}
