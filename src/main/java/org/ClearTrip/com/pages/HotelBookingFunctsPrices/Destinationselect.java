package org.ClearTrip.com.pages.HotelBookingFunctsPrices;

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
import java.util.List;

public class Destinationselect {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    public static final Logger log = LoggerFactory.getLogger(Destinationselect.class);

    @FindBy(xpath = "//*[local-name()='svg' and @data-testid='closeIcon']")
    private WebElement closePopUp;

    @FindBy(xpath = "//p[normalize-space()='Holidays']")
    private WebElement holidaysMenu;

    @FindBy(xpath = "//li[@id='menu-item-1239220']//a[normalize-space()='All Destinations']")
    private WebElement allDestinationsLink;

    @FindBy(xpath = "//a[@href='https://www.cleartrip.com/holidays/destinations/europe/']")
    private WebElement europeDestination;

    @FindBy(xpath = "//div[@class='col-lg-4 mar-b-7 col-12 is-none is-lg-block']//i[5]")
    private WebElement fiveStarFilter;

    @FindBy(xpath = "//div[@class='star-value']")
    private List<WebElement> starValues;

    @FindBy(xpath = "//a[@href='https://www.cleartrip.com/holidays/package/eastern-europe-the-hidden-jewels/']")
    private WebElement easternEuropeHotel;

    @FindBy(xpath = "//h1[text()='Eastern Europe – The Hidden Jewels']")
    private WebElement validation;



    public Destinationselect(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void closePopUpIfPresent() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(closePopUp)).click();
            log.info("Popup closed successfully");
        } catch (Exception e) {
            log.info("Popup not present / already closed");
        }
    }

    public void clickHolidays() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(holidaysMenu)).click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", holidaysMenu);
        }
        log.info("Clicked on Holidays menu");
    }

    public void clickAllDestinations() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(allDestinationsLink)).click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", allDestinationsLink);
        }
        log.info("Clicked on All Destinations");
    }

    public void clickEuropeDestination() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(europeDestination)).click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", europeDestination);
        }
        log.info("Clicked on Europe destination");
    }

    public void selectFiveStar() {
        wait.until(ExpectedConditions.elementToBeClickable(fiveStarFilter)).click();
        log.info("Selected 5-star filter");
    }


    public void clickEasternEuropeHotel() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(easternEuropeHotel)).click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", easternEuropeHotel);
        }
        log.info("Clicked on Eastern Europe Hotel package");
    }

    public boolean isHotelPageOpened() {
        return driver.getCurrentUrl().contains("eastern-europe-the-hidden-jewels");
    }
    public boolean valid(){
        return wait.until(ExpectedConditions.visibilityOf(validation)).isDisplayed();
    }

}

