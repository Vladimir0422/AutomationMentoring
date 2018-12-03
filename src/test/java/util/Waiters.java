package util;

import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
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
        Wait wait = new WebDriverWait(driver, Waiters.WAITE_60);
        wait.until(ExpectedConditions.urlToBe((URL)));
    }

    public static void waitForSorting(WebDriver driver, String xpath) {
//        WebDriverWait wait = new WebDriverWait(driver, Waiters.WAITE_60);
//        wait.until((WebDriver webDriver) -> {
//            List<WebElement> itemsInTable = webDriver.findElements(By.xpath(xpath));
//            boolean isSorted = false;
//            for (int i = 0; i < itemsInTable.size() - 1; i++) {
//                double firstPrice = Double.parseDouble(itemsInTable.get(i).getText().replaceAll("\\$", "").trim());
//                double nextPrice = Double.parseDouble(itemsInTable.get(i + 1).getText().replaceAll("\\$", "").trim());
//
//                if (firstPrice < nextPrice) {
//                    isSorted = true;
//                } else {
//                    isSorted = false;
//                    break;
//                }
//            }
//            return isSorted;
//        });
    }
}
