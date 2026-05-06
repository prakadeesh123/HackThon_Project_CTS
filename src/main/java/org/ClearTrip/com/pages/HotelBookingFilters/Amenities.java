package org.ClearTrip.com.pages.HotelBookingFilters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class Amenities {

    public WebDriver driver;
    public WebDriverWait wait;

    public static final Logger log =LoggerFactory.getLogger(Amenities.class);

    @FindBy(xpath = "//p[text()='All filters']")
    private WebElement filterbtn;

    @FindBy(xpath = "//p[text()='Airport shuttle service']")
    private WebElement airport;

    @FindBy(xpath = "//p[text()='Parking']")
    private WebElement parking;

    @FindBy(xpath = "//button[@class='sc-kAyceB ZTUrw']")
    private WebElement applybtn;

    @FindBy(xpath="//p[text()='Airport shuttle service']")
    private WebElement dealvalidation1;

    @FindBy(xpath = "//p[text()='Parking']")
    private WebElement dealvalidation2;


    public Amenities(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver , Duration.ofSeconds(25));
        PageFactory.initElements(driver , this);
        log.info("Amenities page is initialized");
    }
    public void Anemetiescheck(){

        try {

            wait.until(ExpectedConditions.elementToBeClickable(filterbtn)).click();
            log.info("Filter button opened");

            wait.until(ExpectedConditions.elementToBeClickable(airport)).click();
            log.info("Airport filter selected");

            wait.until(ExpectedConditions.elementToBeClickable(parking)).click();
            log.info("Parking filter is selected");

            wait.until(ExpectedConditions.elementToBeClickable(applybtn)).click();
            log.info("All filters applied successfully");
        }
        catch (Exception e) {
            e.printStackTrace();
            log.info("Filters not applied");
        }
    }
    public boolean validation() {

        try {

            wait.until(ExpectedConditions.visibilityOf(dealvalidation1));
            wait.until(ExpectedConditions.visibilityOf(dealvalidation2));

            boolean isDeal1Displayed = dealvalidation1.isDisplayed();
            boolean isDeal2Displayed = dealvalidation2.isDisplayed();

            log.info("Airport Shuttle Service Displayed: " + isDeal1Displayed);
            log.info("Parking Displayed: " + isDeal2Displayed);

            return isDeal1Displayed && isDeal2Displayed;

        } catch (Exception e) {
            log.error("Deal validation failed", e);
            return false;
        }
    }
}
