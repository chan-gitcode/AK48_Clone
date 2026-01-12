package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HyperLinkTest {
 /*   TC04: Hyper link : Hyperlink - link text
    Open browser
    Navigate to https://the-internet.herokuapp.com/status_codes
    Click on "200"
    Then "200 status code" page appear
    Click on "go here"
    Click on "301"
    Then "301 status code" page appear
    Click on "go here"
    Click on "404"
    Then "404 status code" page appear
    Click on "go here"
    Click on "500"
    Then "500 status code" page appear
    Click on "go here"*/

    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    void setUp(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @BeforeMethod
    void reloadPage(){
        driver.get("https://the-internet.herokuapp.com/status_codes");
    }

    @Test
    void verifyAbleNavigateToLink(){
        // click link status code 200
        String href = driver.findElement(By.linkText("200")).getDomAttribute("href");
        driver.findElement(By.linkText("200")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/200");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("content"))));
        String content200 = driver.findElement(By.id("content")).getText();
        Assert.assertTrue(content200.contains("This page returned a 200 status code."));

        //301 test
        driver.navigate().back();
        driver.findElement(By.xpath("//a[@href='status_codes/301']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/301");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("content"))));
        String content301 = driver.findElement(By.id("content")).getText();
        Assert.assertTrue(content301.contains("This page returned a 301 status code."));

        //404 test
        driver.findElement(By.linkText("here")).click();
//        driver.findElement(By.xpath("//a[.='404'/@href]")).click();
        driver.findElement(By.xpath("//a[@href='status_codes/404']")).click();
        Assert.assertEquals("https://the-internet.herokuapp.com/status_codes/404",driver.getCurrentUrl());
        String content404 = driver.findElement(By.id("content")).getText();
        Assert.assertTrue(content404.contains("This page returned a 404 status code."));

        //500 test
        driver.findElement(By.linkText("here")).click();
        driver.findElement(By.xpath("//a[@href='status_codes/500']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/500");
        String content500 = driver.findElement(By.id("content")).getText();
        Assert.assertTrue(content500.contains("This page returned a 500 status code."));
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
