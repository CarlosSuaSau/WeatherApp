package org.example.control;

import org.example.model.Weather;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SQLiteWeatherStore implements WeatherStore{

    private static final String DB_URL = "jdbc:sqlite:store.db";
    private Connection connection;

    public SQLiteWeatherStore(){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DB_URL);
            createTables();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTables() {
        try {
            String[] islands = {"Tenerife", "GranCanaria", "Lanzarote", "Fuerteventura", "LaPalma", "ElHierro", "LaGomera", "LaGraciosa"};
            for (String island : islands) {
                String createTableQuery = "CREATE TABLE IF NOT EXISTS " + island + " ("
                        + "temperature DOUBLE NOT NULL,"
                        + "humidity INT NOT NULL,"
                        + "cloudiness INT NOT NULL,"
                        + "windSpeed DOUBLE NOT NULL,"
                        + "probOfPrecipitation DOUBLE NOT NULL,"
                        + "instant TEXT NOT NULL,"
                        + "latitude DOUBLE NOT NULL,"
                        + "longitude DOUBLE NOT NULL)";
                PreparedStatement preparedStatement = connection.prepareStatement(createTableQuery);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(List<Weather> weathers, String tableName) {
        clearTable(tableName);

        for (Weather weather : weathers) {
            insertWeather(weather, tableName);
        }
    }

    private void clearTable(String tableName) {
        try {
            String deleteQuery = "DELETE FROM " + tableName;

            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);

            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertWeather(Weather weather, String tableName) {
        String sql = "INSERT INTO " + tableName + " (temperature, humidity, cloudiness, windSpeed, probOfPrecipitation, instant, latitude, longitude) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, weather.getTemp());
            pstmt.setInt(2, weather.getHumidity());
            pstmt.setInt(3, weather.getCloudiness());
            pstmt.setDouble(4, weather.getWindSpeed());
            pstmt.setDouble(5, weather.getPop());
            pstmt.setString(6, String.valueOf(weather.getInstant()));
            pstmt.setDouble(7, weather.getLocation().getLatitude());
            pstmt.setDouble(8, weather.getLocation().getLongitude());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
