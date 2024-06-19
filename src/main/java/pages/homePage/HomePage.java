package pages.homePage;

import common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Driver;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@class='nav-link' and contains(text(),'Shop')]")
    private WebElement shopTab;

    @FindBy(xpath = "//h1[contains(text(),'Protractor Tutorial')]")
    private WebElement homePageContainer;


    public HomePage(Driver pageDriver) {
        super(pageDriver);
        waitForElementVisible(homePageContainer);
    }

    public void clickOnShopTab(){
        clickElement(shopTab);
    }


}
