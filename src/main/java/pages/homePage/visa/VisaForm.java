package pages.homePage.visa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VisaForm {
    WebDriver driver;

    public VisaForm(WebDriver driver) {
        this.driver = driver;
    }


    private By visaSubmissionForm = By.xpath("//h3[@class='title']");

    private By firstName = By.xpath("//input[@name='first_name']");
    private By lastName = By.xpath("//input[@name='last_name']");
    private By email = By.xpath("//input[@name='email']");
    private By phone = By.xpath("//input[@name='phone']");
    private By date = By.xpath("//input[@name='date']");
    private By notes = By.xpath("//textarea[@placeholder='Notes']");

    private By submitBtn = By.xpath("//button[@id='submit']//i");

    private By submissionStatus = By.xpath("//h2[@class='sec__title_list text-center my-5']/strong");
    private By submissionText = By.xpath("//h2[text()='Your visa form has been submitted']");

    public boolean isFormPresent() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(visaSubmissionForm));
        if (driver.findElement(visaSubmissionForm).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public void fillSubForm(String fn, String ln, String mail, String ph, String dt, String notesTxt) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
        driver.findElement(firstName).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName));
        driver.findElement(lastName).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(email));
        driver.findElement(email).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(phone));
        driver.findElement(phone).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(date));
        wait.until(ExpectedConditions.visibilityOfElementLocated(notes));
        driver.findElement(notes).clear();

        driver.findElement(firstName).sendKeys(fn);
        driver.findElement(lastName).sendKeys(ln);
        driver.findElement(email).sendKeys(mail);
        driver.findElement(phone).sendKeys(ph);
//        driver.findElement(date).clear();
//        driver.findElement(date).sendKeys(dt);
        WebElement dateEle = driver.findElement(date);
        JavascriptExecutor jsExecutor = ((JavascriptExecutor)driver);
        jsExecutor.executeScript("arguments[0].setAttribute('value','"+dt+"');",dateEle);
        driver.findElement(notes).sendKeys(notesTxt);
    }
    public void clickOnSubmitBtn(){

        try {
            Thread.sleep(10000);
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
            driver.findElement(submitBtn).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public boolean isOnSubmissionPage(){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(submissionStatus));
        boolean val = driver.findElement(submissionStatus).isDisplayed();
        if (val){
            return true;
        }else{
            return false;
        }
    }

    public String getConfrimationText(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(submissionText));
        return driver.findElement(submissionText).getText();
    }

}
