package org.ClearTrip.com.pages.HotelBookingFunctsPrices;

import org.ClearTrip.com.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PassengerDetailsContinuePay extends BaseClass {
    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(xpath = "//p[contains(text(),\'Mr.\')]")
    private WebElement mr;

    @FindBy(css = "input#firstName")
    private WebElement firstName;

    @FindBy(css = "input#lastName")
    private WebElement lastName;

    @FindBy(css = "input#phoneNumber")
    private WebElement mobile;

    @FindBy(css = "input#email")
    private WebElement email;

    @FindBy(css = "input#pan")
    private WebElement pan;

    @FindBy(css = "input#panConsent.sc-tagGq.jUXzYv")
    private WebElement panconsent;

    @FindBy(css = "button.sc-kAyceB.dhBISf.sc-b19c115c-0.heCgQz")
    private WebElement continueToPayment;

    @FindBy(xpath = "//div[@class='flex flex-middle jc-center']/child::h4")
    private WebElement QrCOde;

    @FindBy(xpath = "//div[@dir='ltr']/child::span")
    private WebElement navigateToFinalPage;



    public PassengerDetailsContinuePay(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }
    public void fillPassDetails(){
        wait.until(ExpectedConditions.elementToBeClickable(mr)).click();
        wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys("Kolathuru");
        wait.until(ExpectedConditions.visibilityOf(lastName)).sendKeys("Yaswanth kumar");
        wait.until(ExpectedConditions.visibilityOf(mobile)).sendKeys("7093321464");
        wait.until(ExpectedConditions.visibilityOf(email)).sendKeys("Yaswanth@gmail.com");
        wait.until(ExpectedConditions.visibilityOf(pan)).sendKeys("BLTPY6663A");


        WebElement panconsent = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#panConsent.sc-tagGq.jUXzYv"))
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", panconsent);
        WebElement continueTopay = wait.until(ExpectedConditions.elementToBeClickable(continueToPayment));
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", continueTopay);
        js.executeScript("arguments[0].click();",continueTopay);

    }
    public boolean validatePaymentPage(){

        boolean a =  wait.until(ExpectedConditions.visibilityOf(navigateToFinalPage)).isDisplayed();
        boolean b = wait.until(ExpectedConditions.visibilityOf(QrCOde)).isDisplayed();
        return a==b;
    }


}
