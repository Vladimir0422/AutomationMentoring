package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 8/18/2018
 */


public class HomePage extends Page {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[1]")
    @CacheLookup
    public WebElement womenButton;

    public void clickWomenButton() {
//        WebElement womenButton = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]"));
        womenButton.click();
    }
}
