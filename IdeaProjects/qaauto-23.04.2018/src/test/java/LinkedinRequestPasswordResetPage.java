import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinRequestPasswordResetPage extends LinkedinBasePage {
    @FindBy(id = "reset-password-submit-button")
    private WebElement resetPasswordSubmitButton;
    @FindBy(xpath = "//input[contains(@name,'userName')]")
    private WebElement userNameField;

    public LinkedinRequestPasswordResetPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    boolean isPageLoaded() {
        return resetPasswordSubmitButton.isDisplayed();

    }

    public LinkedinCheckPointPage userNameSubmit(String email) {
        userNameField.sendKeys(email);
        resetPasswordSubmitButton.click();
        return PageFactory.initElements(webDriver, LinkedinCheckPointPage.class);
    }
}

