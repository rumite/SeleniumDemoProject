package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DifferentBrowsersTest {
    @Test
    public void openWebSiteInChrome() {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();

        chromeDriver.get("https://google.com");

        String title = chromeDriver.getTitle();
        Assert.assertEquals(title, "Google");

        chromeDriver.quit();
    }

    @Test
    public void openWebSiteInFirefox() {
        WebDriver firefoxDriver = new FirefoxDriver();

        firefoxDriver.get("https://vk.com");

        String title = firefoxDriver.getTitle();
        Assert.assertEquals(title, "VK | Welcome!");

        firefoxDriver.quit();
    }

    @Test
    public void openWebSiteInSafari() {
        WebDriver safariDriver = new SafariDriver();
        safariDriver.get("https://facebook.com");

        String title = safariDriver.getTitle();
        Assert.assertEquals(title, "Facebook - log in or sign up");

        safariDriver.quit();
    }
}
