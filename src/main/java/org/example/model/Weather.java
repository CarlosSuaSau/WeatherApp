package org.example.model;

import java.time.Instant;

public class Weather {
    private float temp;
    private int pressure;
    private int humidity;
    private float wind;
    private Instant ts;
    private Location location;

    public Weather(float temp, int pressure, int humidity, float wind, Instant ts, Location location) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.wind = wind;
        this.ts = ts;
        this.location = location;
    }

}
