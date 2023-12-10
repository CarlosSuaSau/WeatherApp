package org.example.control;




public class Main {
    public static void main(String[] args) {
        String apiKey = args[0];
        OpenWeatherMapProvider myProvider = new OpenWeatherMapProvider(apiKey);
        ActiveMQSender mySender = new ActiveMQSender("topic:prediction.Weather", "tcp://localhost:61616");
        WeatherController controller = new WeatherController(mySender, myProvider);
        controller.runTask();
    }
}