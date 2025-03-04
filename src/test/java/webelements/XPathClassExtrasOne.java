package webelements;

import helper.BaseTest;
import helper.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class XPathClassExtrasOne extends BaseTest {
    @BeforeMethod
    public void setUpTests() {
        setUp();
        driver.get("https://classic.freecrm.com/");
        WaitUtils.waitForElementNotPresented(driver, By.id("preloader"), 10);
        System.out.println("Preloader passed");
    }

    @Test
    public void combinationOfTwoAttr() {
        WebElement usernameField = driver.findElement(By.xpath("//input[@type='text' and @name = 'username']"));
        usernameField.sendKeys("username");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void textAndXpath() {
        WebElement privacyLink = driver.findElement(By.xpath("//a[text()='Privacy Policy']"));
        privacyLink.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void parentChildRelations() {
        WebElement pricingLink = driver.findElement(By.xpath("//div[@id='navbar-collapse']//a[text()='Pricing']"));
        pricingLink.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void tearDownTests() {
        tearDown();
    }
}
