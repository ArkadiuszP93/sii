package tests;

import org.testng.annotations.Test;
import pages.JobAddsPage;
import pages.MenuPage;
import testData.TestData;

import static org.testng.Assert.assertTrue;

public class SendApplicationWithoutCvTest extends TestBase implements TestData {

    /**
     * Test to send an application without added cv
     * Error CV tooltip should be displayed
     */
    @Test
    public void testSendApplicationWithoutCv() {
        JobAddsPage jobAddsPage = new JobAddsPage(driver);
        MenuPage menuPage = new MenuPage(driver);
        JobAddsPage careersPage = menuPage.goToCareersPage()
                .setFilters(KEYWORDS, LOCATION)
                .chooseJobOffer()
                .fillNameField(NAME)
                .fillSurnameField(SURNAME)
                .fillEmailField(EMAIL)
                .selectMandatoryCheckbox()
                .sendApplication();

        assertTrue(jobAddsPage.errorIsDispalyed(), "CV error tooltip is not visible");
    }
}
