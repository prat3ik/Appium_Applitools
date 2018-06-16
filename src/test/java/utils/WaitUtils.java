package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * This will contain all wait related utility methods.
 */
public class WaitUtils {

    public final int explicitWaitDefault = PropertyUtils.getIntegerProperty("explicitWait", 10);

    /**
     * This method is for static wait
     *
     * @param millis
     */
    public void staticWait(final long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (final InterruptedException e) {
        }
    }

    /**
     * To wait for button to be clickable
     *
     * @param driver
     * @param element
     */
    public void waitForElementToBeClickable(final WebElement element, final WebDriver driver) {
        new WebDriverWait(driver, this.explicitWaitDefault)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * To wait for element (By) to be invisible
     *
     * @param driver
     * @param locator
     */
    public void waitForElementToBeInvisible(final By locator, final WebDriver driver) {
        long s = System.currentTimeMillis();
        new WebDriverWait(driver, this.explicitWaitDefault)
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /**
     * To wait for given element (By) to be present
     *
     * @param driver
     * @param locator
     */
    public void waitForElementToBePresent(final By locator, final WebDriver driver) {
        new WebDriverWait(driver, this.explicitWaitDefault)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * To wait for element (By) to be visible
     *
     * @param driver
     * @param locator
     */
    public void waitForElementToBeVisible(final By locator, final WebDriver driver) {
        new WebDriverWait(driver, this.explicitWaitDefault)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * To wait for element to be visible
     *
     * @param driver
     * @param element
     */
    public void waitForElementToBeVisible(final WebElement element, final WebDriver driver) {
        long s = System.currentTimeMillis();
        new WebDriverWait(driver, this.explicitWaitDefault).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementsToBeInvisible(final List<WebElement> elements, final WebDriver driver) {
        final long s = System.currentTimeMillis();
        new WebDriverWait(driver, this.explicitWaitDefault)
                .until(ExpectedConditions.invisibilityOfAllElements(elements));
    }

    public void waitForElementToBeNotPresent(final By element, WebDriver driver) {
        long s = System.currentTimeMillis();
        new WebDriverWait(driver, this.explicitWaitDefault)
                .until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(element)));
    }

    public void waitUntilNestedElementPresent(WebElement element, By locator, WebDriver driver) {
        new WebDriverWait(driver, explicitWaitDefault)
                .until(ExpectedConditions.presenceOfNestedElementLocatedBy(element, locator));
    }

    public static void main(String[] args) throws ParseException {
        String deviceDateAndTime = "Sat Jun 09 2018 14:23:15 GMT+0000 (UTC)";
        String substring = deviceDateAndTime.substring(0, 24);
        System.out.println(substring);

        SimpleDateFormat formatter2 = new SimpleDateFormat("E MMM d yyyy hh:mm:ss");
        Date date = formatter2.parse(substring);

        System.out.println(date);

//        String deviceDateAndTime = "Sat Jun 09 2018 14:23:15 GMT+0000 (UTC)";
//        String substring = deviceDateAndTime.substring(0, 24);
//        System.out.println(substring);
//
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(1528756705000l);
        //
//        String date = formatter2.format(cal.getTime());
//
//        System.out.println(date);
//
//        Assert.assertTrue(false || false,"Not same");
//
        String date1 = formatter2.format(cal.getTimeInMillis());
        Date datea = formatter2.parse(date1);
        System.out.println(datea);
        cal.setTime(datea);
        int hourr = cal.get(Calendar.HOUR);
        System.out.println(hourr);
        System.out.println(hourr + 12);

        String hoursIn24HourFormat = String.valueOf(hourr + 12);
        String minutes = String.valueOf(cal.get(Calendar.MINUTE));


        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dateIn24 = formatter.format(cal.getTime());
        System.out.println(dateIn24 + " " + hoursIn24HourFormat + ":" + minutes);

    }
}
