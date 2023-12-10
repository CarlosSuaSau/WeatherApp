# WeatherApp
## Desarrollo de Aplicaciones para Ciencia de Datos
### 2º Curso    Ciencia e Ingeniería de Datos
### Escuela de Ingeniería Informática     ULPGC


## Functionality
This program uses data provided by an API to obtain the weather forecast for 12pm of the following 5 days, in the 8 Canary Islands.
The data obtained is sended to an ActiveMQ broker. The information of the broker is updated every 6 hours.
The program also contains a module to read the messages in the broker and write the information in a .events file.

## Resources
The program was entirely written in IntelliJ Idea, by Jet Brains.
The programming language of this program is Java, version 17.
The control version system used in developing this program is Git, and GitHub for its remote storage.
The API REST consumed in this program is 5 Day / 3h Forecast, by OpenWeatherMap.

## Design
As the model of the program, there is a class Weather. Each Weather object represents an event, as it has 
a content (temperature, humidity, cloudiness, wind speed, probability of precipitations), a time (instant), and a location.
Location is a class that represents the latitude, longitude and the island we are observing.

The main class has the purpose of creating the objects that are going to provide, control and store the data we obtain.
It asks for an api key when executed. In case the key introduced is right, it will create a WeatherProvider, a WeatherStore, and a WeatherController,
and finally, run the controller task. 

The task will run once the program is executed, and then 6 hours after execution starts. 
The controller task creates the location object of each island, then calls the WeatherProvider to obtain the weather list for each island.
Then, the information of the Weather objects created is sent as a Json String to the ActiveMQ broker.

The event store builder has the purpose of receiving the messages of the broker as a suscriptor, and create the files where the Json messages are written.
The files are named after the date of their time stamp.







