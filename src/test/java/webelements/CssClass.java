package webelements;

import helper.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CssClass extends BaseTest {
    @BeforeMethod
    public void setUpTest() {
        setUp();
        driver.get("https://facebook.com");
    }

    @Test
    public void cssIDLocator() {
        WebElement emailField = driver.findElement(By.cssSelector("input#email"));
        emailField.sendKeys("foo@bar.com");
    }

    @Test
    public void cssClassLocator() {
        // Сорри, такой локатор выбирать нельзя, но это всего лишь демонстрация
        WebElement emailField = driver.findElement(By.cssSelector("._6luy"));
        emailField.sendKeys("passw0rd");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void cssAttributeLocator() {
        WebElement signUpBtn = driver.findElement(By.cssSelector("[data-testid=open-registration-form-button]"));
        signUpBtn.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }

}
