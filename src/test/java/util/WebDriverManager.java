package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverManager {

    public static WebDriver driver;

    private WebDriverManager() {
    }

    public static WebDriver getDriver() {
        if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null) {
            defineBrowser();
        }
        return driver;
    }

    private static void defineBrowser() {
        String browser = System.getProperty("browser", "");
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "ie":
                System.out.println("Create ie browser");
                break;
            default:
                driver = new ChromeDriver();
//                throw new IllegalStateException("Unknown browser: " + browser);
                break;
        }
    }
}
