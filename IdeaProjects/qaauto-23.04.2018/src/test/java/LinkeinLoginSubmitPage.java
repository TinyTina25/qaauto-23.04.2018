import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import  org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LinkeinLoginSubmitPage extends LinkedinBasePage {


    @FindBy(xpath = "//div[@role='alert']")
    private WebElement errorMessage;
    @FindBy(id = "session_key-login")
    private WebElement emailField;
    public LinkeinLoginSubmitPage(WebDriver webDriver) {
        super(webDriver);
    PageFactory.initElements(webDriver, this);

    }

    public boolean isErrorMessageDisplayed(){
        return errorMessage.isDisplayed();
    }

public String getErrorMessageText(){
        return errorMessage.getText();
}
public boolean isPageLoaded(){
        return emailField.isDisplayed();
}
}
