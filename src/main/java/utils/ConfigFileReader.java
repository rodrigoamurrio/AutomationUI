package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class  ConfigFileReader {

    private Properties properties;
    private final String configFilePath = "src/test/resources/conf/init.properties";

    private static final ConfigFileReader propObj = new ConfigFileReader();

    public static ConfigFileReader readerProperty() {
        return propObj;
    }

    public ConfigFileReader() {

        File ConfigFile = new File(configFilePath);
        try {
            FileInputStream configFileReader = new FileInputStream(ConfigFile);
            properties = new Properties();
            try {
                properties.load(configFileReader);
                configFileReader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("config.properties not found at config file path " + configFilePath);
        }

    }

    public String getBrowser() {
        String applicationUrl = properties.getProperty("browser");
        if (applicationUrl != null)
            return applicationUrl;
        else
            throw new RuntimeException("The browser is not recognized");
    }

    public String getUrl() {
        String applicationUrl = properties.getProperty("browser");
        if (applicationUrl != null)
            return applicationUrl;
        else
            throw new RuntimeException("The browser is not recognized");
    }

}
