package org.example.model;

import java.time.Instant;


public class Weather {
    private final double temp;
    private final int humidity;
    private final int cloudiness;
    private final double windSpeed;
    private final double pop;
    private final Instant instant;
    private final Location location;

    public Weather(double temp, int humidity, int cloudiness, double windSpeed, double pop, Instant instant, Location location){
        this.temp = temp;
        this.pop = pop;
        this.humidity = humidity;
        this.cloudiness = cloudiness;
        this.windSpeed = windSpeed;
        this.instant = instant;
        this.location = location;
    }

    public double getTemp() {
        return temp;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getCloudiness() {
        return cloudiness;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getPop() {
        return pop;
    }

    public Instant getInstant() {
        return instant;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "temp=" + temp +
                ", humidity=" + humidity +
                ", pop=" + pop +
                ", cloudiness=" + cloudiness +
                ", windSpeed=" + windSpeed +
                ", instant=" + instant +
                ", location=" + location.getLatitude() + " " + location.getLongitude() +
                '}';
    }
}
