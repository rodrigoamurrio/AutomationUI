import Workflow.WorkflowTest;
import common.BasePage;
import org.junit.After;
import org.junit.Test;

public class FirstTest extends BasePage {

    WorkflowTest workflowTest = new WorkflowTest();

    @Test
    public void searchTextTest() throws InterruptedException {

        workflowTest.searchTextAtGoogle("pinguino");
        Thread.sleep(3000);
    }

    @After
    public void tearDownTest(){

        workflowTest.driver.closeDriver();
    }


}
