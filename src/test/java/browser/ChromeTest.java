package browser;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v143.emulation.Emulation;
import org.openqa.selenium.devtools.v143.network.Network;
import org.openqa.selenium.devtools.v143.network.model.ConnectionType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class ChromeTest {
    @Test
    void openWithDefaultMode() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        Assert.assertEquals(driver.getTitle(), "Google");
        driver.quit();
    }

    @Test
    void openWithHeadlessMode() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.google.com/");
        Assert.assertEquals(driver.getTitle(), "Google");
        driver.quit();
    }

    @Test
    void openWithMobileViewPort() {
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 334);
        deviceMetrics.put("height", 882);
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
//        mobileEmulation.put("deviceName","iphoneX");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.google.com/");
        Assert.assertEquals(driver.getTitle(), "Google");
        driver.quit();
    }

    @Test
    void openWithDeviceName() {
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone X");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.icloud.com");
        Assert.assertEquals(driver.getTitle(), "iCloud");
        driver.quit();
    }

    @Test
    void openWithOldChormeVer() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("144");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.icloud.com");
        Assert.assertEquals(driver.getTitle(), "iCloud");
        driver.quit();
    }

    @Test
    void openBrowserWithFakeGeoLocation() {
        WebDriver driver = new ChromeDriver();
        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();
        //Mountain View
        devTools.send(
                Emulation.setGeolocationOverride(
                        Optional.of(35.689487),
                        Optional.of(139.691706),
                        Optional.of(150),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty()
                )
        );

        driver.get("https://the-internet.herokuapp.com/geolocation");
        driver.findElement(By.xpath("//button[.='Where am I?']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("#lat-value")).getText(),"35.689487");
        Assert.assertEquals(driver.findElement(By.id("long-value")).getText(),"139.691706");
        driver.quit();
    }

    @Test
    void simulate3GNetworkCondition(){
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        //Enable Network emulation
        devTools.send(Network.enable(
                Optional.of(100000000),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty()
        ));

        //Set network
        devTools.send(Network.emulateNetworkConditions(
                false,
                100,
                75000,
                25000,
                Optional.of(ConnectionType.CELLULAR2G),
                Optional.of(0),
                Optional.of(0),
                Optional.of(false)
        ));
        driver.get("https://www.icloud.com");
    }

    @Test
    void interceptionNetwork(){
        WebDriver driver = new ChromeDriver();
        DevTools devTools = ((HasDevTools) driver).getDevTools();

        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty()));

        devTools.addListener(Network.requestWillBeSent(), requestWillBeSent -> {
            System.out.println("Request URL => " + requestWillBeSent.getRequest().getUrl());
            System.out.println("Request Method => " + requestWillBeSent.getRequest().getMethod());
            System.out.println("Responde Headers => " + requestWillBeSent.getRequest().getHeaders().toString());
            System.out.println("----------------------------------");
        });

        devTools.addListener(Network.responseReceived(), responseReceived -> {
            System.out.println("Response Url => " + responseReceived.getResponse().getUrl());
            System.out.println("Response Status => " + responseReceived.getResponse().getStatus());
            System.out.println("Response Headers => " + responseReceived.getResponse().getHeaders().toString());
            System.out.println("Response MIME Type => " + responseReceived.getResponse().getMimeType().toString());
            System.out.println("---------------------------------- ");
        });

        driver.get("https://www.icloud.com");
    }
}
