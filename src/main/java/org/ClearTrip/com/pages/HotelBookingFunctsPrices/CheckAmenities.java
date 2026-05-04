package org.ClearTrip.com.pages.HotelBookingFunctsPrices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class CheckAmenities {

    private static final Logger log =
            LoggerFactory.getLogger(CheckAmenities.class);

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//p[contains(text(),'Terrace')]")
    private WebElement terrace;

    @FindBy(xpath = "//p[contains(text(),'Library')]")
    private WebElement library;

    public CheckAmenities(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
        log.info("CheckAmenities page initialized");
    }

    public boolean validateAmenities(){

        log.info("Validating amenities availability");

        boolean terraceVisible =
                wait.until(ExpectedConditions.visibilityOf(terrace)).isDisplayed();
        log.info("Terrace visibility status: {}", terraceVisible);

        boolean libraryVisible =
                wait.until(ExpectedConditions.visibilityOf(library)).isDisplayed();
        log.info("Library visibility status: {}", libraryVisible);

        boolean finalStatus = terraceVisible && libraryVisible;

        log.info("Amenities validation result: {}", finalStatus);

        return finalStatus;
    }
}