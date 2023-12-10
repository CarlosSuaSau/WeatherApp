package org.example.control;

import org.example.model.Weather;

import java.util.List;

public interface WeatherStore extends AutoCloseable {
    void save(Weather weather);

    @Override
    default void close() throws Exception {
    }
}
