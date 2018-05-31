import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    private WebElement forgotPassword;

    public LinkedinLoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

        public boolean isPageLoaded () {
            return signInButton.isDisplayed();
        }
        public <T > T login(String email, String password) {
            emailField.sendKeys(email);
            passwordField.sendKeys(password);
            signInButton.click();
            // return PageFactory.initElements(webDriver, LinkedinHomePage.class);//инициализация веб элементов и вызов конструктора
            if (getCurrentUrl().contains("/feed")) {
                return (T) new LinkedinHomePage(webDriver);
                }
            if (getCurrentUrl().contains("/login-submit")) {
                return (T) new LinkeinLoginSubmitPage(webDriver);
                        }

             else {
                return (T) this;
                }

        }
            public LinkedinRequestPasswordResetPage forgotPasswordClicked() {
                forgotPassword.click();
                return PageFactory.initElements(webDriver, LinkedinRequestPasswordResetPage.class);
    }

}


