package org.example.model;

import java.time.Instant;


public class Weather {
    private final double temp;
    private final int humidity;
    private final int cloudiness;
    private final double windSpeed;
    private final double pop;
    private final String instant;
    private final Location location;
    private final String ts;
    private final String ss;

    public Weather(double temp, int humidity, int cloudiness, double windSpeed, double pop, String instant, Location location, String ts, String ss){
        this.temp = temp;
        this.pop = pop;
        this.humidity = humidity;
        this.cloudiness = cloudiness;
        this.windSpeed = windSpeed;
        this.instant = instant;
        this.location = location;
        this.ts = ts;
        this.ss = ss;

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

    public String getInstant() {
        return instant;
    }

    public Location getLocation() {
        return location;
    }
    public String getTs(){ return ts; }
    public String getSs() { return ss; }

    @Override
    public String toString() {
        return "Weather{" +
                "temp=" + temp +
                ", humidity=" + humidity +
                ", cloudiness=" + cloudiness +
                ", windSpeed=" + windSpeed +
                ", pop=" + pop +
                ", instant='" + instant + '\'' +
                ", location=" + location +
                ", ts='" + ts + '\'' +
                ", ss='" + ss + '\'' +
                '}';
    }
}
