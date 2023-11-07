package org.example.control;

public class Main {
    OpenWeatherMap tiempo = new OpenWeatherMap();
    Sql database = new Sql();

    WeatherController control = new WeatherController(tiempo, database, locations);
}