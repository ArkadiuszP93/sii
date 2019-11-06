package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Careers Page.
 */
public class CareersPage extends HelperPage {

    @FindBy(css = ".search-job-input")
    WebElement searchInput;

    @FindBy(id = "ui-id-1-menu")
    WebElement locationDropdown;

    @FindBy(id = "ui-id-1-button")
    WebElement locationButton;

    @FindBy(css = ".selectArrow.loupe")
    WebElement loupe;

    @FindBy(xpath = "//li[1]/div/div/div[1]/h2")
    WebElement jobAdd;

    public CareersPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Fill in search input
     * @param search
     */
    public void setKeyword(String search) {
        searchInput.sendKeys(search);
    }

    /**
     * Choose location from dropdown
     * @param location
     * @return
     */
    public CareersPage setLocation(String location) {
        locationButton.click();
        locationDropdown.findElement(By.xpath("//li[contains(.,'" + location + "')]")).click();
        return this;
    }

    /**
     * Set Filters
     * @param searchKeyword
     * @param location
     * @return
     */
    public CareersPage setFilters(String searchKeyword, String location) {
        setKeyword(searchKeyword);
        setLocation(location);
        loupe.click();
        return this;
    }

    /**
     * Choose job offer
     * @return
     */
    public JobAddsPage chooseJobOffer() {
        try {
            jobAdd.click();
        }
        catch (NoSuchElementException e) {
        System.out.print("No job offers available");
    }
        return new JobAddsPage(driver);
    }
}
