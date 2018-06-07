package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LinkedinSearchResultsPage extends LinkedinBasePage{
    @FindBy(xpath = "//h3[contains(@class,'search-results__total')]")
      private WebElement searchResultsCount ;
    @FindBy(xpath = "//li[contains(@class, 'search-result search-result__occluded-item')]")
    private List<WebElement> searchResultElements;

         public LinkedinSearchResultsPage(WebDriver webDriver) {
             super(webDriver);
                          PageFactory.initElements(webDriver, this);
             waitUntilElementIsClickable(searchResultsCount, 5);

             }
    public boolean isPageLoaded() {
        return searchResultsCount.isDisplayed();
    }

    public List<String> getSearchResults() {
        List<String> searchResultsList = new ArrayList();
        for(WebElement searchResultElements : searchResultElements){
            ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", searchResultElements);
            String searchResultText = searchResultElements.getText();
            searchResultsList.add(searchResultText);
        }
        return searchResultsList;



        }




}

