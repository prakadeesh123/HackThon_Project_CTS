package org.ClearTrip.com.pages.FlightBookingValidations;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class Page_02_InvalidData {

    WebDriver driver;
    WebDriverWait wait;

    public static final Logger log =
            LoggerFactory.getLogger(Page_02_InvalidData.class);

    public Page_02_InvalidData(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        log.info("Page_02_InvalidData page initialized");
    }

    @FindBy(xpath = "//input[@placeholder='Where from?']")
    public WebElement Source;

    @FindBy(xpath = "//input[@placeholder='Where to?']")
    public WebElement Destination;

    @FindBy(xpath = "//div//h4[normalize-space()='Search flights']")
    public WebElement Button;

    @FindBy(xpath = "//span[contains(text(),'Enter departure and arrival airports / cities')]")
    private WebElement Text;

    public void Source() {
        log.info("Entering invalid source location");
        wait.until(ExpectedConditions.elementToBeClickable(Source))
                .sendKeys("Kerala");
    }

    public void Destination() {
        log.info("Entering invalid destination location");
        wait.until(ExpectedConditions.elementToBeClickable(Destination))
                .sendKeys("Chennai");
    }

    public void Button() {
        log.info("Clicking on Search flights button");
        wait.until(ExpectedConditions.elementToBeClickable(Button)).click();
    }

    public Boolean Text() {
        boolean isDisplayed =
                wait.until(ExpectedConditions.visibilityOf(Text)).isDisplayed();
        log.info("Invalid data validation message displayed: {}", isDisplayed);
        return isDisplayed;
    }
}

