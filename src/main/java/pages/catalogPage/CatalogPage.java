package pages.catalogPage;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Driver;

import java.util.List;

public class CatalogPage extends BasePage {

    @FindBy(xpath = "//a[@class='nav-link btn btn-primary']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//app-card//h4")
    private List<WebElement> allProducts;

    private WebElement addCartButton(String index){
        return getWebDriver().getDriver().findElement(By.xpath(String.format("(//button[@class='btn btn-info'])[%s]", index)));
    }


    public CatalogPage(Driver pageDriver) {
        super(pageDriver);
    }

    public void clickOnCheckoutButton(){
        clickElement(checkoutButton);
    }

    public void selectProducts(String text){
        for (int i = 0; i < allProducts.size(); i++) {
            String a = allProducts.get(i).getText();
            if (allProducts.get(i).getText().contains(text)) {
                addCartButton(String.valueOf(i+1)).click();
                break;
            }
        }
    }
}
