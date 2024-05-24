package common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.util.logging.Logger;


public abstract class BasePage {

    protected static final Logger log = Logger.getLogger(BasePage.class.getName());
    protected Driver pageDriver;

    public BasePage() {


    }

    public BasePage(Driver pageDriver) {
        this.pageDriver = pageDriver;
        PageFactory.initElements(pageDriver.driver, this);

    }

    protected void waitForElementClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(pageDriver.driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(pageDriver.driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void setTextAs(WebElement element, String text) {
        waitForElementClickable(element);
        element.sendKeys(text);
    }

    protected void clearElement(WebElement element) {
        waitForElementClickable(element);
        element.clear();
    }

    protected void clickElement(WebElement element) {
        waitForElementClickable(element);
        element.click();
    }

    protected void clickElementByJavascriptExecutor(String xpath) {
        WebElement element = pageDriver.driver.findElement(By.xpath(xpath));
        JavascriptExecutor ex = (JavascriptExecutor) pageDriver.driver;
        ex.executeScript("arguments[0].click()", element);
    }

    protected void clickLink(WebElement element) {
        waitForElementVisible(element);
        element.click();
    }

    protected String getText(WebElement element) {
        waitForElementVisible(element);
        return element.getText();
    }

    protected void freeze(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    protected Driver getWebDriver(){

        return this.pageDriver;

    }
}
