package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SafariTest {
    @Test
    void openWithSafari(){
        WebDriver driver = new SafariDriver();
        driver.get("https://www.icloud.com");
        Assert.assertEquals(driver.getTitle(),"iCloud");
        driver.quit();
    }
}
