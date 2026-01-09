package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class EnableDisableTextFieldTest {
    @Test
    void verifyTextFieldDisable() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//form[@id='input-example']//button")).click();
//        Thread.sleep(5000);
        Assert.assertTrue(wait
                .until(ExpectedConditions.elementToBeClickable(By
                        .xpath("//form[@id='input-example']/input"))).isEnabled());
        driver.quit();
    }


}
