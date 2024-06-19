package workflow.homePage;

import pages.catalogPage.CatalogPage;
import pages.homePage.HomePage;
import utils.Driver;

import java.util.List;

public class WorkflowTests {

    public static Driver driver;
    private HomePage homePage;
    private CatalogPage catalogPage;

    public WorkflowTests()
    {
        driver = new Driver();
        homePage = new HomePage(driver);
    }

    public void goToTheShopTab(){
       homePage.clickOnShopTab();
       catalogPage = new CatalogPage(driver);
    }

    public void selectProduct(List<String> products){
        for(String product: products) {
            catalogPage.selectProducts(product);
        }
        catalogPage.clickOnCheckoutButton();
    }

}
