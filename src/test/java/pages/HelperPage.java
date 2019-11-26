package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Helper methods.
 */
public class HelperPage {

    protected WebDriver driver;
    private Actions actionDriver;


    public HelperPage(WebDriver driver) {
        this.driver = driver;
        actionDriver = new Actions(driver);
    }

    /**
     * Click on element
     *
     * @param element
     */
    protected void click(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }

    /**
     * Key in text in to element
     *
     * @param element
     * @param text
     */
    protected void type(WebElement element, String text) {
        waitForElementToBeVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Wait for element to be clickable
     *
     * @param element
     * @return
     */
    protected WebElement waitForElementToBeClickable(WebElement element) {
        actionDriver.moveToElement(element);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    /**
     * Wait for element to be visible
     *
     * @param element
     * @return
     */
    protected WebElement waitForElementToBeVisible(WebElement element) {
        actionDriver.moveToElement(element);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}