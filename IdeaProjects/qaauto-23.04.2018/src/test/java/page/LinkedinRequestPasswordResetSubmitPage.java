package page;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;


public class LinkedinRequestPasswordResetSubmitPage extends LinkedinBasePage{

        @FindBy(xpath = "//button[contains(@class,'resend__link')]")
        private WebElement resenLinkButton;
        @FindBy(id = "username")
        private WebElement emailField;


        public LinkedinRequestPasswordResetSubmitPage(WebDriver webDriver) {
            super(webDriver);
            PageFactory.initElements(this.webDriver, this);

        }

    public boolean isPageLoaded(){
        return resenLinkButton.isDisplayed();
    }
public LinkedinSetNewPasswordPage navigateToLinkFromEmail(){
    String messageSubject = "Tatyana, данное сообщение содержит ссылку для изменения пароля";
    String messageTo = "tatyana.muromtseva@gmail.com";
    String messageFrom = "security-noreply@linkedin.com";
    String message= gMailService.waitMessage(messageSubject, messageTo, messageFrom, 60);
    String resetPasswordLink = StringUtils.substringBetween(message,
            "To change your LinkedIn password, click <a href=\"",
            "\" style").replace("&amp;","&");


    System.out.println("Content: "+ resetPasswordLink);
    webDriver.get(resetPasswordLink);

    return new LinkedinSetNewPasswordPage(webDriver);
}

}




