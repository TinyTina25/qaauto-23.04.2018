import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {
    WebDriver webDriver;

    @BeforeMethod
    public void before() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://us.linkedin.com/");
    }

    @Test
    public void successfulLoginTest() throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page title is wrong");
        //lesson5
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "Sign in button is not displayed");

        linkedinLoginPage.login("tatyana.muromtseva@gmail.com", "119143756126345711");

        sleep(3000);
        LinkedinHomePage linkedinHomePage = new LinkedinHomePage(webDriver);
        Assert.assertEquals(linkedinHomePage.getCurrentUrl(),
                "https://www.linkedin.com/feed/",
                "Homepage URL is wrong");
        sleep(5000);
        Assert.assertTrue(linkedinHomePage.getCurrentTitle().contains("LinkedIn"),
                "Home page Title is wrong");



        }

   @Test
    public void negativeLoginTest() throws InterruptedException {


       LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
       Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
               "LinkedIn: Log In or Sign Up",
               "Login page title is wrong");
       Assert.assertEquals(linkedinLoginPage.getCurrentUrl(),
               "https://us.linkedin.com/",
               "URL is wrong");

       Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
               "Sign in button is not displayed");
       linkedinLoginPage.login("tatyana.muromtseva@gmail.com", "1");

       sleep(5000);


       Assert.assertEquals(linkedinLoginPage.getCurrentUrl(),
               "https://www.linkedin.com/uas/login-submit",
               "URL is wrong");
       Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
               "Sign In to LinkedIn",
               "Tile is wrong");

       sleep(3000);
       Assert.assertTrue(linkedinLoginPage.isErrorMessageDisplayed(),
               "There were one or more errors in your submission. Please correct the marked fields below.");
   }
        @Test
       public void emailEmptyFieldTest() throws InterruptedException{
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        sleep(3000);
        linkedinLoginPage.emptyLogin();
            Assert.assertEquals(linkedinLoginPage.getCurrentUrl(),
                    "https://us.linkedin.com/",
                    "URL is wrong");
            Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                    "LinkedIn: Log In or Sign Up",
                    "Tile is wrong");
            sleep(3000);

        }
        @Test
        public void negativeLoginTestWrongEmail() throws InterruptedException{
            LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
            linkedinLoginPage.login( "tatyana.muromtseva@mail.com", "119143756126345711");

            sleep(5000);


            Assert.assertEquals(linkedinLoginPage.getCurrentUrl(),
                    "https://www.linkedin.com/uas/login-submit",
                    "URL is wrong");
            Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                    "Sign In to LinkedIn",
                    "Tile is wrong");

            sleep(3000);
            Assert.assertTrue(linkedinLoginPage.isErrorMessageDisplayed(),
                    "There were one or more errors in your submission. Please correct the marked fields below.");
        }

@AfterMethod

    public void after(){
        webDriver.close();
}
}













