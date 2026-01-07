package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

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
    void tc01() {
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
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.cssSelector("#password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("input#password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("input[id=password]")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.cssSelector("input[type=password]")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("SuperSecretPassword!");
    }
}
