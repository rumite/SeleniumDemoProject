package webelements;

import helper.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LocationDemo {
    private WebDriver driver = null;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void loginSmokeTest() throws InterruptedException {
        driver.get("https://www.codewars.com/");

        // Click Sign In
        WebElement loginBtn = driver.findElement(By.id("login-btn"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginBtn);

        // Verify title
        String expectedTitle = "Sign in | Codewars";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        // Fill credentials
        WebElement email = driver.findElement(By.id("user_email"));
        WebElement password = driver.findElement(By.id("user_password"));

        email.sendKeys(Config.get("codewars_login"));
        password.sendKeys(Config.get("codewars_password"));

        // Click Sign in
        WebElement signInBtn = driver.findElement(By.xpath("//button[text()='Sign in']"));
        signInBtn.click();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
