package Test;

import Page.GoogleSearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GoogleSearchTest extends GoogleBaseTest {
@Test
    public void GoogleSearchTest(){
    String searchTerm="selenium";
    GoogleSearchResultsPage googleSearchResultsPage = googleStartPage.search(searchTerm);
    Assert.assertTrue(googleSearchResultsPage.isPageLoaded(), "Page with search results not loaded");
    List<String> searchResultsList = googleSearchResultsPage.getSearchResults();
    Assert.assertEquals(searchResultsList.size(), 10,
            "Count of search results item is wrong.");
    for (String searchResult:searchResultsList) {
        Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                "Searchterm "+searchTerm+" was not found in: \n"+searchResult);
    }
    googleSearchResultsPage.switchToSecondSearchResultsPage();
                  Assert.assertEquals(googleSearchResultsPage.getCurrentPageNumber(), "2",
                    "Pages do not match");
    Assert.assertEquals(searchResultsList.size(), 10,
            "There are less than 10 results have been found on the second page");

    for (String searchResult :searchResultsList) {
        Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                "Searchterm "+searchTerm+" was not found in: \n"+searchResult);  }


    }

}
