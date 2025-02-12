package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class BrowserOptions {

    @Test
    public void chromeBrowserProfiling() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--user-data-dir=/Users/timur/Library/Application Support/Google/Chrome/Profile 13\n");

        WebDriver chromeDriver = new ChromeDriver(chromeOptions);
        chromeDriver.get("https://google.com");
        chromeDriver.quit();

    }

    public void firefoxBrowserProfiling() {

    }
}
