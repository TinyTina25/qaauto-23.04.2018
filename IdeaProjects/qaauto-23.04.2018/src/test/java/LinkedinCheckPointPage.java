import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinCheckPointPage extends LinkedinBasePage {

    @FindBy(xpath = "//button[contains(@class,'resend__link')]")
    private WebElement resendButton;


    public LinkedinCheckPointPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);

    }

    boolean isPageLoaded() {
        return resendButton.isDisplayed();
    }
}
