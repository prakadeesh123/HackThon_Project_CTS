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

public class Holidays {
    WebDriver driver;
    WebDriverWait wait;
    public static final Logger log = LoggerFactory.getLogger(Holidays.class);

    @FindBy(xpath = "//*[local-name()='svg' and @data-testid='closeIcon']")
    private WebElement closePopUp;

    @FindBy(xpath = "//p[normalize-space()='Holidays']")
    private WebElement holidaysMenu;

    @FindBy(xpath = "//li[@id='menu-item-1239220']//a[normalize-space()='All Destinations']")
    private WebElement allDestinationsLink;

    @FindBy(xpath = "//h1[text()='Top Destinations']")
    private WebElement validation;

    public Holidays(WebDriver driver) {
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
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", holidaysMenu);
        }
        log.info("Clicked on Holidays menu");
    }

    public void clickAllDestinations() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(allDestinationsLink)).click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", allDestinationsLink);
        }
        log.info("Clicked on All Destinations");
    }

    public boolean valid(){
       return wait.until(ExpectedConditions.visibilityOf(validation)).isDisplayed();
    }

}

