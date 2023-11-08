package Utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class configuration {
    private static final Properties properties = new Properties();

    static {
        try {
            InputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
            properties.load(inputStream);
        } catch (Exception exception) {
            exception.getStackTrace();
        }
    }

    public static String getURL() {
        return properties.getProperty("URL");
    }
    public static String getBrowser() {
        return properties.getProperty("browser");
    }
}
