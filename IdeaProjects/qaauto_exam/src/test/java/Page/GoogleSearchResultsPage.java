package Page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchResultsPage extends GoogleBasePage {
    @FindBy(xpath = "//div[contains(@class,'srg')]/div[\" + i + \"]")
    private List<WebElement> searchResultElements;

    @FindBy(id = "resultStats")
    private WebElement resultStats;

    @FindBy(xpath = "//a[@aria-label='Page 2']")
    private WebElement secondSearchResultPage;

    @FindBy(xpath = "//td[@class='cur']")
    private WebElement currentPage;

    public GoogleSearchResultsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        waitUntilElementIsVisible(resultStats, 5);
    }

    public boolean isPageLoaded() {
        return resultStats.isDisplayed();
    }

    public void switchToSecondSearchResultsPage() {
        secondSearchResultPage.click();

    }

    public List<String> getSearchResults() {
        List<String> searchResultsList = new ArrayList();
        for (WebElement searchResultElements : searchResultElements) {
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", searchResultElements);
            String searchResultText = searchResultElements.getText();
            searchResultsList.add(searchResultText);
        }
        return searchResultsList;

    }
    public String getCurrentPageNumber(){
               String currentPageNumber = currentPage.getText();
               return currentPageNumber;
    }

}

