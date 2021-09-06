package pagesStepDef;

import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.homePage.flights.Flights;

public class FlightsPageStepDef {

    private Flights flights = new Flights(DriverFactory.getDriver());

    @Then("user sees the flight result")
    public void user_sees_the_flight_result() {
        System.out.println(flights.isFlightAvailable());
    }


    @And("user select the flight")
    public void userSelectTheFlight() {
        flights.selectFlight();
    }
}
