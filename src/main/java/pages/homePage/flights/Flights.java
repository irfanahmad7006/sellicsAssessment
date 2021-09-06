package pages.homePage.flights;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Flights {
    private WebDriver driver;
    public Flights(WebDriver driver){
        this.driver=driver;
    }
    private By flightResultGrid = By.xpath("//ul[@class = 'catalog-panel']/li");
    private By flightBookBtn = By.xpath("//ul[@class='catalog-panel']/li[1]/div/form/div/div[2]/div/button");

    public boolean isFlightAvailable(){
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(flightResultGrid));
        List<WebElement> flightAvailable = driver.findElements(flightResultGrid);
        System.out.println("Result size is: "+flightAvailable.size());
        if (flightAvailable.size()<0){
            return false;
        }else {
            return true;
        }
    }

    public void selectFlight(){
        WebDriverWait wait = new WebDriverWait(driver,30);

        try {
            Thread.sleep(20000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(flightBookBtn));
            wait.until(ExpectedConditions.elementToBeClickable(flightBookBtn));
            driver.findElement(flightBookBtn).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
