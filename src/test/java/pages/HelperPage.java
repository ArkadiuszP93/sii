package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Helper methods.
 */
public class HelperPage {

    protected WebDriver driver;

    public HelperPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElementByID(WebDriver driver, String id) {
        return driver.findElement(By.id(id));
    }
}