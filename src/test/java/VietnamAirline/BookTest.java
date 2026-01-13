package VietnamAirline;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BookTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @BeforeMethod
    void reloadPage() {
        driver.get("https://www.google.com/travel/flights");
    }

    @Test
    void verifySearchFlightFunctionWorkCorrectlyTest() throws InterruptedException {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[.='Flights']")));
        WebElement departIni = driver.findElement(By.xpath("//div[@data-placeholder='Where from?']"));
        String valueDepeartIni = departIni.getDomProperty("innerText");
        //verify depart field is not empty
        Assert.assertTrue(valueDepeartIni != null && !valueDepeartIni.isEmpty());
        //verify book function work correctly
        //Depart SGN
        driver.findElement(By.xpath("//div[@data-placeholder='Where from?']")).click();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//li[@aria-label='Tan Son Nhat International Airport (SGN)']")));
        driver.findElement(By.xpath("//li[@aria-label='Tan Son Nhat International Airport (SGN)']")).click();

        String departRes = driver.findElement(By
                .xpath("//div[@data-placeholder='Where from?']")).getDomProperty("innerText");
        Assert.assertTrue(departRes.contains("SGN"));

        //Destination CDG
        driver.findElement(By.xpath("//input[@aria-label='Where to? ']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//button[@aria-label='Toggle nearby airports for Paris, France']")));
        driver.findElement(By.xpath("//button[@aria-label='Toggle nearby airports for Paris, France']")).click();
        driver.findElement(By.xpath("//div[normalize-space(.)='Paris Charles de Gaulle Airport']")).click();

        String destinationRes = driver.findElement(By
                .xpath("//div[@data-placeholder='Where to?']")).getDomProperty("innerText");
        Assert.assertTrue(destinationRes.contains("CDG"));

        //select date depart/return
        driver.findElement(By.xpath("//input[@placeholder='Departure']")).click();
        //date depart
        WebElement dateDepart = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@aria-label='Saturday, January 31, 2026']")
                )
        );
        dateDepart.click();

        //date return
        WebElement dateReturn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@aria-label='Sunday, February 1, 2026']")
                )
        );
        dateReturn.click();
        driver.findElement(By
                .xpath("//button[@aria-label and contains(@aria-label,'Done. ')]")).click();

        //Date Depart result
        Thread.sleep(10000);
        String dateDepartRes = driver.findElement(By
                        .xpath("//input[@placeholder='Departure']"))
                .getDomProperty("value");
        Assert.assertEquals(dateDepartRes,"Sat, Jan 31");

        //Date Return result
        String dateReturnRes = driver.findElement(By
                        .xpath("//input[@placeholder='Return']"))
                .getDomProperty("value");
        Assert.assertEquals(dateReturnRes,"Sun, Feb 1");

        //Search button click
        driver.findElement(By.xpath("//button[@aria-label='Search']")).click();

        //Verify
        WebElement titleResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By
                        .xpath("//h3[.='Top departing flights']")));
        Assert.assertTrue(titleResult.getText().contains("Top departing flights"));
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
