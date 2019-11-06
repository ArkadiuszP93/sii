package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static helpers.Configuration.getConfiguration;

/**
 * Initialize WebDriver.
 */
public class Driver {
    /**
     * Chrome Driver
     */
    public static WebDriver initializeChromeWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        System.setProperty("webdriver.chrome.driver", getConfiguration().getDriverLocation());
        return new ChromeDriver(options);
    }

    /**
     * Firefox Driver
     */
    public static WebDriver initializeFirefoxWebDriver() {
        System.setProperty("webdriver.gecko.driver", getConfiguration().getFirefoxDriverLocation());
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("marionette", true);
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    /**
     * Internet Explorer Driver
     */
    public static WebDriver initializeInternetExplorerDriver() {
        System.setProperty("webdriver.ie.driver", getConfiguration().getIEDriverLocation());
        WebDriver driver = new InternetExplorerDriver();
        driver.manage().window().maximize();
        return driver;
    }
}