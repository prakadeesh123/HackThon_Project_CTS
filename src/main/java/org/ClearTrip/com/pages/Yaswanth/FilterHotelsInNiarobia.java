package org.ClearTrip.com.pages.Yaswanth;

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

public class FilterHotelsInNiarobia {

    private static final Logger log =
            LoggerFactory.getLogger(FilterHotelsInNiarobia.class);

    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(xpath = "(//div[@data-testid='loginPopup']/div/div)[2]")
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
        log.info("FilterHotelsInNiarobia page initialized");
    }

    public void filterHotel() {

        log.info("Starting hotel filtering process for Nairobi");

        wait.until(ExpectedConditions.elementToBeClickable(closePopUp)).click();
        log.info("Login popup closed");

        wait.until(ExpectedConditions.elementToBeClickable(hotelBtn)).click();
        log.info("Hotels button clicked");

        wait.until(ExpectedConditions.visibilityOf(destination)).sendKeys("Nairobi");
        log.info("Entered destination: Nairobi");

        wait.until(ExpectedConditions.elementToBeClickable(clickDestination)).click();
        log.info("Selected destination from suggestion list");

        wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
        log.info("Search button clicked");
    }

    public boolean ValidateFilter() {

        log.info("Validating filter results");

        boolean a = wait.until(ExpectedConditions.visibilityOf(validLocation)).isDisplayed();
        log.info("Valid location displayed: {}", a);

        boolean b = wait.until(ExpectedConditions.visibilityOf(validResult)).isDisplayed();
        log.info("Valid result header displayed: {}", b);

        boolean c = listedOutput.size() > 0 ? true : false;
        log.info("Hotels listed count > 0: {}", c);

        if (a == true && b == true && c == true) {
            log.info("Hotel filter validation PASSED");
            return true;
        }

        log.info("Hotel filter validation FAILED");
        return false;
    }
}