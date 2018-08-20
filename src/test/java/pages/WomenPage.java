package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 8/18/2018
 */


public class WomenPage extends Page {

    public WomenPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='center_column']/ul/li")
    public WebElement table;

//    @FindBy(xpath = "//*[@id='center_column']/ul/li[1]/div/div[1]/div/div[2]")
//    public WebElement price;

    public void selectValueFromDropDown(String parameterForSorting) {
        WebElement selectFromDropDown = driver.findElement(By.xpath("//*[@id='selectProductSort']//option[contains(text(),'" + parameterForSorting + "')]"));
        selectFromDropDown.click();
    }

    public static double price(int position) throws ParseException {
        WebElement price = driver.findElement(By.xpath(".//*[@id='center_column']/ul/li[" + position + "]/div/div[2]/div[1]/span[1]"));

        String deleteSpace = price.getText().toString().replace(" ", "");
        String deleteSymbols = DecimalFormat.getCurrencyInstance(Locale.getDefault()).parse(deleteSpace).toString();
        double number = Double.parseDouble(deleteSymbols);
        return number;
    }

    public void clickOnColor(String color) {
        driver.findElement(By.xpath("//*[@id='ul_layered_id_attribute_group_3']//a[contains(text(),'" + color + "')]")).click();
    }

    public int colorOfItem(String color) {
        WebElement numberOfAvailableItems = driver.findElement(By.xpath("//*[@id='ul_layered_id_attribute_group_3']//a[contains(text(),'" + color + "')]/span"));

        String deleteSymbols = numberOfAvailableItems.getText().substring(1, numberOfAvailableItems.getText().length() - 1);
        int number = Integer.parseInt(deleteSymbols);
        return number;
    }

    public void verifySortedItemsByColor(String color) throws InterruptedException {
        clickOnColor(color);
        Thread.sleep(5000);
        int number = colorOfItem(color);
        List<WebElement> items = driver.findElements(By.xpath("//*[@id='center_column']/ul/li"));
        assertEquals(number, items.size());

        System.out.println("Expected value is " + number + " and actual value is " + items.size());
    }

    public void verifySortedItems() throws ParseException {
        List<WebElement> itemsInTable = driver.findElements(By.xpath("//*[@id='center_column']/ul/li"));

        for (int i = 1; i < itemsInTable.size(); i++) {
            double firstPrice = price(i);
            double nextPrice = price(i + 1);

            if (firstPrice > nextPrice) {
                System.out.println("Sorting is incorrect. First price is " + firstPrice + " and next price is " + nextPrice);
                break;
            }else {
                System.out.println("Sorting is correct. " + firstPrice + " and  " + nextPrice);
            }
        }
    }
}
