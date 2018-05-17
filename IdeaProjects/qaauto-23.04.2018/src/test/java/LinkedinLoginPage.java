import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginPage {
    private WebDriver webDriver;

    private WebElement EmailField = webDriver.findElement(By.xpath("//input [@class='login-email' and contains(@type,'text')]"));
    private WebElement PasswordField = webDriver.findElement(By.xpath("//input [@class='login-password' and contains(@type,'password')]"));
    private WebElement signinButton = webDriver.findElement(By.xpath("//input [@class='login submit-button' and contains(@type,'submit')]"));

    public void login(String email, String password) {
        EmailField.sendKeys(email);
        PasswordField.sendKeys(password);
        signinButton.sendKeys(Keys.ENTER);
    }

}
