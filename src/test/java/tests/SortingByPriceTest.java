package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.WomenPage;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static util.Waiters.WAITE_10;
import static util.Waiters.waitImplicit;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 8/16/2018
 */


public class SortingByPriceTest {
    WebDriver driver = new ChromeDriver();
    private static final String URL = "http://automationpractice.com/index.php";
    private String sortingByLowestPrice = "Price: Lowest first";
    private String colorOfItem = "White";

    HomePage onHomePage = new HomePage(driver);
    WomenPage onWomenPage = new WomenPage(driver);

    @Before
    public void setUp() throws InterruptedException {
        driver.manage().window().maximize();
        onHomePage.getDriver().get(URL);
        waitImplicit(driver, WAITE_10, TimeUnit.SECONDS);
        assertEquals(URL, driver.getCurrentUrl());

//        waitForUrl(driver, URL);
        onHomePage.clickWomenButton();
        onWomenPage.selectValueFromDropDown(sortingByLowestPrice);
        Thread.sleep(3000);
    }

//    @Ignore
    @Test
    public void verifySortedItems() throws ParseException {
        onWomenPage.verifySortedItems();
    }

    @Ignore
    @Test
    public void verifySortedItemsByColor() throws InterruptedException {
        onWomenPage.verifySortedItemsByColor(colorOfItem);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
