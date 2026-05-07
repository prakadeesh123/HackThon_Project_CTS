package org.ClearTrip.com.pages.FlightBookingFilters;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Page_03_FilterOnArrivalTime {

    private WebDriver driver;
    private WebDriverWait wait;
    public static final Logger log = LoggerFactory.getLogger(Page_03_FilterOnArrivalTime.class);

    public Page_03_FilterOnArrivalTime(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        log.info("Page_03_FilterOnArrivalTime initialized");
    }

    @FindBy(xpath = "//span[contains(text(),'Adult')]/following-sibling::span//*[local-name()='svg']")
    private WebElement travellers_dropdown;

    @FindBy(xpath = "//p[contains(text() , 'Business class')]")
    private WebElement business_class;

    @FindBy(xpath = "//p[normalize-space(text())='Landing in Pune']/following::input /following::p[normalize-space(text())='Evening']")
    private WebElement time_filter;

    @FindBy(xpath = "//div[.//p[normalize-space()='Clear all filters']]//p[normalize-space()='4 PM - 8 PM']")
    private WebElement time_range;
    public void filter_time() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(time_filter)).click();
            log.info("Evening time filter applied");
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", time_filter);
            log.info("Evening time filter applied via JS fallback");
        }
    }

    public void setBusiness_class() {
        wait.until(ExpectedConditions.elementToBeClickable(travellers_dropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(business_class)).click();
        log.info("Business class selected");
    }

    public boolean isTimeRangeDisplayed() {
        try {
            boolean displayed = time_range.isDisplayed();
            log.info("Time range '4 PM - 8 PM' displayed: {}", displayed);
            return displayed;
        } catch (Exception e) {
            log.error("Time range '4 PM - 8 PM' not found", e);
            return false;
        }
    }
}
