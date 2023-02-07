package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try {
            // Load the properties file
            FileInputStream fileInputStream = new FileInputStream("config.properties");
            // Read the file
            properties.load(fileInputStream);
            // Close the file
            fileInputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
