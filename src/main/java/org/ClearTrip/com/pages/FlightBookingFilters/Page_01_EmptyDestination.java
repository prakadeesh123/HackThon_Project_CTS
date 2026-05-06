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

public class Page_01_EmptyDestination {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public static final Logger log = LoggerFactory.getLogger(Page_01_EmptyDestination.class);

    // Close popup button
    @FindBy(xpath = "//*[local-name()='svg' and @data-testid='closeIcon']")
    private WebElement closePopUp;

    // Search button
    @FindBy(xpath = "//h4[normalize-space(text())='Search flights']")
    private WebElement search_btn;

    @FindBy(xpath= "//span[text()='Enter departure and arrival airports / cities']")
    private WebElement destination_error_msg;

    public Page_01_EmptyDestination(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        log.info("Page_01_EmptyDestination initialized");
    }

    //HomePage PopUp Button
    public void closePopUp() {
        wait.until(ExpectedConditions.elementToBeClickable(closePopUp)).click();
        log.info("Closed homepage popup");
    }

    //HomePage Search Button
    public void click_search_btn() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(search_btn)).click();
            log.info("Clicked search button");
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", search_btn);
            log.info("Search button click intercepted, fallback JS click executed");
        }
    }

    //Empty Destination Error method
    public String destination_error() {
        closePopUp();
        click_search_btn();
        try {
            String errorMsg = wait.until(ExpectedConditions.visibilityOf(destination_error_msg)).getText();
            log.info("Error shown: {}", errorMsg);
            return errorMsg;
        } catch (Exception e) {
            log.info("No error, continuing with the booking...");
            return null;
        }
    }
}
