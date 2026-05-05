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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class PassengerDetailsContinuePay extends BaseClass {

    private static final Logger log =
            LoggerFactory.getLogger(PassengerDetailsContinuePay.class);

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "(//p[@class='sc-fqkvVR jJpeiQ'])[6]")
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
        log.info("PassengerDetailsContinuePay page initialized");
    }

    public void fillPassDetails(){

        log.info("Starting passenger details entry");

        wait.until(ExpectedConditions.elementToBeClickable(mr)).click();
        log.info("Selected title: Mr");

        wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys("Kolathuru");
        log.info("Entered first name");

        wait.until(ExpectedConditions.visibilityOf(lastName)).sendKeys("Yaswanth kumar");
        log.info("Entered last name");

        wait.until(ExpectedConditions.visibilityOf(mobile)).sendKeys("7093321464");
        log.info("Entered mobile number");

        wait.until(ExpectedConditions.visibilityOf(email)).sendKeys("Yaswanth@gmail.com");
        log.info("Entered email address");

        wait.until(ExpectedConditions.visibilityOf(pan)).sendKeys("BLTPY6663A");
        log.info("Entered PAN number");

        WebElement panconsent = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("input#panConsent.sc-tagGq.jUXzYv"))
        );
        log.info("PAN consent checkbox located");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", panconsent);
        log.info("PAN consent checkbox clicked using JavaScript");

        WebElement continueTopay =
                wait.until(ExpectedConditions.elementToBeClickable(continueToPayment));

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", continueTopay);
        log.info("Scrolled to Continue to Payment button");

        js.executeScript("arguments[0].click();", continueTopay);
        log.info("Clicked Continue to Payment button");
    }

    public boolean validatePaymentPage(){

        log.info("Validating payment page");

        boolean a =
                wait.until(ExpectedConditions.visibilityOf(navigateToFinalPage)).isDisplayed();
        log.info("Navigation to final page visible: {}", a);

        boolean b =
                wait.until(ExpectedConditions.visibilityOf(QrCOde)).isDisplayed();
        log.info("QR code visible: {}", b);

        boolean result = a == b;
        log.info("Payment page validation result: {}", result);

        return result;
    }
}