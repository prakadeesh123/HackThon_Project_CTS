package org.ClearTrip.com.pages.HotelBookingFilters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Log4j imports
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheckAvailableAmenities {

    private WebDriver driver;
    private WebDriverWait wait;

    // Logger initialization
    private static final Logger log = LogManager.getLogger(CheckAvailableAmenities.class);

    @FindBy(xpath = "(//h4[@class='sc-fqkvVR dCYktD'])[2]")
    private WebElement seeAll;

    @FindBy(xpath = "(//p[@class='sc-fqkvVR kYRxQA'])[15]")
    private WebElement gAmenities;

    public CheckAvailableAmenities(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
        log.info("CheckAvailableAmenities Page Initialized");
    }
    public void clickSee(){
        try {
            log.info("Attempting to click 'See All' button");
            wait.until(ExpectedConditions.elementToBeClickable(seeAll)).click();
            log.info("'See All' button clicked successfully");

        } catch (Exception e) {
            log.error("Failed to click 'See All' button", e);
        }
    }
    public boolean validateAmenities(){
        try {
            log.info("Validating amenities visibility");
            boolean status = wait.until(ExpectedConditions.visibilityOf(gAmenities)).isDisplayed();
            log.info("Amenities visibility: " + status);
            return status;
        } catch (Exception e){
            log.error("Amenities validation failed", e);
            return false;
        }
    }
}