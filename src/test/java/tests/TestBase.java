package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static helpers.Configuration.getConfiguration;
import static helpers.Driver.initializeChromeWebDriver;

/**
 * Test Base for Tests
 */
public class TestBase {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = initializeChromeWebDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(getConfiguration().getSiteURL());
        closeCookiesNotification();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    /**
     * Close cookies notification
     */
    public void closeCookiesNotification() {
        if (driver.findElement(By.cssSelector(".notification__text")).isDisplayed()) {
            driver.findElement(By.cssSelector(".notification__dismiss")).click();
        }
    }
}