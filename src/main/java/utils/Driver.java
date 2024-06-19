package utils;
import common.BasePage;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class Driver extends BasePage {

    public static WebDriver driver;
    public ServerConfig serverConfig = new ServerConfig();

    public Driver(){

        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to(serverConfig.getUrl());
        if (driver == null) {
            log.info("Driver did not initialize correctly");
        }
    }

    public void closeDriver(){
        driver.quit();
        log.info("Driver closed");
    }

    public WebDriver getDriver()
    {
        return driver;
    }
}