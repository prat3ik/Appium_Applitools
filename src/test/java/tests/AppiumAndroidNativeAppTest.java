package tests;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.selenium.Eyes;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.List;

public class AppiumAndroidNativeAppTest {
    private Eyes eyes = new Eyes();
    private WebDriver driver;
    private static String applitoolsKey = "798ZOWLGYINcQQqzyUVaAAPUDmri43HpLOzFlLgPOB5c110";

    @BeforeMethod
    public void setUp() throws Exception {
        eyes.setApiKey(applitoolsKey);
        BatchInfo batch = new BatchInfo("Test App Local");
        eyes.setBatch(batch);
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("platformName", "Android");
        capability.setCapability("platformVersion", "8.0");
        capability.setCapability("deviceName", "c4e3f3cd");
        capability.setCapability("app", "/Users/harry/IdeaProjects/IOS_Appium_Applitools/src/test/resources/sample_app.apk");
        driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), capability);
    }

    @Test
    public void BasicTestCase() throws Exception {
       // driver.findElement(By.id("ReferenceApp")).click();
        //List<WebElement> we  = driver.findElements(By.id("Row Category Name"));
        //we.get(2).click();
        System.out.println("EYE:::"+eyes);



        Thread.sleep(5000);

        eyes.open(driver, "Native App Test", "Native Page");
        System.out.println(eyes.getBaseAgentId());
        System.out.println(eyes.getDevicePixelRatio());
        System.out.println(eyes.getDriver());
        System.out.println(eyes.getRotation());
        System.out.println(eyes.getViewportSize());
        System.out.println(eyes.getAgentId());
        System.out.println(eyes.getApiKey());
        System.out.println(eyes.getServerUrl());

        eyes.checkWindow("Test");
        eyes.close();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
        eyes.abortIfNotClosed();
    }
}
