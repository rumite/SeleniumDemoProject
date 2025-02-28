package webelements;

import helper.BaseTest;
import helper.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FindElements extends BaseTest {
    @BeforeMethod
    public void setUpTest() {
        setUp();
        driver.get("https://classic.freecrm.com/");
    }

    @Test
    public void findElementsTest() throws InterruptedException {

        List<WebElement> elements = WaitUtils.waitForAllElementsVisible(driver, By.className("form-control"), 10);
        elements.get(0).sendKeys("testusername");
        elements.get(1).sendKeys("tesetpassword");
        Thread.sleep(30000);
    }

    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }
}
