package org.ClearTrip.com.pages.HotelBookingFunctsPrices;

import org.ClearTrip.com.baseclass.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger logger = LogManager.getLogger(PassengerDetailsContinuePay.class);

    @FindBy(xpath = "(//p[@class='sc-fqkvVR jJpeiQ'])[8]")
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
    private WebElement qrCode;

    @FindBy(xpath = "//div[@dir='ltr']/child::span")
    private WebElement navigateToFinalPage;

    public PassengerDetailsContinuePay(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        logger.info("PassengerDetailsContinuePay page initialized");
    }
    public void fillPassDetails(){

        logger.info("Starting passenger details entry");
        wait.until(ExpectedConditions.elementToBeClickable(mr)).click();
        logger.info("Title selected: Mr");

        wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys("Kolathuru");
        logger.info("First name entered");

        wait.until(ExpectedConditions.visibilityOf(lastName)).sendKeys("Yaswanth kumar");
        logger.info("Last name entered");

        wait.until(ExpectedConditions.visibilityOf(mobile)).sendKeys("7093321464");
        logger.info("Mobile number entered");

        wait.until(ExpectedConditions.visibilityOf(email)).sendKeys("Yaswanth@gmail.com");
        logger.info("Email entered");

        wait.until(ExpectedConditions.visibilityOf(pan)).sendKeys("BLTPY6663A");
        logger.info("PAN entered");
        WebElement panConsentCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#panConsent.sc-tagGq.jUXzYv")));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", panConsentCheckbox);
        logger.info("PAN consent checkbox clicked");

        WebElement continueToPayBtn = wait.until(ExpectedConditions.elementToBeClickable(continueToPayment));
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", continueToPayBtn);
        js.executeScript("arguments[0].click();", continueToPayBtn);
        logger.info("Clicked Continue to Payment button");
    }

    public boolean validatePaymentPage(){

        logger.info("Validating payment page elements");

        boolean navigationVisible = wait.until(ExpectedConditions.visibilityOf(navigateToFinalPage)).isDisplayed();
        logger.info("Final page navigation visible: {}", navigationVisible);

        boolean qrCodeVisible = wait.until(ExpectedConditions.visibilityOf(qrCode)).isDisplayed();
        logger.info("QR Code visible: {}", qrCodeVisible);

        if (navigationVisible && qrCodeVisible) {
            logger.info("Payment page validation PASSED");
            return true;
        } else {
            logger.error("Payment page validation FAILED");
            return false;
        }
    }
}
