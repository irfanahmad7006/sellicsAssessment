package pages.homePage.visa;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Visa {
    WebDriver driver;
    public Visa(WebDriver driver){
        this.driver=driver;
    }
    private By fromCountry = By.xpath("//span[@id = 'select2-from_country-container']");
    private By fromCountryInputBox = By.xpath("//input[@class='select2-search__field']");
    private By fromCountryResults = By.xpath("//ul[@id='select2-from_country-results']/li ");

    private By toCountry = By.xpath("//span[@id='select2-to_country-container']");
    private By toCountryInputBox = By.xpath("//input[@class='select2-search__field']");
    private By toCountryResults = By.xpath("//ul[@id='select2-to_country-results']/li ");

    private By dateField = By.xpath("//div[4]//input[@id='date' and @name = 'checkin']");
    private By submtBtn = By.xpath("//div[@id='visa']//button[@id='submit']/span[1]");

    public void searchSelectFromCountry(String countryName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(fromCountry));
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Thread.sleep(3000);
        driver.findElement(fromCountry).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(fromCountryInputBox));
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Thread.sleep(3000);
        driver.findElement(fromCountryInputBox).sendKeys(countryName);
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(fromCountryResults));
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        wait.until(ExpectedConditions.visibilityOfElementLocated(fromCountryResults));
        List<WebElement> listFromCountry = driver.findElements(fromCountryResults);
        if (listFromCountry.size()>=0){
            for (WebElement ele: listFromCountry){
                System.out.println(ele.getText());
                if (countryName.equalsIgnoreCase(ele.getText())){
//                    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                    Thread.sleep(3000);
                    ele.click();
                    break;
                }
            }
        }else {
            Assert.fail("<<<<<<Please check the country name OR no country found>>>>>");
        }
    }
    public void searchSelectToCountry(String countryName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(toCountry));
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(toCountry).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(toCountryInputBox));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Thread.sleep(3000);
        driver.findElement(toCountryInputBox).sendKeys(countryName);
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(toCountryResults));
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        List<WebElement> listFromCountry = driver.findElements(toCountryResults);
        if (listFromCountry.size()>=0){
            for (WebElement ele: listFromCountry){
                System.out.println(ele.getText());
                if (countryName.equalsIgnoreCase(ele.getText())){
//                    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                    Thread.sleep(3000);
                    ele.click();
                    break;
                }
            }
        }else {
            Assert.fail("<<<<<<Please check the country name because no country found>>>>>");
        }
    }
    public void setDate(String date){
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(dateField));
        JavascriptExecutor jsExecutor = ((JavascriptExecutor)driver);
        WebElement dateEle = driver.findElement(dateField);
        jsExecutor.executeScript("arguments[0].setAttribute('value','"+date+"');",dateEle);
        System.out.println("Date is entered");
    }

    public void clickOnSubmit(){
        driver.findElement(submtBtn).click();
    }
}
