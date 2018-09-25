package tests;

import java.text.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import pages.HomePage;
import pages.WomenPage;
import util.WebDriverManager;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 8/16/2018
 */


public class SortingByPriceTest {
    private static final String URL = "http://automationpractice.com/index.php";
    private String sortingByLowestPrice = "Price: Lowest first";
    private String colorOfItem = "White";

    HomePage onHomePage = new HomePage();
    WomenPage onWomenPage = new WomenPage();

    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.getDriver().get(URL);
//        waitImplicit(driver, WAITE_10, TimeUnit.SECONDS);
//        assertEquals(URL, driver.getCurrentUrl());

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
        WebDriverManager.getDriver().quit();
    }
}
