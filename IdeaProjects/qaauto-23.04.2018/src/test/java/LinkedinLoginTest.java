import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {
    WebDriver webDriver;

    @BeforeMethod
    public void before(){
        webDriver = new FirefoxDriver();
        webDriver.get("https://us.linkedin.com/");
    }
    @Test
    public void successfulLoginTest() throws InterruptedException {

//        Assert.assertEquals("a", "b", "Probably'a' is not equal to 'b'");
        String actualLoginPageTitle = webDriver.getTitle();
        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn: Войти или зарегистрироваться",
                "Login page title is wrong");
        Assert.assertEquals(webDriver.getCurrentUrl(),
                "https://www.linkedin.com/",
                "Current URL is wrong");

        //lesson5
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage();
        linkedinLoginPage.login("tatyana.muromtseva@gmail.com", "119143756126345711");
      /*  Assert.assertTrue(signinButton.isDisplayed(),
                "Sign in button is not displayed"); */
        sleep(3000);

        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn",
                "Page title is wrong");



        Assert.assertEquals(webDriver.getCurrentUrl(),
                "https://www.linkedin.com/feedx/",
                "Homepage URL is wrong");

        String actualHomePageTitle = webDriver.getTitle();

        Assert.assertNotEquals(actualLoginPageTitle, actualHomePageTitle,
                "Page title did not change after sign in");

        @Test
         public void negativeLoginTest() throws InterruptedException{



            String signUpTitle = webDriver.getTitle();
            Assert.assertEquals(webDriver.getTitle(), "LinkeIn: Login or Sign Up",
                    "Login page title is wrong");
            Assert.assertEquals(webDriver.getCurrentUrl(),"https://us.linkedin.com/",
                    "URL is wrong");
        }



        WebElement emailField = webDriver.findElement(By.id("login-email"));
        emailField.sendKeys("tatyana.muromtseva@gmail.com");

        WebElement passwordField = webDriver.findElement(By.id("login-password"));
        passwordField.sendKeys("1191437561263457111");

        WebElement signinButton = webDriver.findElement(By.xpath("//input[contains(@class, 'login submit-button')]"));
        signinButton.click();
        sleep(5000);
        String currentPageUrl = webDriver.getCurrentUrl();
        String currentPageTitle = webDriver.getTitle();
        Assert.assertEquals(currentPageUrl, "https://www.linkedin.com/aus/login-submit",
                "URL is wrong");
        Assert.assertEquals(currentPageTitle, "Sign in to LinkedIn", "Tile is wrong");

        WebElement errorMessage  webDriver.findElement(By.xpath("//div[@role='alert']"));
        Assert.assertEquals(errorMessage.getText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Wrong error message");
        webDriver.close();


        /*WebElement wrongEmailMessage = webDriver.findElement(By.xpath("//span [(@class='error' and @id='session_key-login-error') ]"));
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

        // 4.3 Login with empty fields login and password
        webDriver.get("https://us.linkedin.com/");
        signinButton.click();
*/




    }
@AfterMethod
    public void after(){
        webDriver.close();
}
}
