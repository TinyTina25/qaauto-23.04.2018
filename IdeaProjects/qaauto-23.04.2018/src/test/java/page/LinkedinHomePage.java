package page;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class for Home page
 */
public class LinkedinHomePage extends LinkedinBasePage{
           @FindBy(xpath = "//li[@id='profile-nav-item']")
            private WebElement profileNavItem;

        @FindBy(xpath = "//input[@placeholder='Search']")
        private WebElement searchField;

    /**
     * Constructor of LinkedinHomePage class
     * @param webDriver
     */
        public LinkedinHomePage(WebDriver webDriver) {
            super(webDriver);
            waitUntilElementIsVisible(searchField, 10);
            PageFactory.initElements(webDriver, this);
        }


    /**
     * Abstract method which check is right page loaded by specific web element
     */
    public boolean isPageLoaded() {
            return profileNavItem.isDisplayed();
        }

    /**
     * Method for searching searchTerm. returns LinkedinSearchResultsPage
     * @param searchTerm
     * @return
     */
    public LinkedinSearchResultsPage search(String searchTerm) {
                searchField.sendKeys(searchTerm);
                searchField.sendKeys(Keys.RETURN);
                return new LinkedinSearchResultsPage(webDriver);
            }
}




