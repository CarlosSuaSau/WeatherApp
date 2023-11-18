package org.example.control;

import org.example.model.Location;
import org.example.model.Weather;

import java.io.IOException;
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

        // Crea una tarea (TimerTask) que define la tarea a realizar
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // Coloca aquí la lógica de la tarea que quieres realizar
                System.out.println("Realizando la tarea...");
                Location granCanaria = new Location(28.139421644403107, -15.629770604586072, "Gran Canaria");
                Location tenerife = new Location(28.417265111220242, -16.545093079171146, "Tenerife");
                Location lanzarote = new Location( 29.014819077666854, -13.50023776954011, "Lanzarote");
                Location fuerteventura = new Location( 28.15635320893622, -14.232874221077148, "Fuerteventura");
                Location laPalma = new Location( 28.67485954290264, -17.944184684582225, "La Palma");
                Location laGomera = new Location( 28.04172650120714, -17.196680015527626, "La Gomera");
                Location elHierro = new Location( 27.641097920516973, -17.981739159206647, "El Hierro");
                Location laGraciosa = new Location( 29.261546327124854, -13.480270948293828, "La Graciosa");

                List<Weather> prediccionesGC = provider.getWeather(granCanaria);
                List<Weather> prediccionesTNF = provider.getWeather(tenerife);
                List<Weather> prediccionesLNZ = provider.getWeather(lanzarote);
                List<Weather> prediccionesFTV = provider.getWeather(fuerteventura);
                List<Weather> prediccionesLP = provider.getWeather(laPalma);
                List<Weather> prediccionesLG = provider.getWeather(laGomera);
                List<Weather> prediccionesEH = provider.getWeather(elHierro);
                List<Weather> prediccionesLGr = provider.getWeather(laGraciosa);

                store.save(prediccionesGC, "GranCanaria");
                store.save(prediccionesTNF, "Tenerife");
                store.save(prediccionesLNZ, "Lanzarote");
                store.save(prediccionesFTV, "Fuerteventura");
                store.save(prediccionesLP, "LaPalma");
                store.save(prediccionesLG, "LaGomera");
                store.save(prediccionesEH, "ElHierro");
                store.save(prediccionesLGr, "LaGraciosa");

                System.out.println("Tabla de datos actualizada");

                // Espera 6 horas antes de ejecutar la tarea nuevamente
                // (3600 segundos * 1000 milisegundos * 6 horas)
                try {
                    Thread.sleep(3600 * 1000 * 6);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Programa la tarea para ejecutarse cada 6 horas (3600 segundos * 1000 milisegundos * 6 horas)
        timer.schedule(task, 0, 3600 * 1000 * 6);
    }
}
