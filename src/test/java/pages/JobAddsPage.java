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
    WebElement nameInput;

    @FindBy(id = "surname")
    WebElement surnameInput;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "recruitment_consent_yes")
    WebElement checkboxMandatory;

    @FindBy(xpath = "//*[@id=\"form_job_application\"]//*[@id=\"submit_btn\"]")
    WebElement submitButton;

    @FindBy(id = "Zebra_Form_error_message_upload_file")
    WebElement errorCvTooltip;


    public JobAddsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public JobAddsPage fillNameField(String name) {
        nameInput.sendKeys(name);
        return this;
    }

    public JobAddsPage fillSurnameField(String surname) {
        surnameInput.sendKeys(surname);
        return this;
    }

    public JobAddsPage fillEmailField(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public JobAddsPage selectMandatoryCheckbox() {
        checkboxMandatory.click();
        return this;
    }

    public JobAddsPage sendApplication() {
        submitButton.click();
        return this;
    }

    public boolean errorIsDispalyed() {
        return errorCvTooltip.isDisplayed();
    }
}