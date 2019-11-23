package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


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

    /**
     * Scroll the page to element
     *
     * @param element
     */
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    /**
     * Click on element
     * @param element
     */
    public void click(WebElement element){
        waitForElementToBeClickable(element);
        element.click();
    }

    /**
     * Key in text in to element
     * @param element
     * @param text
     */
    public void type(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Wait for element to be clickable
     * @param element
     * @return
     */
    public WebElement waitForElementToBeClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
}