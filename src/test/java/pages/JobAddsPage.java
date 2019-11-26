package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page with job adds
 */
public class JobAddsPage extends HelperPage {

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "surname")
    private WebElement surnameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "recruitment_consent_yes")
    private WebElement checkboxMandatory;

    @FindBy(xpath = "//*[@id=\"form_job_application\"]//*[@id=\"submit_btn\"]")
    private WebElement submitButton;

    @FindBy(id = "Zebra_Form_error_message_upload_file")
    private WebElement errorCvTooltip;


    public JobAddsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Fill name Field
     *
     * @param name
     * @return
     */
    public JobAddsPage fillNameField(String name) {
        type(nameInput, name);
        return this;
    }

    /**
     * Fill surname field
     *
     * @param surname
     * @return
     */
    public JobAddsPage fillSurnameField(String surname) {
        type(surnameInput, surname);
        return this;
    }

    /**
     * Fill email field
     *
     * @param email
     * @return
     */
    public JobAddsPage fillEmailField(String email) {
        type(emailInput, email);
        return this;
    }

    /**
     * Select mandatory checkbox
     *
     * @return
     */
    public JobAddsPage selectMandatoryCheckbox() {
        checkboxMandatory.click();
        return this;
    }

    /**
     * Send application
     *
     * @return
     */
    public JobAddsPage sendApplication() {
        click(submitButton);
        return this;
    }

    /**
     * Tooltip that CV is not attached
     *
     * @return
     */
    public boolean errorIsDispalyed() {
        waitForElementToBeVisible(errorCvTooltip);
        return errorCvTooltip.isDisplayed();
    }
}