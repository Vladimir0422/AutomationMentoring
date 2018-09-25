package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import util.WebDriverManager;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 8/18/2018
 */
public abstract class Page {

   protected WebDriver driver;

    protected Page() {
        this.driver = WebDriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

}
