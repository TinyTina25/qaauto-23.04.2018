package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

public class LinkedinRequestPasswordResetPage extends LinkedinBasePage {
    @FindBy(id = "reset-password-submit-button")
    private WebElement submitButton;
    @FindBy(xpath = "//input[contains(@name,'userName')]")
    private WebElement userEmailField;

    public LinkedinRequestPasswordResetPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        String userEmail = "tatyana.muromtseva@gmail.com";

    }

    public static String gmailMessage;

    public boolean isPageLoaded() {
        return userEmailField.isDisplayed() ;

    }

    public LinkedinRequestPasswordResetSubmitPage submitUserEmail(String userEmail) {

        gMailService.connect();
        userEmailField.sendKeys(userEmail);
        submitButton.click();
        return new LinkedinRequestPasswordResetSubmitPage(webDriver);

    }

        }




