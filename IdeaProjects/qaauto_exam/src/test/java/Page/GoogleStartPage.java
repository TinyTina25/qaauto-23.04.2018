package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleStartPage extends GoogleBasePage{
    @FindBy(id="lst-ib")
    private WebElement searchField;
    public GoogleStartPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }
        public boolean isPageLoaded(){
            return searchField.isDisplayed();
        }
        public GoogleSearchResultsPage search (String searchTerm){
            searchField.sendKeys(searchTerm);
            searchField.submit();
            return new GoogleSearchResultsPage(webDriver);

        }



    }

