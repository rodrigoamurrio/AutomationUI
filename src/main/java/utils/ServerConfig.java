package utils;

import lombok.Getter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ServerConfig {

    private final String QA_ENVIRONMENT = "qa";
    private final String DEV_ENVIRONMENT = "dev";
    private final String TEST_ENVIRONMENT = "test";
    private final String STAGING_ENVIRONMENT = "staging";
    private final String NO_ENVIRONMENT = " ";

    @Getter
    private Integer port;

    @Getter
    private Integer websocketPort;

    @Getter
    private String url;

    private Properties properties;

    public ServerConfig() {
        initialize();
    }

    private void initialize() {
        String environment = System.getProperty("env");
        environment = environment == null ? NO_ENVIRONMENT : environment;

        // App url
        switch (environment) {
            case QA_ENVIRONMENT:
                this.url = getProperties().getProperty("environment.qa");
                this.port = Integer.parseInt(getProperties().getProperty("port"));
                this.websocketPort = Integer.parseInt(getProperties().getProperty("websocketPort.qa"));
                break;
            case DEV_ENVIRONMENT:
                this.url = getProperties().getProperty("environment.dev");
                this.port = Integer.parseInt(getProperties().getProperty("port"));
                break;
            case TEST_ENVIRONMENT:
                this.url = getProperties().getProperty("environment.test");
                this.port = Integer.parseInt(getProperties().getProperty("port"));
                this.websocketPort = Integer.parseInt(getProperties().getProperty("websocketPort.test"));
                break;
            case STAGING_ENVIRONMENT:
                this.url = getProperties().getProperty("environment.staging");
                this.port = Integer.parseInt(getProperties().getProperty("port"));
                this.websocketPort = Integer.parseInt(getProperties().getProperty("websocketPort.test"));
                break;
            default:
                this.url = getProperties().getProperty("environment.default");
                this.port = Integer.parseInt(getProperties().getProperty("port"));
                this.websocketPort = Integer.parseInt(getProperties().getProperty("websocketPort.default"));
        }
    }

    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            try (InputStream input = new FileInputStream("src/test/resources/environment.properties")) {
                // load a properties file
                properties.load(input);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return properties;
    }
}
