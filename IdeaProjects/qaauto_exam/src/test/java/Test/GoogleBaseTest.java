package Test;

import Page.GoogleStartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class GoogleBaseTest {
WebDriver webDriver;
GoogleStartPage googleStartPage;

    @BeforeMethod

 public void before() {
        webDriver = new FirefoxDriver();
        //webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("https://www.google.com/");
        googleStartPage = new GoogleStartPage(webDriver);
    }
    @AfterMethod
        public void after() {
            webDriver.close();
        }
    }

