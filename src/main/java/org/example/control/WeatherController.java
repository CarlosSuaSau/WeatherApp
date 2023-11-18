package org.example.control;

import org.example.model.Location;
import org.example.model.Weather;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class WeatherController {
    private final WeatherProvider provider;
    private final WeatherStore store;

    public WeatherController(WeatherStore store, WeatherProvider provider){
        this.store = store;
        this.provider = provider;
    }

    public WeatherProvider getProvider() {
        return provider;
    }

    public WeatherStore getStore() {
        return store;
    }

    public void runTask() throws IOException {
        Task();
    }
    public void Task(){
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Realizando la tarea...");
                Location granCanaria = new Location(28.139421644403107, -15.629770604586072, "Gran Canaria");
                Location tenerife = new Location(28.417265111220242, -16.545093079171146, "Tenerife");
                Location lanzarote = new Location( 29.014819077666854, -13.50023776954011, "Lanzarote");
                Location fuerteventura = new Location( 28.15635320893622, -14.232874221077148, "Fuerteventura");
                Location laPalma = new Location( 28.67485954290264, -17.944184684582225, "La Palma");
                Location laGomera = new Location( 28.04172650120714, -17.196680015527626, "La Gomera");
                Location elHierro = new Location( 27.641097920516973, -17.981739159206647, "El Hierro");
                Location laGraciosa = new Location( 29.261546327124854, -13.480270948293828, "La Graciosa");

                List<Weather> predictionsGC = provider.getWeather(granCanaria);
                List<Weather> predictionsTNF = provider.getWeather(tenerife);
                List<Weather> predictionsLNZ = provider.getWeather(lanzarote);
                List<Weather> predictionsFTV = provider.getWeather(fuerteventura);
                List<Weather> predictionsLP = provider.getWeather(laPalma);
                List<Weather> predictionsLG = provider.getWeather(laGomera);
                List<Weather> predictionsEH = provider.getWeather(elHierro);
                List<Weather> predictionsLGr = provider.getWeather(laGraciosa);

                List<List<Weather>> predictions = new ArrayList<>();
                predictions.add(predictionsGC);
                predictions.add(predictionsTNF);
                predictions.add(predictionsLNZ);
                predictions.add(predictionsFTV);
                predictions.add(predictionsLP);
                predictions.add(predictionsLG);
                predictions.add(predictionsEH);
                predictions.add(predictionsLGr);

                for (int i=0; i < predictions.size(); i++){
                    for (int j=0; j < predictions.get(i).size(); j++){
                        System.out.println(predictions.get(i).get(j).toString());
                    }
                    System.out.println("");
                }

                store.save(predictionsGC, "GranCanaria");
                store.save(predictionsTNF, "Tenerife");
                store.save(predictionsLNZ, "Lanzarote");
                store.save(predictionsFTV, "Fuerteventura");
                store.save(predictionsLP, "LaPalma");
                store.save(predictionsLG, "LaGomera");
                store.save(predictionsEH, "ElHierro");
                store.save(predictionsLGr, "LaGraciosa");

                System.out.println("Tabla de datos actualizada");

                try {
                    Thread.sleep(3600 * 1000 * 6);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        timer.schedule(task, 0, 3600 * 1000 * 6);
    }
}
