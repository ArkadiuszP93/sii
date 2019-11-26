package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Menu Page
 */
public class MenuPage extends HelperPage {

    @FindBy(id = "menu-item-23407")
    private WebElement careers;

    public MenuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Go to careers page
     *
     * @return
     */
    public CareersPage goToCareersPage() {
        click(careers);
        return new CareersPage(driver);
    }
}
