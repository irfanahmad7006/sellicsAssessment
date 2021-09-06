package pagesStepDef;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import pages.homePage.visa.Visa;

public class VisaStepDef {
    private Visa visaPage = new Visa(DriverFactory.getDriver());

    @Given("User selects From Country {string} from the dropdown")
    public void user_selects_from_country_from_the_dropdown(String string) throws InterruptedException {
        visaPage.searchSelectFromCountry(string);
    }

    @Given("User selects To Country {string} from the dropdown")
    public void user_selects_to_country_from_the_dropdown(String string) throws InterruptedException {
        visaPage.searchSelectToCountry(string);
    }

    @Given("User enters {string} date")
    public void user_enters_date(String string) {
        visaPage.setDate(string);
    }

    @Given("User clicks on Submit button")
    public void user_clicks_on_submit_button() {
        visaPage.clickOnSubmit();
    }

}
