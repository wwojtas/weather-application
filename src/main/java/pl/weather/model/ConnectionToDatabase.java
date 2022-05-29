package pl.weather.model;

import com.maxmind.geoip2.DatabaseReader;
import pl.weather.model.config.ConfigMainSettings;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ConnectionToDatabase {

    DatabaseReader getDatabaseReader(){
        ClassLoader classLoader = getClass().getClassLoader();
//        File databaseFile = new File(classLoader.getResource(ConfigMainSettings.GEOLITE2_DATABASE_PATH).getFile());
        File databaseFile = new File(Objects.requireNonNull(classLoader.getResource(ConfigMainSettings.GEOLITE2_DATABASE_PATH)).getFile());
        try {
            return new DatabaseReader.Builder(databaseFile).build();
        } catch (IOException e) {
           return null;
        }
    }


}
