package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LinkedinHomePage;
import page.LinkedinLoginPage;
import page.LinkeinLoginSubmitPage;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest extends LinkedinBaseTest {


    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                { "tatyana.muromtseva@gmail.com", "119143756126345711" },
//                { "TATYANA.MUROMTSEVA@GMAIL.COM", "119143756126345711" }

        };
    }

    /**
     * Class for successful login tests. Takes params from DataProvider
     * @param email
     * @param password
     * @throws Exception
     */
    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String email, String password) throws Exception {

        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page title is wrong");


        //lesson5
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login page is not loaded");


        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login(email, password);
        sleep(5000);
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

    /**
     * Negative login test. @params from DataProvider
     * @param email
     * @param password
     * @throws InterruptedException
     */
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



        Assert.assertTrue(linkeinLoginSubmitPage.isPageLoaded(),
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

    /**
     * Negative test cases with empty parameter
     * @param email
     * @param password
     * @throws InterruptedException
     */
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













