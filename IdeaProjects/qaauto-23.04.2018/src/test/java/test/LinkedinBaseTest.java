package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.LinkedinLoginPage;

public class LinkedinBaseTest {
    WebDriver webDriver;
    LinkedinLoginPage linkedinLoginPage;
    @BeforeMethod
    public void before(String browser, String URLenv) {
        WebDriverManager.chromedriver().setup();
        if(browser.equalsIgnoreCase("Firefox" )) {
            webDriver = new FirefoxDriver();
        }
        else  {
            webDriver = new ChromeDriver();
        }
        if (URLenv.equalsIgnoreCase("https://us.linkedin.com/")) {
            webDriver.get("https://us.linkedin.com/");
        }
         if(URLenv.equalsIgnoreCase("https://www.linkedin.com/")){
             webDriver.get("https://www.linkedin.com/");

         }
         linkedinLoginPage = new LinkedinLoginPage(webDriver);

    }
    @AfterMethod

    public void after() {
        webDriver.close();
    }
}
