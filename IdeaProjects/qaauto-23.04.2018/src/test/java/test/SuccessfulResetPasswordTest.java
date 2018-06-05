package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.*;


import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
public class SuccessfulResetPasswordTest  extends LinkedinBaseTest{


@Test
    public void successfulResetPasswordTest(){
        String userEmail ="tatyana.muromtseva@gmail.com";
        String newUserPassword="P@ssword1234";
        LinkedinRequestPasswordResetPage linkedinRequestPasswordResetPage = linkedinLoginPage.forgotPasswordLinkClick();
        Assert.assertTrue(linkedinRequestPasswordResetPage.isPageLoaded(),
                "RequestPasswordResetPage is not loaded.");

        LinkedinRequestPasswordResetSubmitPage linkedinRequestPasswordResetSubmitPage =
                linkedinRequestPasswordResetPage.submitUserEmail(userEmail);
        Assert.assertTrue(linkedinRequestPasswordResetSubmitPage.isPageLoaded(),
                "RequestPasswordResetSubmitPage is not loaded.");

        LinkedinSetNewPasswordPage linkedinSetNewPasswordPage =
                linkedinRequestPasswordResetSubmitPage.navigateToLinkFromEmail();
        Assert.assertTrue(linkedinSetNewPasswordPage.isPageLoaded(),
                "SetNewPasswordPage is not loaded.");

        LinkedinSuccessfulPasswordResetPage linkedinSuccessfulPasswordResetPage =
                linkedinSetNewPasswordPage.submitNewPassword(newUserPassword);
        Assert.assertTrue(linkedinSuccessfulPasswordResetPage.isPageLoaded(),
                "SuccessfulPasswordResetPage is not loaded.");

        LinkedinHomePage linkedinHomePage =
                linkedinSuccessfulPasswordResetPage.clickOnGoToHomeButton();
        Assert.assertTrue(linkedinHomePage.isPageLoaded(),
                "HomePage is not loaded.");










    }


}

