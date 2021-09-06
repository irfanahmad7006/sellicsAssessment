package pages.homePage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By name = By.id("matterway");
    By hotelTab = By.xpath("//button[@id='hotels-tab' and @aria-controls='hotels']");
    By flightTab = By.xpath("//button[@id='hotels-tab' and @aria-controls='flights']");
    By toursTab = By.xpath("//button[@id='tours-tab' and @aria-controls='tours']");
    By visaTab = By.xpath("//button[@id='visa-tab' and @aria-controls='visa']");
    By oneWayRadioBtn = By.xpath("//input[@id='one-way' and @type = 'radio']");
    By roundTripRadioBtn = By.id("round-trip");
    By sourceAirport = By.xpath("//input[@id='autocomplete' and @placeholder='Flying From']");
    By destinationAirport = By.xpath("//input[@id='autocomplete2' and @placeholder='To Destination']");
    By searchBtn = By.xpath("//*[@id='flights-search']/span[1]");


    public void getTitle() {
        System.out.println(driver.getTitle());
    }

    public void getURL() {
        System.out.println(driver.getCurrentUrl());
//        driver.findElement(By.xpath("irfan"));
    }

    public void clickOnTabs(String tabName) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        switch (tabName) {
            case "hotels":
                wait.until(ExpectedConditions.visibilityOfElementLocated(hotelTab));
                driver.findElement(hotelTab).click();
                break;
            case "flights":
                wait.until(ExpectedConditions.visibilityOfElementLocated(flightTab));
                driver.findElement(flightTab).click();
                break;
            case "tours":
                wait.until(ExpectedConditions.visibilityOfElementLocated(toursTab));
                driver.findElement(toursTab).click();
                break;
            case "visa":
                wait.until(ExpectedConditions.visibilityOfElementLocated(visaTab));
                driver.findElement(visaTab).click();
                break;
            default:
                System.out.println("<<<<<<<<<<<<<<>>>>>>>>>>>>>>>");
                Assert.fail("<<<<<<<<<<Please enter the correct tab name <OR> Please check the case sensitivity, use lower case only>>>>>>>>");
                System.out.println("<<<<<<<<<<<<<<>>>>>>>>>>>>>>>");
        }
    }

    public void userSelectsRadioBtn(String btnName) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        if (btnName.equalsIgnoreCase("one way")) {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(oneWayRadioBtn));
            driver.findElement(oneWayRadioBtn).click();
        } else if (btnName.equalsIgnoreCase("round trip")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(roundTripRadioBtn)).click();
            driver.findElement(roundTripRadioBtn).click();
        } else {
            System.out.println("<<<<<<<<<<<<<<>>>>>>>>>>>>>>>");
            Assert.fail("<<<<<<<<<<Please enter correct radio button name>>>>>>>>");
            System.out.println("<<<<<<<<<<<<<<>>>>>>>>>>>>>>>");
        }
    }

    public void enterSourceAirport(String airportNameOrCode) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        if (airportNameOrCode.length() == 3) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(sourceAirport));
            System.out.println("<<<<<<<<<<< " + airportNameOrCode + " >>>>>>>>>>>>>> CODE");
            driver.findElement(sourceAirport).sendKeys(airportNameOrCode.toUpperCase());
        } else {
            driver.findElement(sourceAirport).sendKeys(airportNameOrCode);
            Thread.sleep(5000);
//            String autoSelectNodes = "//input[@id='autocomplete' and @placeholder='Flying From']//parent::div[@class='autocomplete-wrapper _1 row_1']//preceding-sibling::div/div[@class='autocomplete-location']";
            String typeAheadResult = "//input[@id='autocomplete' and @placeholder='Flying From']//parent::div[@class='autocomplete-wrapper _1 row_1']//preceding-sibling::div/strong";
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(typeAheadResult)));
            List<WebElement> airportList = driver.findElements(By.xpath(typeAheadResult));
            for (WebElement ele : airportList) {
                System.out.println(ele.getText().contains(airportNameOrCode) + ">>>>>>>");
                if (ele.getText().contains(airportNameOrCode)) {
                    ele.click();
                    break;
                }
            }
        }
    }

    public void enterDestinationAirport(String airportNameOrCode) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        if (airportNameOrCode.length() == 3) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(destinationAirport));
            System.out.println("<<<<<<<<<<< " + airportNameOrCode + " >>>>>>>>>>>>>> CODE");
            driver.findElement(destinationAirport).sendKeys(airportNameOrCode.toUpperCase());
        } else {

        }
    }

    public void enterDepartureDate(String date) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("departure")));
        JavascriptExecutor jsExecutor = ((JavascriptExecutor)driver);
        WebElement dateEle = driver.findElement(By.id("departure"));
        jsExecutor.executeScript("arguments[0].setAttribute('value','"+date+"');",dateEle);

//        removed sendKeys methods instead used the javascript executor
/*
        try {
            driver.findElement(By.id("departure")).clear();
            Thread.sleep(1000);
            driver.findElement(By.id("departure")).sendKeys(date);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }

    public void enterReturnDate(String date) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("return")));
        JavascriptExecutor jsExecutor = ((JavascriptExecutor)driver);
        WebElement dateEle = driver.findElement(By.id("return"));
        jsExecutor.executeScript("arguments[0].setAttribute('value','"+date+"');",dateEle);
/*
        Thread.sleep(1000);
        driver.findElement(By.id("return")).clear();
        driver.findElement(By.id("return")).sendKeys(date);
        */
    }

    public void clickOnSearchBtn(){
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        driver.findElement(searchBtn).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
