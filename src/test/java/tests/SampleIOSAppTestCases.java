package tests;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.FixedCutProvider;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.StitchMode;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobjects.SampleAppPO;

public class SampleIOSAppTestCases extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

//    @BeforeMethod
//    @Override
//    public void setUpPage() {
////        if (isAlertPresent()) {
////            driver.switchTo().alert().accept();
////        }
//    }


    @Test
    public void BasicTest() throws Exception {
        Eyes eyes = new Eyes();
        System.out.println("Setting the keys.....");
        eyes.setApiKey("798ZOWLGYINcQQqzyUVaAAPUDmri43HpLOzFlLgPOB5c110");

//        BatchInfo batch = new BatchInfo("iOS Native Local");
//        eyes.setBatch(batch);
//        eyes.setForceFullPageScreenshot(true);
//        eyes.setStitchMode(StitchMode.CSS);
//        eyes.setMatchLevel(MatchLevel.LAYOUT2);
//        eyes.setImageCut(new FixedCutProvider(63,135,0,0)); //removes URL field...


        try {
            // Start visual UI testing
            eyes.open(driver, "TestApp-iphonesimulator", "BasicTest");

            SampleAppPO sampleAppPO = new SampleAppPO(driver);
            sampleAppPO.typeInTextField1(1);
            eyes.checkWindow("Initial view");

            sampleAppPO.typeInTextField2(4);
            sampleAppPO.tapOnComputeButton();
            System.out.println(sampleAppPO.getAnswerTextViewText());
            // Visual validation point #2
            eyes.checkWindow("After compute");

            // End visual UI testing. Validate visual correctness.
            eyes.close();
        } finally {
            eyes.abortIfNotClosed();
        }

    }


    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @BeforeMethod
    public void setUpPage() {

    }
}