package pages;

import common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Driver;

public class PageSearch extends BasePage {

    @FindBy(id = "APjFqb")
    private WebElement searchInput;

    @FindBy(name = "btnK")
    private WebElement searchButton;

    public PageSearch(Driver pageDriver) {
        super(pageDriver);
    }

    public void EnterTextIntoSearchInput(String text){
        setTextAs(searchInput, text);
    }

    public void ClickSearchButton(){
        clickElement(searchButton);
    }

}
