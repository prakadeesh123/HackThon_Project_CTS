package org.ClearTrip.com.pages.FlightBookingValidations;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page_04_FlightFilter {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public Page_04_FlightFilter(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    // ================= ROUTE INPUTS =================

    @FindBy(xpath = "//input[@placeholder='Where from?']")
    private WebElement sourceInput;

    @FindBy(xpath = "//input[@placeholder='Where to?']")
    private WebElement destinationInput;

    @FindBy(xpath = "(//div[@class='sc-aXZVg ibgoAF'])[2]")
    private WebElement searchButton;

    @FindBy(xpath = "//p[contains(text(),'Chennai, IN - Chennai Airport')]")
    private WebElement chennai;

    @FindBy(xpath = "//p[contains(text(),'Mumbai, IN - Chatrapati Shivaji Airport')]")
    private WebElement mumbai;

    // ================= DATE =================

    @FindBy(xpath = "//div[@data-testid='dateSelectOnward']")
    private WebElement departureDateField;

    @FindBy(xpath = "//div[@role='gridcell' and @aria-label='Tue Jun 02 2026']")
    private WebElement departureDate;

    // ================= FILTERS =================

    @FindBy(xpath = "//div[.//p[normalize-space()='Early morning']]")
    private WebElement earlyMorningFilter;

    @FindBy(xpath = "//div[.//p[normalize-space()='Afternoon']]")
    private WebElement afternoonFilter;

    // ================= BUTTONS =================

    @FindBy(xpath = "//h4[normalize-space()='Book']/ancestor::button")
    private WebElement bookButton;

    @FindBy(xpath = "//button[.//h3[normalize-space()='Continue']]")
    private WebElement continueButton;

    // ================= HELPER =================

    private void jsScrollAndClick(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        js.executeScript("arguments[0].click();", element);
    }

    // ================= MAIN FLOW =================

    public void applyFlightFilterAndContinue() {

        wait.until(ExpectedConditions.elementToBeClickable(sourceInput)).click();
        wait.until(ExpectedConditions.elementToBeClickable(chennai)).click();

        wait.until(ExpectedConditions.elementToBeClickable(destinationInput)).click();
        wait.until(ExpectedConditions.elementToBeClickable(mumbai)).click();

        wait.until(ExpectedConditions.elementToBeClickable(departureDateField)).click();
        wait.until(ExpectedConditions.elementToBeClickable(departureDate)).click();

        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();

        jsScrollAndClick(earlyMorningFilter);
        jsScrollAndClick(afternoonFilter);

        wait.until(ExpectedConditions.elementToBeClickable(bookButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();

        // ===== SWITCH TO NEW TAB =====
        String parentWindow = driver.getWindowHandle();

        wait.until(d -> driver.getWindowHandles().size() > 1);

        for (String window : driver.getWindowHandles()) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    // ================= ASSERTION METHOD =================

    public boolean isItineraryPageDisplayed() {
        try {
            WebElement header = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//h1[contains(text(),'Review your itinerary')]")
                    )
            );
            return header.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}