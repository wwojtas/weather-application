package pl.weather.model;

import com.maxmind.geoip2.DatabaseReader;
import pl.weather.model.config.ConfigMainSettings;

import java.io.IOException;
import java.io.InputStream;

public class ConnectionToDatabase {

    DatabaseReader getDatabaseReader(){
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(ConfigMainSettings.GEOLITE2_DATABASE_PATH);
        try {
            return new DatabaseReader.Builder(inputStream).build();
        } catch (IOException e) {
            return null;
        }
    }


}
