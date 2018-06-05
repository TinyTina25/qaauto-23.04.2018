package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LinkedinSetNewPasswordPage extends LinkedinBasePage {


    @FindBy(xpath = "//input[@id='newPassword']")
    private WebElement newUserPasswordField;
    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement confirmPasswordField;
    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement submitButton;

    public LinkedinSetNewPasswordPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }
    public boolean isPageLoaded(){
        return newUserPasswordField.isDisplayed();
    }

    public LinkedinSuccessfulPasswordResetPage submitNewPassword(String newUserPassword) {
        newUserPasswordField.sendKeys(newUserPassword);
        confirmPasswordField.sendKeys(newUserPassword);
        submitButton.click();
        return new LinkedinSuccessfulPasswordResetPage(webDriver);
    }
}