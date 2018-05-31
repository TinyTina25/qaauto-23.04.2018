import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
public class SuccessfulResetPasswordTest {
    WebDriver webDriver;

    @BeforeMethod
    public void before() {
        webDriver = new FirefoxDriver();
        //  webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.get("https://us.linkedin.com/");
    }
    @DataProvider
    public Object[][]validEmailProvider() {
        return new Object[][]{
                { "tatyana.muromtseva@gmail.com"}

        };
    }

    @Test(dataProvider="validEmailProvider")
    public void successfulResetPasswordTest(String email) throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login page not loaded");
        LinkedinRequestPasswordResetPage linkedinRequestPasswordResetPage = linkedinLoginPage.forgotPasswordClicked();
        Assert.assertTrue(linkedinRequestPasswordResetPage.isPageLoaded(),
                "Login Page is not loaded.");
        LinkedinCheckPointPage linkedinCheckPointPage = linkedinRequestPasswordResetPage.userNameSubmit(email);
    }
        @AfterMethod

        public void after () {
            webDriver.close();
        }
    }

