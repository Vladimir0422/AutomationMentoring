package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 8/18/2018
 */


public class Waiters {
    public static final int WAITE_10 = 10;
    public static final int WAITE_60 = 60;

    public static void waitImplicit(WebDriver driver, int amountOfTime, TimeUnit timeUnit) {
        driver.manage().timeouts().implicitlyWait(amountOfTime, timeUnit);
    }

    public static void waitForUrl(WebDriver driver, String URL) {
        WebDriverWait wait = new WebDriverWait(driver, Waiters.WAITE_60);
        wait.until(ExpectedConditions.urlToBe((URL)));
    }
}
