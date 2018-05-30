import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {
    WebDriver webDriver;

    @BeforeMethod
    public void before() {
        webDriver = new FirefoxDriver();
      //  webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.get("https://us.linkedin.com/");
    }
    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                { "tatyana.muromtseva@gmail.com", "119143756126345711" },
//                { "TATYANA.MUROMTSEVA@GMAIL.COM", "119143756126345711" }

        };
    }

    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String email, String password) throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page title is wrong");
        //lesson5
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login page is not loaded");


        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login(email, password);
        //sleep(5000);
        Assert.assertTrue(linkedinHomePage.isPageLoaded(),
                 "Login Page is not loaded.");
    }




    @DataProvider
    public Object[][] invalidDataProvider() {
        return new Object[][]{
                {"tatyana.muromtseva@@gmail.com", "119143756126345711"},
                {"TATYANA.MUROMTSEVA.GMAIL.COM", "119143756126345711"},
                {"tatyana.muromtseva@gmail.com", "1"},
                {"tatyana.muromtseva@gmail.com", "11111111111*&()"}
        };
    }

   @Test(dataProvider = "invalidDataProvider")


        public void negativeReturnToLoginSubmitTest (String email, String password)throws InterruptedException{


        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page title is wrong");
        Assert.assertEquals(linkedinLoginPage.getCurrentUrl(),
                "https://us.linkedin.com/",
                "URL is wrong");

        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Page not loaded");
        LinkeinLoginSubmitPage linkeinLoginSubmitPage = linkedinLoginPage.login(email, password);

//sleep(5000);


        Assert.assertEquals(linkeinLoginSubmitPage.getCurrentUrl(),
                "https://www.linkedin.com/uas/login-submit",
                "URL is wrong");
        Assert.assertEquals(linkeinLoginSubmitPage.getCurrentTitle(),
                "Sign In to LinkedIn",
                "Tile is wrong");

        Assert.assertTrue(linkeinLoginSubmitPage.isErrorMessageDisplayed(),
                "There were one or more errors in your submission. Please correct the marked fields below.");
    }

    @DataProvider
    public Object[][] emptyFieldDataProvider() {
        return new Object[][]{
                {"", "119143756126345711"},
                {"TATYANA.MUROMTSEVA@GMAIL.COM", ""},
                {"", ""}
        };

    }

    @Test(dataProvider = "emptyFieldDataProvider")


    public void emptyFieldLoginNegativeTest (String email, String password)throws InterruptedException{


        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page title is wrong");
        Assert.assertEquals(linkedinLoginPage.getCurrentUrl(),
                "https://us.linkedin.com/",
                "URL is wrong");

        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login page not loaded");
        linkedinLoginPage.login(email, password);

       // sleep(5000);


        Assert.assertEquals(linkedinLoginPage.getCurrentUrl(),
                "https://us.linkedin.com/",
                "URL is wrong");
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up",
                "Tile is wrong");
    }



    @AfterMethod

    public void after(){
        webDriver.close();
}


}













