package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GMailService;

/**
 * Class for base page
 */
public abstract class LinkedinBasePage {
    protected WebDriver webDriver;
    protected static GMailService gMailService = new GMailService();

    /**
     * Base Page class constructor
     * @param webDriver
     */
    public LinkedinBasePage (WebDriver webDriver){
        this.webDriver = webDriver ;
    }
    public String getCurrentUrl(){
        return webDriver.getCurrentUrl();
    }
    public String getCurrentTitle(){
        return webDriver.getTitle();
    }

    /**
     * Abstract method which check is right page loaded by specific web element
     * @return
     */
   abstract boolean isPageLoaded();

    /**
     * method wich wait timeout time while specific webelement became clicakble
     * @param webElement
     * @param timeOutInSeconds
     * @return
     */
    public WebElement waitUntilElementIsClickable (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }


    /**
     * method wich wait timeout time while specific webelement became visible
     * @param webElement
     * @param timeOutInSeconds
     * @return
     */
    public WebElement waitUntilElementIsVisible (WebElement webElement, int timeOutInSeconds)
    {

        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }




}
