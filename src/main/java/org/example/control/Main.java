package org.example.control;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce a valid apikey:");
        String password = scanner.nextLine();

        OpenWeatherMap provider = new OpenWeatherMap(password);

        SQLiteWeatherStore myStore = new SQLiteWeatherStore();

        WeatherController controller = new WeatherController(myStore, provider);
        controller.runTask();

    }
}