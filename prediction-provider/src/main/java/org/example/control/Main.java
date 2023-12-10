package org.example.control;

import org.apache.activemq.ActiveMQConnection;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce a valid apikey:");
        String password = scanner.nextLine();

        OpenWeatherMapProvider myProvider = new OpenWeatherMapProvider(password);

        ActiveMQSender mySender = new ActiveMQSender("topic:prediction.Weather", "tcp://localhost:61616");

        WeatherController controller = new WeatherController(mySender, myProvider);
        controller.runTask();
    }
}