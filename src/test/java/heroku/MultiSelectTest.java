package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultiSelectTest {
    @Test
    void ableSelectMultipleOptions(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://output.jsbin.com/osebed/2");

        Select select = new Select(driver.findElement(By.id("fruits")));
        Assert.assertTrue(select.isMultiple());

        select.selectByVisibleText("Banana");
        select.selectByVisibleText("Apple");
        select.selectByVisibleText("Grape");

        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Option 1']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Option 2']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Option 3']")).isSelected());

    }
}
