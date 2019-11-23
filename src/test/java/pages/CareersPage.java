package pages;

import com.sun.org.glassfish.gmbal.Description;
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

    @FindBy(css = ".sii-breadcrumbs-whitebg")
    WebElement breadcrumb;

    @FindBy(css = ".search-job-input")
    WebElement searchInput;

    @FindBy(id = "ui-id-1-menu")
    WebElement locationDropdown;

    @FindBy(id = "ui-id-1-button")
    WebElement locationButton;

    @FindBy(css = ".selectArrow.loupe")
    WebElement loupe;

    @Description("First element from job list")
    @FindBy(css = ".job-ads-list div.jobAdBoxHead:first-of-type")
    WebElement jobAdd;

    public CareersPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Fill in search input
     *
     * @param search
     */
    public void setKeyword(String search) {
        type(searchInput, search);
    }

    /**
     * Choose location from dropdown
     *
     * @param location
     * @return
     */
    public CareersPage setLocation(String location) {
        locationButton.click();
        locationDropdown.findElement(By.xpath("//li[contains(text(),'" + location + "')]")).click();
        return this;
    }

    /**
     * Set Filters
     *
     * @param searchKeyword
     * @param location
     * @return
     */
    public CareersPage setFilters(String searchKeyword, String location) {
        setLocation(location);
        setKeyword(searchKeyword);
        scrollToElement(breadcrumb);
        loupe.click();
        return this;
    }

    /**
     * Return job name title
     * @return
     */
    public String getJobName(){
        return jobAdd.getText();
    }

    /**
     * Choose job offer
     *
     * @return
     */
    public JobAddsPage chooseJobOffer() {
        try {
            click(jobAdd);
        } catch (NoSuchElementException e) {
            System.out.print("No job offers available");
        }
        return new JobAddsPage(driver);
    }
}