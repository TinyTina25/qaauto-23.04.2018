package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.LinkedinBasePage;

/**
 * LoginPage Class
 */
public class LinkedinLoginPage extends LinkedinBasePage {

    @FindBy(id = "login-email")
    private WebElement emailField;

    @FindBy(id = "login-password")
    private WebElement passwordField;

    @FindBy(id = "login-submit")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement errorMessage;
    @FindBy(xpath = "//a[contains(@class,'link-forgot-password')]")
    private WebElement forgotPasswordLink;


    /**
     * Constructor LinkedinLoginPage Class
     * @param webDriver
     */
    public LinkedinLoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Abstract method which check is right page loaded by specific web element
     * @return
     */
    public boolean isPageLoaded() {
        return signInButton.isDisplayed();
    }

    /**
     * metod for LOGIN. Depending on the params return different pages
     * @param email
     * @param password
     * @param <T> - generic type for returning any page
     * @return
     */
    public <T> T login(String email, String password) {
        waitUntilElementIsVisible(signInButton, 5);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        //return PageFactory.initElements(webDriver, LinkedinHomePage.class);//инициализация веб элементов и вызов конструктора
        if (getCurrentUrl().contains("/feed")) {
            return (T) new LinkedinHomePage(webDriver);
        }
        if (getCurrentUrl().contains("/login-submit")) {
            return (T) new LinkeinLoginSubmitPage(webDriver);
        } else {
            return (T) this;
        }

    }

    /** method opens LinkedinRequestPasswordResetPage
     * @return
     */
    public LinkedinRequestPasswordResetPage forgotPasswordLinkClick() {
        forgotPasswordLink.click();
        return  new LinkedinRequestPasswordResetPage(webDriver);
    }
}






