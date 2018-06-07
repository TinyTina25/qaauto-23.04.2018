package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.LinkedinHomePage;
import page.LinkedinSearchResultsPage;

import java.util.List;

import static java.lang.Thread.sleep;

public class LinkedinSearchTest extends LinkedinBaseTest {
    @Test
    public void basicSearchTest(){
        String searchTerm = "hr";
        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login("tatyana.muromtseva@gmail.com", "119143756126345711");
        Assert.assertTrue(linkedinHomePage.isPageLoaded(),
                "Home page not loaded");
        LinkedinSearchResultsPage linkedinSearchResultsPage = linkedinHomePage.search(searchTerm);
         Assert.assertTrue(linkedinSearchResultsPage.isPageLoaded(),
        "Page not loaded");
        List<String> searchResultList = linkedinSearchResultsPage.getSearchResults();
        Assert.assertEquals(searchResultList.size(), 10,
                "Count of search results item is wrong.");
        for (String searchResult:searchResultList) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "Searchterm "+searchTerm+" was not found in: \n"+searchResult);
            }
    }


}



