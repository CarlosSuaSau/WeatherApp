package org.example;

public class Main {
    public static String url = "tcp://localhost:61616";
    public static String subject = "topic:prediction.Weather";
    public static String path = "eventstore/prediction.Weather/%s/%s.events";
    public static void main(String[] args){
        BrokerSuscriptor suscriptor = new BrokerSuscriptor(subject, url);
        EventStorer storer = new EventStorer(path);
        EventController controller = new EventController(suscriptor, storer);
        controller.run();
    }
}