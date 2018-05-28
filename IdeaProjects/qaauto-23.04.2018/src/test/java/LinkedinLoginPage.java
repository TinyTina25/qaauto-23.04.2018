import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinLoginPage extends LinkedinBasePage{

    @FindBy(id = "login-email")
    private WebElement emailField;

    @FindBy(id ="login-password")
    private WebElement passwordField;

    @FindBy (id="login-submit")
    private WebElement signinButton;

    @FindBy(xpath ="//div[@role='alert']" )
    private WebElement errorMessage;

    public LinkedinLoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);

    }




    public LinkedinHomePage login(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signinButton.click();
        return PageFactory.initElements(webDriver, LinkedinHomePage.class);
    }
    public boolean isSignInButtonDisplayed(){
       return signinButton.isDisplayed();
    }

    public boolean isErrorMessageDisplayed(){
        return errorMessage.isDisplayed();
    }

    public void emptyLogin(){
        signinButton.click();
    }

    public LinkeinLoginSubmitPage nologin (String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signinButton.sendKeys(Keys.ENTER);
        return PageFactory.initElements(webDriver, LinkeinLoginSubmitPage.class);
    }

    }

