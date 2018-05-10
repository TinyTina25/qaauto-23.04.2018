import org.openqa.selenium.By;
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
                "https://www.linkedin.com/feed/",
                "Homepage URL is wrong");

        String actualHomePageTitle = webDriver.getTitle();

        Assert.assertNotEquals(actualLoginPageTitle, actualHomePageTitle,
                "Page title did not change after sign in");

        Assert.assertTrue(webDriver.getTitle().contains("LinkedIn"),
                "Login page title is wrong");



    }

}
