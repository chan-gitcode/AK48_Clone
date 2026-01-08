package moatazeldebsy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxMoatazTest {
    WebDriver driver;

    @BeforeClass
    void setUp(){
        driver = new ChromeDriver();
    }

    @BeforeMethod
    void reloadPage(){
        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/checkboxes");
    }

    @Test
    void checkBoxShouldSelectd(){
        WebElement checkbox1 = driver.findElement(By
                .xpath("//input[@data-test='checkbox-checkbox1']"));
        check(checkbox1);

        WebElement checkbox2 = driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox2']"));
        check(checkbox2);

        WebElement checkbox3 = driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox3']"));
        check(checkbox3);

        Assert.assertTrue(driver.findElement(By
                .xpath("//input[@data-test='checkbox-checkbox1']")).isSelected());
        Assert.assertTrue(driver.findElement(By
                .xpath("//input[@data-test='checkbox-checkbox2']")).isSelected());
        Assert.assertTrue(driver.findElement(By
                .xpath("//input[@data-test='checkbox-checkbox3']")).isSelected());
    }

    @Test
    void checkBoxShouldUnselect(){
        WebElement checkbox1 = driver.findElement(By
                .xpath("//input[@data-test='checkbox-checkbox1']"));
        uncheck(checkbox1);

        WebElement checkbox2 = driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox2']"));
        uncheck(checkbox2);

        WebElement checkbox3 = driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox3']"));
        uncheck(checkbox3);

        Assert.assertFalse(driver.findElement(By
                .xpath("//input[@data-test='checkbox-checkbox1']")).isSelected());
        Assert.assertFalse(driver.findElement(By
                .xpath("//input[@data-test='checkbox-checkbox2']")).isSelected());
        Assert.assertFalse(driver.findElement(By
                .xpath("//input[@data-test='checkbox-checkbox3']")).isSelected());
    }

    @Test
    void verifyCheckAllButton(){
        driver.findElement(By.xpath("//button[@data-test='check-all-button']")).click();

        Assert.assertTrue(driver.findElement(By
                .xpath("//input[@data-test='checkbox-checkbox1']")).isSelected());
        Assert.assertTrue(driver.findElement(By
                .xpath("//input[@data-test='checkbox-checkbox2']")).isSelected());
        Assert.assertTrue(driver.findElement(By
                .xpath("//input[@data-test='checkbox-checkbox3']")).isSelected());
    }

    @Test

    void verifyUncheckAllButton(){
        driver.findElement(By.xpath("//button[@data-test='uncheck-all-button']")).click();

        Assert.assertFalse(driver.findElement(By
                .xpath("//input[@data-test='checkbox-checkbox1']")).isSelected());
        Assert.assertFalse(driver.findElement(By
                .xpath("//input[@data-test='checkbox-checkbox2']")).isSelected());
        Assert.assertFalse(driver.findElement(By
                .xpath("//input[@data-test='checkbox-checkbox3']")).isSelected());
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }

    void check(WebElement checkbox){
        if (!checkbox.isSelected()){
            checkbox.click();
        }
    }

    void uncheck(WebElement checkbox){
        if (checkbox.isSelected()){
            checkbox.click();
        }
    }
}
