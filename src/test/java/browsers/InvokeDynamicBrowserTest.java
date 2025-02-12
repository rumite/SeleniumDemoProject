package browsers;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class InvokeDynamicBrowserTest {

    public WebDriver driver = null;

    @Parameters("browser")
    @BeforeMethod
    public void openBrowser(String browser) {
        switch(browser.toLowerCase()) {
            case "chrome" -> {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--user-data-dir=\"/Users/timur/Library/Application Support/Google/Chrome/Profile 13\"");

                // Ignore certificate errors
                chromeOptions.addArguments("ignore-certificate-errors");

                //Use proxy
                /*
                Proxy proxy = new Proxy();
                proxy.setHttpProxy("proxy.example.com:8080");
                chromeOptions.setCapability("proxy", proxy);
                 */

                //chromeOptions.addArguments("--incognito");

                driver = new ChromeDriver(chromeOptions);
            }
            case "firefox" -> driver = new FirefoxDriver();
            case "safari" -> driver = new SafariDriver();
            default -> {
                System.out.println("Couldn't find this browser, using Chrome");
                driver = new ChromeDriver();
            }
        }
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void quitBrowser() {
        driver.quit();
    }

    @Test
    public void verifyGoogleTitle() {
        driver.get("https://google.com");
        String title = driver.getTitle();
        Assert.assertEquals(title, "Google");
    }

    @Test
    public void verifyCACError() throws InterruptedException {
        driver.get("https://expired.badssl.com");
        Thread.sleep(3000);
    }
}
