package Workflow;

import pages.PageSearch;
import utils.Driver;

public class WorkflowTest {

    public static Driver driver = new Driver();

    private PageSearch pageSearch = new PageSearch(driver);

    public void searchTextAtGoogle(String searchText){
        pageSearch.EnterTextIntoSearchInput(searchText);
        pageSearch.ClickSearchButton();
    }

}
