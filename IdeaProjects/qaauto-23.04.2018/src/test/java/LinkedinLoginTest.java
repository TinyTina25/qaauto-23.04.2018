import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {
    @Test
    public void successfulLoginTest() throws InterruptedException {
        WebDriver webDriver = new FirefoxDriver();//открыли новый браузер
        webDriver.get("https://www.linkedin.com/");

//        Assert.assertEquals("a", "b", "Probably'a' is not equal to 'b'");
        String actualLoginPageTitle = webDriver.getTitle();
        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn: Войти или зарегистрироваться",
                "Login page title is wrong");
        Assert.assertEquals(webDriver.getCurrentUrl(),
                "https://www.linkedin.com/",
                "Current URL is wrong");
        // sleep(3000);
/*hometask ->
        WebElement emailField =
                webDriver.findElement(By.xpath("//input[contains(@class, 'login-email')]"));
        emailField.sendKeys("tatyana.muromtseva@gmail.com");

        WebElement passwordField =
                webDriver.findElement(By.xpath("//input[contains(@class, 'login-password')]"));
        passwordField.sendKeys("119143756126345711");

        WebElement signinButton =
        webDriver.findElement(By.xpath("//input[contains(@class, 'login submit-button')]"));
        signinButton.click();
        sleep(3000);
        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn",
                "Page title is wrong");
        sleep(3000);

*/
/*
//hometask in class
     WebElement emailField =  webDriver.findElement(By.id("login-email"));
     WebElement passwordField =  webDriver.findElement(By.id("login-password"));
     WebElement signinButton  = webDriver.findElement(By.id("login-submit"));

        Assert.assertTrue(signinButton.isDisplayed(),
                "Sign in button is not displayed");


        emailField.sendKeys("tatyana.muromtseva@gmail.com");
    passwordField.sendKeys("119143756126345711");
    signinButton.click();

        Assert.assertEquals(webDriver.getCurrentUrl(),
                "https://www.linkedin.com/feedx/",
                "Homepage URL is wrong");

        String actualHomePageTitle = webDriver.getTitle();

        Assert.assertNotEquals(actualLoginPageTitle, actualHomePageTitle,
                "Page title did not change after sign in");

        Assert.assertTrue(webDriver.getTitle().contains("LinkedIn"),
                "Login page title is wrong");
*/
// HOMETASK 4. Negative tests
        // 4.1. Login with email wrong format and correct pass



        WebElement emailField = webDriver.findElement(By.id("login-email"));
        emailField.sendKeys("tatyana.muromtseva,gmail.com");

        WebElement passwordField = webDriver.findElement(By.id("login-password"));
        passwordField.sendKeys("119143756126345711");

        WebElement signinButton = webDriver.findElement(By.xpath("//input[contains(@class, 'login submit-button')]"));
        signinButton.click();
        sleep(5000);
        WebElement wrongEmailMessage = webDriver.findElement(By.xpath("//span [(@class='error' and @id='session_key-login-error') ]"));
               Assert.assertTrue(wrongEmailMessage.isDisplayed(),
                       "Wrong email error message not displayed");
               sleep(3000);
/*
        // 4.2 Login with correct email and wrong pass
        webDriver.get("https://us.linkedin.com/");

                      // WebElement passwordField = webDriver.findElement(By.xpath("//input [@class='login-email' and contains(@type,'text')]"));
                       //WebElement emailField = webDriver.findElement(By.xpath("//input [@class='login-password' and contains(@type,'password')]"));
                       //WebElement signinButton= webDriver.findElement(By.xpath("//input [@class='login submit-button' and contains(@type,'submit')]"));
        emailField.sendKeys("tatyana.muromtseva@gmail.com");
        passwordField.sendKeys("zaq12wsx");
        signinButton.click();

        sleep(5000);
        WebElement wrongPasswordMessage = webDriver.findElement(By.xpath("//span [@class='error' and contains(@id,'session_password-login-error')]"));
        Assert.assertTrue(wrongPasswordMessage.isDisplayed(), "Wrong password message is not displayed!");
*/
        // 4.2 Login with empty fields login and password
        webDriver.get("https://us.linkedin.com/");
        signinButton.click();

    }

}
