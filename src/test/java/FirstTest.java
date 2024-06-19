import common.BasePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import workflow.homePage.WorkflowTests;

import java.util.ArrayList;
import java.util.List;

public class FirstTest extends BasePage {

    public WorkflowTests workflowTests;

    @BeforeEach
    public void startup(){
        workflowTests = new WorkflowTests();
    }

    @Test
    public void purchaseNokiaCellPhone() throws InterruptedException {

        List<String> cellPhoneList = new ArrayList<>();
        cellPhoneList.add("Nokia");
        workflowTests.goToTheShopTab();
        workflowTests.selectProduct(cellPhoneList);
        Thread.sleep(10000);

    }

    @Test
    public void purchaseTwoCellPhone() throws InterruptedException {

        List<String> cellPhoneList = new ArrayList<>();
        cellPhoneList.add("Nokia");
        cellPhoneList.add("Samsung");
        workflowTests.goToTheShopTab();
        workflowTests.selectProduct(cellPhoneList);
        Thread.sleep(10000);

    }

    @AfterEach
    public void tearDownTest(){
       workflowTests.driver.closeDriver();
    }


}
