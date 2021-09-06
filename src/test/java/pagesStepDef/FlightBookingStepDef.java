package pagesStepDef;

import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.homePage.flights.FlightBooking;

public class FlightBookingStepDef {
    private FlightBooking flightBooking = new FlightBooking(DriverFactory.getDriver());

    @Then("user is on Flight booking page")
    public void user_is_on_flight_booking_page() {
        Assert.assertTrue(flightBooking.isFlightBookingPage());
    }

    @And("user fills personal info data {string}, {string},{string},{string},{string},{string} and {string}")
    public void userFillsPersonalInfoDataAnd(String firstName, String lastName, String email, String phone, String address, String country, String nationality) {
      flightBooking.fillPersonalinfo(firstName,lastName,email,phone,address,country,nationality);
    }
}
