package pages;

import org.openqa.selenium.WebDriver;

/**
 * Menu Page
 */
public class MenuPage extends HelperPage {

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Go to careers page
     *
     * @return
     */
    public CareersPage goToCareersPage() {
        findElementByID(driver, "menu-item-23407").click();
        return new CareersPage(driver);
    }
}
