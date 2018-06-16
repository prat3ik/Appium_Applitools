package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class SampleAppPO extends BasePO {

    public SampleAppPO(AppiumDriver driver) {
        super(driver);
    }

    @iOSFindBy(accessibility = "TextField1")
    IOSElement textfield1;

    public void typeInTextField1(int value) {
        textfield1.sendKeys(value + "");
    }

    @iOSFindBy(accessibility = "TextField2")
    IOSElement textfield2;

    public void typeInTextField2(int value) {
        textfield2.sendKeys(value + "");
    }

    @iOSFindBy(accessibility = "ComputeSumButton")
    IOSElement computeButton;

    public void tapOnComputeButton() {
        computeButton.click();
        waitUtils.waitForElementToBeVisible(answerTextView, driver);
    }

    @iOSFindBy(accessibility = "Answer")
    IOSElement answerTextView;

    public String getAnswerTextViewText() {
        return answerTextView.getText();
    }
}
