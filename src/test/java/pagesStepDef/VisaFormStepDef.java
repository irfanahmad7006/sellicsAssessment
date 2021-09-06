package pagesStepDef;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.homePage.visa.VisaForm;

public class VisaFormStepDef {
    private VisaForm visaFormPage = new VisaForm(DriverFactory.getDriver());

    @Given("User is on Submission form page")
    public void user_is_on_submission_form_page() {
        Assert.assertTrue(visaFormPage.isFormPresent(),"User is on Visa Submission Form");
    }

    @Given("user fills personal info data {string}, {string},{string},{string},{string} and {string}")
    public void user_fills_personal_info_data_and(String fn, String ln, String email, String phone, String date, String notes) {
        visaFormPage.fillSubForm(fn,ln,email,phone,date,notes);
    }

    @Then("user is on submission page and with given text {string} displayed")
    public void userIsOnSubmissionPageAndWithGivenTextDisplayed(String txt) {
        Assert.assertTrue(visaFormPage.isOnSubmissionPage());
        Assert.assertEquals(txt,visaFormPage.getConfrimationText());
    }

    @Then("user clicks on submit button")
    public void userClicksOnSubmitButton() {
        visaFormPage.clickOnSubmitBtn();
    }
}
