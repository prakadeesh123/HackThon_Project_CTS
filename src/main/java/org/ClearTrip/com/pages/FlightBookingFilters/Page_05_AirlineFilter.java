package org.ClearTrip.com.pages.FlightBookingFilters;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Page_05_AirlineFilter {

    private WebDriver driver;
    private WebDriverWait wait;
    public static final Logger log = LoggerFactory.getLogger(Page_05_AirlineFilter.class);

    public Page_05_AirlineFilter(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        log.info("Page_05_AirlineFilter initialized");
    }

    @FindBy(css = "div[style*='width:32px'][style*='height:20px']")
    private WebElement nonstop_toggle;

    @FindBy(xpath = "//input[@type='checkbox']//following::p[normalize-space()='Air India'][1]")
    private WebElement airindia_checkbox;

    @FindBy(xpath = "//input[@type='checkbox']//following::p[normalize-space()='IndiGo'][1]")
    private WebElement indigo_checkbox;

    @FindBy(xpath = "//p[normalize-space()='Flight Details']/preceding::p[normalize-space()='IndiGo'][1]")
    private WebElement indigoFlightDetails;

    public void setNonstop_toggle() {
        wait.until(ExpectedConditions.elementToBeClickable(nonstop_toggle)).click();
        log.info("Non-stop toggle applied");
    }

    public void airline_checkbox() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", airindia_checkbox);
        wait.until(ExpectedConditions.elementToBeClickable(airindia_checkbox)).click();
        log.info("Air India checkbox clicked");

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", indigo_checkbox);
        wait.until(ExpectedConditions.elementToBeClickable(indigo_checkbox)).click();
        log.info("IndiGo checkbox clicked");
    }

    public boolean isAirIndiaSelected() {
        boolean selected = wait.until(ExpectedConditions.visibilityOf(airindia_checkbox)).isSelected();
        log.info("Air India checkbox selected state: {}", selected);
        return selected;
    }

    public boolean isIndigoSelected() {
        boolean selected = wait.until(ExpectedConditions.visibilityOf(indigo_checkbox)).isSelected();
        log.info("IndiGo checkbox selected state: {}", selected);
        return selected;
    }


    public boolean isIndigoFlightPresent() {
        try {
            boolean displayed = wait.until(ExpectedConditions.visibilityOf(indigoFlightDetails)).isDisplayed();
            return displayed;
        } catch (Exception e) {
            return false;
        }
    }

}
