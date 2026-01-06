package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirefoxTest {
    @Test
    void openWithDefaultMode() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.icloud.com");
        Assert.assertEquals(driver.getTitle(), "iCLoud");
        driver.quit();
    }

    @Test
    void openWithHeadlessMode(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("-headless");
        WebDriver driver = new FirefoxDriver(firefoxOptions);
        driver.get("https://www.icloud.com");
        Assert.assertEquals(driver.getTitle(),"iCloud");
//        driver.quit();
    }

}
