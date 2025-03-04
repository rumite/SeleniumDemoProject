package webelements;

import helper.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class XPathExtrasTwo extends BaseTest {
    @BeforeMethod
    public void setUpClass() {
        setUp();
        File file = new File("/Users/timur/Documents/projects/udemy_selenuim/SeleniumDemoProject/src/main/resources/XPathPart2.html");
        String filePath = "file:///" + file.getAbsolutePath();
        driver.get(filePath);
    }

    @Test
    public void independentXpath() {
        /*
        Что мы сделали тут:
        - //td[text()='QTP'] - нашли независимый элемент
        - /.. - поднялись наверх
        - нашли чекбокс с вайлдкартой *
         */

        driver.findElement(By.xpath("//td[text()='QTP']/..//*[@*='checkbox']"))
                .click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public void tearDownClass() {
        tearDown();
    }
}
