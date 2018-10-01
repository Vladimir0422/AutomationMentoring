package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Waiters;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 8/18/2018
 */


public class WomenPage extends Page {

    @FindBy(xpath = "//*[@id='center_column']/ul/li")
    public List<WebElement> table;

    @FindBy(xpath = "//*[@id='center_column']/ul/li/div/div[2]/div[1]/span[1]")
    public WebElement price;

    public void selectValueFromDropDown(String parameterForSorting) {
        WebElement selectFromDropDown = driver.findElement(By.xpath("//*[@id='selectProductSort']//option[contains(text(),'" + parameterForSorting + "')]"));
        selectFromDropDown.click();
        Waiters.waitForSorting(driver, "//*[@id='center_column']/ul/li/div/div[2]/div[1]/span[1]");
    }

    public double price(int position) throws ParseException {
        WebElement price = driver.findElement(By.xpath(".//*[@id='center_column']/ul/li[" + position + "]/div/div[2]/div[1]/span[1]"));

        String deleteSpace = price.getText().replace(" ", "");
        String deleteSymbols = DecimalFormat.getCurrencyInstance(Locale.getDefault()).parse(deleteSpace).toString();
        double number = Double.parseDouble(deleteSymbols);
        return number;
    }

    public void clickOnColor(String color) {
        driver.findElement(By.xpath("//*[@id='ul_layered_id_attribute_group_3']//a[contains(text(),'" + color + "')]")).click();
        Waiters.waitForSorting(driver, "//*[@id='center_column']/ul/li/div/div[2]/div[1]/span[1]");
    }

    public int colorOfItem(String color) {
        WebElement numberOfAvailableItems = driver.findElement(By.xpath("//*[@id='ul_layered_id_attribute_group_3']//a[contains(text(),'" + color + "')]/span"));

        String deleteSymbols = numberOfAvailableItems.getText().substring(1, numberOfAvailableItems.getText().length() - 1);
        int number = Integer.parseInt(deleteSymbols);
        return number;
    }

    public int verifySortedItemsByColor(String color) throws InterruptedException {
        clickOnColor(color);
        List<WebElement> items = table;
        return items.size();
    }

    public Boolean verifySortedItems() throws ParseException {
        List<WebElement> itemsInTable = table;
        boolean testFailed = true;

        for (int i = 1; i < itemsInTable.size(); i++) {
            double firstPrice = price(i);
            double nextPrice = price(i + 1);

            if (firstPrice > nextPrice) {
                testFailed = false;
                break;
            } else {
                System.out.println("Sorting is correct. " + firstPrice + " and  " + nextPrice);
            }
        }
        return testFailed;
    }
}
