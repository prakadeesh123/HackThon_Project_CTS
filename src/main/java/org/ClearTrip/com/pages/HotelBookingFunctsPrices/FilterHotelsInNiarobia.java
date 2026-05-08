package org.ClearTrip.com.pages.HotelBookingFunctsPrices;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FilterHotelsInNiarobia {

    protected WebDriver driver;
    protected WebDriverWait wait;

    private static final Logger logger = LogManager.getLogger(FilterHotelsInNiarobia.class);

    //Locators
    @FindBy(xpath = "//div[@class='pb-1 px-1 flex flex-middle nmx-1']")
    private WebElement closePopUp;

    @FindBy(xpath = "//p[text()='Hotels']")
    private WebElement hotelBtn;

    @FindBy(xpath = "//div[@class='sc-aXZVg dhukqX']/input")
    private WebElement destination;

    @FindBy(xpath = "//div[@class='sc-eDPEul flPszU c-inherit place__name ']/p[text()='Nairobi County, Kenya']")
    private WebElement clickDestination;

    @FindBy(css = "p.sc-gEvEer.dtOwVR")
    private WebElement searchBtn;

    @FindBy(css = "span.sc-fqkvVR.bwtGcK")
    private WebElement validLocation;

    @FindBy(xpath = "//h1[text()='Showing hotels in Nairobi']")
    private WebElement validResult;

    @FindBy(css = "div.sc-aXZVg.gvuMKO.c-pointer.p-relative")
    private List<WebElement> listedOutput;

    // Constructor
    public FilterHotelsInNiarobia(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        logger.info("FilterHotelsInNiarobia page initialized");
    }

    public void filterHotel() {
        try{
            logger.info("Starting hotel filter for Nairobi");
            WebElement element = wait.until(ExpectedConditions.visibilityOf(closePopUp));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            element.click();
            logger.info("Popup closed");

            wait.until(ExpectedConditions.elementToBeClickable(hotelBtn)).click();
            logger.info("Hotels tab clicked");

            wait.until(ExpectedConditions.visibilityOf(destination)).sendKeys("Nairobi");
            logger.info("Entered destination: Nairobi");

            wait.until(ExpectedConditions.elementToBeClickable(clickDestination)).click();
            logger.info("Selected destination from dropdown");

            wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
            logger.info("Search button clicked");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    //Validating the filter
    public boolean ValidateFilter() {
        logger.info("Validating hotel filter results");
        boolean locationVisible =
                wait.until(ExpectedConditions.visibilityOf(validLocation)).isDisplayed();
        logger.info("Valid location displayed: {}", locationVisible);

        boolean resultHeaderVisible =
                wait.until(ExpectedConditions.visibilityOf(validResult)).isDisplayed();
        logger.info("Result header displayed: {}", resultHeaderVisible);

        boolean hotelsListed = listedOutput.size() > 0;
        logger.info("Hotels listed count: {}", listedOutput.size());

        if (locationVisible && resultHeaderVisible && hotelsListed) {
            logger.info("Hotel filter validation PASSED");
            return true;
        } else {
            logger.error("Hotel filter validation FAILED");
            return false;
        }
    }
}
