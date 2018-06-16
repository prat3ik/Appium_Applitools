package tests;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.StitchMode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;

public class AppiumAndroidBrowserTest {
    private Eyes eyes = new Eyes();
    private WebDriver driver;
    private static String applitoolsKey = "798ZOWLGYINcQQqzyUVaAAPUDmri43HpLOzFlLgPOB5c110";

    @BeforeMethod
    public void setUp() throws Exception {
        eyes.setApiKey(applitoolsKey);
        eyes.setForceFullPageScreenshot(true);
        eyes.setStitchMode(StitchMode.CSS);
        eyes.setMatchLevel(MatchLevel.LAYOUT2);
        BatchInfo batch = new BatchInfo("Github Local");
        eyes.setBatch(batch);
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("platformName", "Android");
        capability.setCapability("deviceName", "android");
        capability.setCapability("browserName", "Chrome");
        driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), capability);
    }

    @Test
    public void GithubHomePage() throws Exception {
        driver.get("https://github.com/");
        eyes.open(driver, "Github", "Home Page");
        eyes.checkWindow("Home Page Screenshot");
        eyes.close();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
        eyes.abortIfNotClosed();
    }
}
