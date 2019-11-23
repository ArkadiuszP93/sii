package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import pages.CareersPage;
import pages.HelperPage;
import pages.JobAddsPage;
import pages.MenuPage;

import java.util.concurrent.TimeUnit;

import static helpers.Configuration.getConfiguration;
import static helpers.Driver.initializeChromeWebDriver;

/**
 * Test Base for Tests
 */
public class TestBase {
    WebDriver driver;
    MenuPage menu;
    CareersPage careers;
    JobAddsPage jobAdds;

    @BeforeTest
    public void setUp() {
        driver = initializeChromeWebDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(getConfiguration().getSiteURL());
        closeCookiesNotification();
        menu = new MenuPage(driver);
        careers = new CareersPage(driver);
        jobAdds = new JobAddsPage(driver);
    }

    @AfterTest
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