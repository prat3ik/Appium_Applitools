package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofSeconds;

/**
 * This class contains custom appium/selenium methods for Webelement
 */
public class AppiumUtils {
    public static WaitUtils waitUtils = new WaitUtils();

    /**
     * This will check whether element is displayed on UI or not
     *
     * @param element
     * @return
     */
    public static boolean isElementDisplayed(IOSElement element) {
        waitUtils.staticWait(500);
        boolean isPresent = false;
        try {
            element.isDisplayed();
            isPresent = true;
        } catch (Exception e) {
            isPresent = false;
        }
        return isPresent && element.isDisplayed();
    }

    /**
     * It will scroll to particular element
     *
     * @param element
     * @param driver
     */
    public static void scrollToElement(MobileElement element, AppiumDriver driver) {
        int i = 0;
        System.out.println("scrollToElement: " + element);
        Dimension size = driver.manage().window().getSize();
        System.out.println("Screen Size: " + size);
        int start_Y = (int) (size.getHeight() * 0.80);
        int end_Y = (int) (size.getHeight() * 0.20);
        System.out.println("Y2:" + start_Y);
        System.out.println("Y1:" + end_Y);
        int start_end_X = (int) (size.getWidth() * 0.50);
        System.out.println("X1/X2:" + start_end_X);
        System.out.println(start_Y + " : " + end_Y + " : " + start_end_X);
        do {
            i++;
            System.out.println("Before swipe: " + i);
            TouchAction swipe = new TouchAction(driver).press(PointOption.point(200, 500))
                    .waitAction(waitOptions(ofSeconds(2)))
                    .moveTo(PointOption.point(200, -100)).release();

            swipe.perform();
            System.out.println("After swipe: " + i);
        } while (!isElementDisplayed((IOSElement) element)); //(i==2);
    }

    /**
     * This method is used to generate 4 digit randomNumber
     *
     * @return
     */
    public static String getRandomNumber() {
        return String.valueOf(System.currentTimeMillis() % 10000);
    }

}
