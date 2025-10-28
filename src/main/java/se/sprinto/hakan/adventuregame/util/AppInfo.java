package se.sprinto.hakan.adventuregame.util;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class AppInfo {
    private static AppInfo INSTANCE;
    private final Properties properties;

    private AppInfo() {
        properties = new Properties();

        try (InputStream input = getClass().getClassLoader().getResourceAsStream("app.properties")) {
            if (input == null) {
                System.out.println("Kan inte hitta app.priorities!");
                return;
            }
            properties.load(input);
        } catch  (IOException e) {
            e.printStackTrace();
        }
    }
    public static AppInfo getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AppInfo();
        }
        return INSTANCE;
    }
    public String getAuthor() {
        return properties.getProperty("app.author", "Unknown");
    }
    public String getVersion() {
        return properties.getProperty("app.version", "Unknown");
    }
}
