package pagesStepDef;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.homePage.flights.Flights;
import pages.homePage.HomePage;

public class HomePageStepDef {
    private HomePage homePage = new HomePage(DriverFactory.getDriver());
    private Flights flights;
    @Given("User is on home page")
    public void user_is_on_home_page() {
        homePage.getTitle();
    }

    @Then("User prints the current url")
    public void user_prints_the_current_url() {
        homePage.getURL();
    }

    @Given("User clicks on {string} tab")
    public void user_clicks_on_tab(String tabName) {
        homePage.clickOnTabs(tabName);
        System.out.println("Test is passed");
    }

    @Given("User select {string} radio button")
    public void user_select_radio_button(String radioBtnName) {
        homePage.userSelectsRadioBtn(radioBtnName);
    }

    @Given("User enters flying from {string} source aiport name or IATA code")
    public void user_enters_flying_from_source_aiport_name_or_iata_code(String airportName) throws InterruptedException {
        homePage.enterSourceAirport(airportName);

    }

    @Given("User enters {string} destination aiport name or IATA code")
    public void user_enters_destination_aiport_name_or_iata_code(String string) {
        homePage.enterDestinationAirport(string);
    }

    @Given("user enters departure date {string}")
    public void user_enters_departure_date(String string) {
        homePage.enterDepartureDate(string);
    }

    @Given("user enters return date {string}")
    public void user_enters_return_date(String string) throws InterruptedException {
        homePage.enterReturnDate(string);
    }

    @Given("user clicks on search button")
    public void user_clicks_on_search_button() {
       homePage.clickOnSearchBtn();
    }
}
