package tests;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;

public class AppiumIOSNativeTestCase {
//    private Eyes eyes = new Eyes();
//    private WebDriver driver;
//    public static String applitoolsKey = "798ZOWLGYINcQQqzyUVaAAPUDmri43HpLOzFlLgPOB5c110";
//
//    @BeforeMethod
//    public void setUp() throws Exception {
//        eyes.setApiKey(applitoolsKey);
//        BatchInfo batch = new BatchInfo("iOS Native Local");
//        eyes.setBatch(batch);
//
//        DesiredCapabilities capability = new DesiredCapabilities();
//        capability.setCapability("platformName", "iOS");
//        capability.setCapability("deviceName", "iPhone X");
//        capability.setCapability("browserName", "");
//        capability.setCapability("automationName", "XCUITest");
//        capability.setCapability("platformVersion", "11.4");
//        capability.setCapability("app", "/Users/harry/IdeaProjects/IOS_Appium_Applitools/src/test/resources/TestApp-iphonesimulator.app");//https://store.applitools.com/download/iOS.TestApp.app.zip
//
//        driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), capability);
//    }
//
//    @Test
//    public void iOSTestApp() throws Exception {
//        eyes.open(driver, "Test iOS App", "Main View");
//        eyes.checkWindow("TEST");
//        eyes.close();
//    }
//
//    @AfterMethod
//    public void tearDown() throws Exception {
//        driver.quit();
//        eyes.abortIfNotClosed();
//    }


    private Eyes eyes = new Eyes();
    private WebDriver driver;
    public static String applitoolsKey = "your_applitools_key";

    @BeforeMethod
    public void setUp() throws Exception {
        eyes.setApiKey(applitoolsKey);
        BatchInfo batch = new BatchInfo("iOS Native Local");
        eyes.setBatch(batch);

        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("platformName", "iOS");
        capability.setCapability("deviceName", "iPhone Simulator");
        capability.setCapability("browserName", "");
        capability.setCapability("automationName", "XCUITest");
        capability.setCapability("platformVersion", "11.4");
        capability.setCapability("app", "https://store.applitools.com/download/iOS.TestApp.app.zip");

        driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), capability);
    }

    @Test
    public void iOSTestApp() throws Exception {
        eyes.open(driver, "Test iOS App", "Main View");
        eyes.checkWindow("TEST");
        eyes.close();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
        eyes.abortIfNotClosed();
    }



}
