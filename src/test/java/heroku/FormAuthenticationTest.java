package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import javax.xml.namespace.QName;
import java.awt.desktop.OpenFilesEvent;

public class FormAuthenticationTest {
    //    TC01: Form  Authentication :  Login successful with valid credentials
//    Open browser
//    Navigate to https://the-internet.herokuapp.com/login
//    Fill in username with tomsmith
//    Fill in the password with SuperSecretPassword!
//    Click on Login button
//    And the home page is appear
    @Test
    void tc01() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
//        driver.findElement(By.tagName("input")).sendKeys("tomsmith");
//        driver.findElement(By.id("username")).sendKeys("tomsmith");
//        driver.findElement(By.name("username")).sendKeys("tomsmith");

//        driver.findElement(By.cssSelector("[type = text]")).sendKeys("tomsmith");
//        driver.findElement(By.cssSelector("input[type = text]")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tomsmith");
//
//        driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
//        driver.findElement(By.cssSelector("input#username")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//*@id='username'")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
//
//        driver.findElement(By.cssSelector("[name = username]")).sendKeys("tomsmith");
//        driver.findElement(By.cssSelector("input[name=username]")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith");

//        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
//
//        driver.findElement(By.cssSelector("#password")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.cssSelector("input#password")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.cssSelector("input[id=password]")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
//
//        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.xpath("//input[contains(@name,'password')]"));
//
//        driver.findElement(By.cssSelector("input[type=password]")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//input[@type='password']"))
                .sendKeys("SuperSecretPassword!");

//        driver.findElement(By.tagName("button")).click();
//        driver.findElement(By.className("radius")).click();
//        driver.findElement(By.cssSelector(".radius"));
//        driver.findElement(By.cssSelector("[type=submit]")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(5000);

        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure");
        Assert.assertTrue(driver.findElement(By.tagName("h4"))
                .getText()
                .contains("Welcome to the Secure Area. When you are done click logout below."));

        driver.quit();

//        <label for="username"> Username</label>
//        //label[.='Username']
//        //input[@id='username']/preceding-sibling::label/../input
//        //label[.='Username']/following-sibling::input
//        //Label[.='Username']/../input

//        By usernameInput = RelativeLocator
//                .with(By.tagName("input"))
//                .below(By.xpath("//label[.='Username']"));
    }
}
