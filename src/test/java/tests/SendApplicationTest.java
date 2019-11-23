package tests;

import org.testng.annotations.Test;
import testData.TestData;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SendApplicationTest extends TestBase implements TestData {

    /**
     * Test to search job offer
     */
    @Test
    public void testCheckJobName() {
        menu.goToCareersPage()
                .setFilters(JOB_NAME, LOCATION);

        assertEquals(JOB_NAME.toUpperCase(), careers.getJobName(), "Job name title is incorrect");
    }

    /**
     * Test to send an application without added cv
     * Error CV tooltip should be displayed
     */
    @Test(dependsOnMethods = "testCheckJobName")
    public void testSendApplicationWithoutCv() {
        careers.chooseJobOffer()
                .fillNameField(NAME)
                .fillSurnameField(SURNAME)
                .fillEmailField(EMAIL)
                .selectMandatoryCheckbox()
                .sendApplication();

        assertTrue(jobAdds.errorIsDispalyed(), "CV error tooltip is not visible");
    }
}
