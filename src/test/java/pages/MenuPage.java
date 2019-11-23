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
        click(findElementByID(driver, "menu-item-23407"));
        return new CareersPage(driver);
    }
}
