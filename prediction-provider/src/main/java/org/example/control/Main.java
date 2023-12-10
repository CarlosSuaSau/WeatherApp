package org.example.control;

import org.apache.activemq.ActiveMQConnection;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce a valid apikey:");
        String password = scanner.nextLine();

        OpenWeatherMap myProvider = new OpenWeatherMap(password);

        ActiveMQSender mySender = new ActiveMQSender("topic:prediction.Weather", ActiveMQConnection.DEFAULT_BROKER_URL);

        WeatherController controller = new WeatherController(mySender, myProvider);
        controller.runTask();
    }
}