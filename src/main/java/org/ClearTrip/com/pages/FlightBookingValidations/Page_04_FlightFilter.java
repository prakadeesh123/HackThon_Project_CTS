package org.ClearTrip.com.pages.FlightBookingValidations;

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

public class Page_04_FlightFilter {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public static final Logger log =
            LoggerFactory.getLogger(Page_04_FlightFilter.class);

    public Page_04_FlightFilter(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
        log.info("Page_04_FlightFilter page initialized");
    }

    @FindBy(xpath = "//input[@placeholder='Where from?']")
    private WebElement sourceInput;

    @FindBy(xpath = "//input[@placeholder='Where to?']")
    private WebElement destinationInput;

    @FindBy(xpath = "//div//h4[normalize-space()='Search flights']")
    private WebElement searchButton;

    @FindBy(xpath = "//p[contains(text(),'Chennai, IN - Chennai Airport')]")
    private WebElement chennai;

    @FindBy(xpath = "//p[contains(text(),'Mumbai, IN - Chatrapati Shivaji Airport')]")
    private WebElement mumbai;

    @FindBy(xpath = "//div[@data-testid='dateSelectOnward']")
    private WebElement departureDateField;

    @FindBy(xpath = "//div[@role='gridcell' and @aria-label='Tue Jun 02 2026']")
    private WebElement departureDate;

    @FindBy(xpath = "//div[.//p[normalize-space()='Early morning']]")
    private WebElement earlyMorningFilter;

    @FindBy(xpath = "//div[.//p[normalize-space()='Afternoon']]")
    private WebElement afternoonFilter;

    @FindBy(xpath = "//h4[normalize-space()='Book']/ancestor::button")
    private WebElement bookButton;

    @FindBy(xpath = "//button[.//h3[normalize-space()='Continue']]")
    private WebElement continueButton;

    private void jsScrollAndClick(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        js.executeScript("arguments[0].click();", element);
        log.info("Scrolled and clicked element using JavaScript");
    }

    public void applyFlightFilterAndContinue() {

        log.info("Starting flight filter and booking flow");

        wait.until(ExpectedConditions.elementToBeClickable(sourceInput)).click();
        wait.until(ExpectedConditions.elementToBeClickable(chennai)).click();
        log.info("Source selected as Chennai");

        wait.until(ExpectedConditions.elementToBeClickable(destinationInput)).click();
        wait.until(ExpectedConditions.elementToBeClickable(mumbai)).click();
        log.info("Destination selected as Mumbai");

        wait.until(ExpectedConditions.elementToBeClickable(departureDateField)).click();
        wait.until(ExpectedConditions.elementToBeClickable(departureDate)).click();
        log.info("Departure date selected");

        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        log.info("Search flights button clicked");

        jsScrollAndClick(earlyMorningFilter);
        log.info("Early morning flight filter applied");

        jsScrollAndClick(afternoonFilter);
        log.info("Afternoon flight filter applied");

        wait.until(ExpectedConditions.elementToBeClickable(bookButton)).click();
        log.info("Book button clicked");

        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
        log.info("Continue button clicked");

        String parentWindow = driver.getWindowHandle();

        wait.until(d -> driver.getWindowHandles().size() > 1);
        log.info("New window detected, switching window");

        for (String window : driver.getWindowHandles()) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                log.info("Switched to itinerary window");
                break;
            }
        }
    }

    public boolean isItineraryPageDisplayed() {
        try {
            WebElement header = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//h1[contains(text(),'Review your itinerary')]")
                    )
            );
            boolean isDisplayed = header.isDisplayed();
            log.info("Itinerary page displayed: {}", isDisplayed);
            return isDisplayed;
        } catch (Exception e) {
            log.error("Itinerary page not displayed", e);
            return false;
        }
    }
}