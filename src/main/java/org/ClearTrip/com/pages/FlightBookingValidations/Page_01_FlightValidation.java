package org.ClearTrip.com.pages.FlightBookingValidations;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class Page_01_FlightValidation {

    WebDriver driver;
    WebDriverWait wait;

     public static final Logger log = LoggerFactory.getLogger(Page_01_FlightValidation.class);

    public Page_01_FlightValidation(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        log.info("Page_01_FlightValidation page initialized");
    }

    @FindBy(xpath = "//div[@class='pb-1 px-1 flex flex-middle nmx-1']")
    public WebElement closePopUp;

    @FindBy(xpath = "//div[@class='closeit']")
    private WebElement PopUP;

    @FindBy(xpath = "//div//p[normalize-space()='Hotels']")
    private WebElement Hotels;

    @FindBy(xpath = "//p[contains(text(),'Flights')]")
    private WebElement Flight;

    @FindBy(xpath = "//h2[contains(text(),'Book Domestic and International Flight Tickets at Lowest Airfares on Cleartrip')]")
    private WebElement Text;

    public void closePopUp() {
        log.info("Closing initial popup");
        wait.until(ExpectedConditions.elementToBeClickable(closePopUp)).click();
    }

    public void PopUp() {
        log.info("Closing secondary popup");
        wait.until(ExpectedConditions.elementToBeClickable(PopUP)).click();
    }

    public void ClickHotel() {
        log.info("Clicking on Hotels tab");
        wait.until(ExpectedConditions.elementToBeClickable(Hotels)).click();
    }

    public void Flight() {
        log.info("Clicking on Flights tab");
        wait.until(ExpectedConditions.elementToBeClickable(Flight)).click();
    }

    public void slowScrollDown() {
        log.info("Performing slow scroll down");
        Actions actions = new Actions(driver);
        for (int i = 0; i < 3; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                log.error("Scroll interrupted", e);
            }
        }
    }
    public Boolean Text() {
        boolean isDisplayed =
                wait.until(ExpectedConditions.visibilityOf(Text)).isDisplayed();
        log.info("Flight page heading displayed: {}", isDisplayed);
        return isDisplayed;
    }
}