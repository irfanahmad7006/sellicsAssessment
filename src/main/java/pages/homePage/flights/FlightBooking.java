package pages.homePage.flights;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FlightBooking {
    WebDriver driver;

    public FlightBooking(WebDriver driver) {
        this.driver = driver;
    }

    private By flightBookingHeading = By.xpath("//h2[contains(text(),'Flights Booking')]");
    private By firstName = By.xpath("//input[@name='firstname']");
    private By lastName = By.xpath("//input[@name='lastname']");
    private By email = By.xpath("//input[@name='email']");
    private By phone = By.xpath("//input[@name='phone']");
    private By address = By.xpath("//input[@name='address']");
    private By country = By.xpath("//span[contains(@id,'select2-country_code')]");
    private By nation = By.xpath("//span[contains(@id,'select2-nationality')]");


    public boolean isFlightBookingPage() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(flightBookingHeading));
        String title = driver.getTitle();
        System.out.println(title);
        if (title.equalsIgnoreCase("Flight Booking - PHPTRAVELS")) {
            return true;
        } else {
            return false;
        }
    }

    public void fillPersonalinfo(String fn, String ln, String em, String ph, String add, String cntry, String ntion) {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(fn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName));
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(ln);
        wait.until(ExpectedConditions.visibilityOfElementLocated(email));
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(em);
        wait.until(ExpectedConditions.visibilityOfElementLocated(phone));
        driver.findElement(phone).clear();
        driver.findElement(phone).sendKeys(ph);
        wait.until(ExpectedConditions.visibilityOfElementLocated(address));
        driver.findElement(address).clear();
        driver.findElement(address).sendKeys(add);
        wait.until(ExpectedConditions.visibilityOfElementLocated(country));
        wait.until(ExpectedConditions.elementToBeClickable(country));
        driver.findElement(country).click();
        String countryTextBox = "/html/body/span/span/span[1]/input";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(countryTextBox)));
        driver.findElement(By.xpath(countryTextBox)).sendKeys(cntry);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='select2-results']/ul/li[1]")));
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        driver.findElement(By.xpath("//span[@class='select2-results']/ul/li[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(nation));
//        driver.findElement(nation).clear();


    }
}
