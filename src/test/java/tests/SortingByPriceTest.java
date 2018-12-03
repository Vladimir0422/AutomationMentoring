package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.HomePage;
import pages.WomenPage;
import util.WebDriverManager;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        onHomePage.login(URL);
        assertEquals(URL, WebDriverManager.getDriver().getCurrentUrl());
        onHomePage.clickWomenButton();
    }

    @After
    public void closeBrowser() {
        WebDriverManager.getDriver().quit();
    }

    @Test
    public void verifySortedItems() throws ParseException {
        onWomenPage.selectValueFromDropDown(sortingByLowestPrice);
        Boolean incorrectSorting = onWomenPage.verifySortedItems();
        assertTrue("Sorting is incorrect.", incorrectSorting);
    }

    @Test
    public void verifySortedItemsByColor() throws InterruptedException {
        int numberOfItems = onWomenPage.colorOfItem(colorOfItem);
        int actualNumberOfItems = onWomenPage.verifySortedItemsByColor(colorOfItem);
        assertEquals(numberOfItems, actualNumberOfItems);
    }
}
