import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginPage extends LinkedinBasePage{


    private WebElement emailField;
    private WebElement passwordField;
    private WebElement signinButton;
    private WebElement errorMessage;
    private WebElement emailErrorMessage;

    public LinkedinLoginPage(WebDriver webDriver) {
        super(webDriver);
        initElements();

    }
    public void initElements() {
        emailField = webDriver.findElement(By.xpath("//input [@class='login-email' and contains(@type,'text')]"));
        passwordField = webDriver.findElement(By.xpath("//input [@class='login-password' and contains(@type,'password')]"));
        signinButton = webDriver.findElement(By.xpath("//input [@class='login submit-button' and contains(@type,'submit')]"));
        errorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));

    }

    public void login(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signinButton.sendKeys(Keys.ENTER);
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
}
