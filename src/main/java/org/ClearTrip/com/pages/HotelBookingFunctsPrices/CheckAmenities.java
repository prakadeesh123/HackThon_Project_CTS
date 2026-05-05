package org.ClearTrip.com.pages.HotelBookingFunctsPrices;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckAmenities {

    private WebDriver driver;
    private WebDriverWait wait;

    private static final Logger logger = LogManager.getLogger(CheckAmenities.class);

    @FindBy(xpath = "(//p[@class='sc-fqkvVR bwtGcK pl-3'])[6]")
    private WebElement terrace;

    @FindBy(xpath = "(//p[@class='sc-fqkvVR bwtGcK pl-3'])[2]")
    private WebElement library;

    public CheckAmenities(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        logger.info("CheckAmenities page initialized");
    }
    public boolean validateAmenities(){
        logger.info("Validating hotel amenities: Terrace and Library");
        boolean terraceVisible = wait.until(
                ExpectedConditions.visibilityOf(terrace)
        ).isDisplayed();
        logger.info("Terrace visibility: {}", terraceVisible);
        boolean libraryVisible = wait.until(
                ExpectedConditions.visibilityOf(library)
        ).isDisplayed();
        logger.info("Library visibility: {}", libraryVisible);
        if (terraceVisible && libraryVisible) {
            logger.info("Amenity validation PASSED");
            return true;
        } else {
            logger.error("Amenity validation FAILED");
            return false;
        }
    }
}