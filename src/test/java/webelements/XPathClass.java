package webelements;

import helper.BaseTest;
import helper.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class XPathClass extends BaseTest {
    @BeforeMethod
    public void setUpTest() {
        setUp();
        driver.get("https://codewars.com");
    }

    @Test
    public void absoluteXPath() throws InterruptedException {
        WebElement getStartedBtn = driver.findElement(By.xpath("/html/body/div/main/header/div/div/div/div[1]/div/div[3]/a"));
        getStartedBtn.click();
        Thread.sleep(3000);
    }

    @Test
    public void relativeXPath() throws InterruptedException {
        WebElement getStartedBtn = driver.findElement(new By.ByXPath("//a[text()='Get Started']"));
        getStartedBtn.click();
        Thread.sleep(3000);
    }
}
