package utils;
import common.BasePage;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class Driver extends BasePage {

    public static WebDriver driver;

    public Driver(){

        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/");
        if (driver == null) {
            log.info("Driver did not initialize correctly");
        }
    }

    public void closeDriver(){
        driver.quit();
        log.info("Driver closed");
    }
}