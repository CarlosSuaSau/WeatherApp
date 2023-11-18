package org.example.control;

import org.example.model.Weather;

import java.util.List;

public interface WeatherStore extends AutoCloseable {
    void save(List<Weather> weathers, String tableName);

    @Override
    default void close() throws Exception {
    }
}
