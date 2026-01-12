package heroku;

import com.sun.source.tree.AssertTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownTest {
/*    TC03: DropDown : Select option
    Open browser
    Navigate to https://the-internet.herokuapp.com/dropdown
    Select "option 1"
    Validate "option 1" is selected*/

    WebDriver driver;

    @BeforeClass
    void setUp() {
        driver = new ChromeDriver();
    }

    @BeforeMethod
    void reloadPage() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    void verifyDropDownOptionASelected() {
        WebElement option1 = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select dropdown = new Select(option1);

        dropdown.selectByVisibleText("Option 1");

        Assert.assertTrue(driver.findElement(By
                .xpath("//select[@id='dropdown']/option[.='Option 1']")).isSelected());
/*        Assert.assertTrue(driver.findElement(By
                .xpath("//select[@id='dropdown']/option[text()='Option 1']")).isSelected());*/
    }

    @Test
    void verifyDropDownOptionBSelected() {
        WebElement option2 = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select dropdown = new Select(option2);

//        dropdown.selectByVisibleText("Option 2");

        dropdown.selectByValue("2");
/*        Assert.assertTrue(driver.findElement(By
                .xpath("//select[@id=drowpdown]/option[.='Option 2']")).isSelected());*/

        Assert.assertEquals(
//                .xpath("//select[@id='dropdown']/option[3]")).getText(), "Option 2");
                dropdown.getFirstSelectedOption().getText(), "Option 2");
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
