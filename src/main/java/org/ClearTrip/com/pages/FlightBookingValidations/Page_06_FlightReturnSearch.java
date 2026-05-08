package org.ClearTrip.com.pages.FlightBookingValidations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class Page_06_FlightReturnSearch {

    WebDriver driver;
    WebDriverWait wait;

    public static final Logger log =
            LoggerFactory.getLogger(Page_06_FlightReturnSearch.class);

    public Page_06_FlightReturnSearch(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        log.info("Page_03_FlightSearch page initialized");
    }

    @FindBy(xpath = "//input[@placeholder='Where from?']")
    public WebElement Source;

    @FindBy(xpath = "//input[@placeholder='Where to?']")
    public WebElement Destination;

    @FindBy(xpath = "//div//h4[normalize-space()='Search flights']")
    public WebElement Button;

    @FindBy(xpath = "//p[contains(text(),'Round trip')]")
    private WebElement RoundTrip;

    @FindBy(xpath = "//span[normalize-space()='1 Adult, Economy']")
    private WebElement Filter;

    @FindBy(xpath = "(//*[name()='path' and @d='M16 9V23M9 16H23']/ancestor::button)[1]")
    private WebElement Adult;

    @FindBy(xpath = "(//*[name()='path' and @d='M16 9V23M9 16H23']/ancestor::button)[2]")
    private WebElement Children;

    @FindBy(xpath = "(//*[name()='path' and @d='M16 9V23M9 16H23']/ancestor::button)[3]")
    private WebElement Infant;

    @FindBy(xpath = "//p[contains(text(),'Chennai, IN - Chennai Airport (MAA)')]")
    private WebElement Chennai;

    @FindBy(xpath = "//p[contains(text(),'Mumbai, IN - Chatrapati Shivaji Airport (BOM)')]")
    private WebElement Mumbai;

    @FindBy(xpath = "//div[contains(@style,'cursor:pointer') and contains(@style,'border-radius:12px')]")
    private WebElement NonStop;

    @FindBy(xpath = "(//div[contains(@class,'c-pointer')])[1]")
    private WebElement Return;

    @FindBy(xpath = "//p[normalize-space()=\"Search\"]")
    private WebElement Search;


    @FindBy(xpath = "//*[name()='path' and contains(@d,'M16.115')]/ancestor::div[@cursor='pointer']")
    private WebElement iconButton;

    public void RoundTrip() {
        log.info("Selecting round trip flight options");

        wait.until(ExpectedConditions.elementToBeClickable(RoundTrip)).click();
        log.info("Round trip selected");

        wait.until(ExpectedConditions.elementToBeClickable(Filter)).click();
        log.info("Passenger filter opened");

        wait.until(ExpectedConditions.elementToBeClickable(Adult)).click();
        log.info("Adult count increased");

        wait.until(ExpectedConditions.elementToBeClickable(Children)).click();
        log.info("Children count increased");

        wait.until(ExpectedConditions.elementToBeClickable(Infant)).click();
        log.info("Infant count increased");

        wait.until(ExpectedConditions.elementToBeClickable(Source)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Chennai)).click();
        log.info("Source selected as Chennai");

        wait.until(ExpectedConditions.elementToBeClickable(Destination)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Mumbai)).click();
        log.info("Destination selected as Mumbai");

        wait.until(ExpectedConditions.elementToBeClickable(NonStop)).click();
        log.info("Non-stop filter applied");

        wait.until(ExpectedConditions.elementToBeClickable(Button)).click();
        log.info("Search flights button clicked");

        wait.until(ExpectedConditions.elementToBeClickable(Return)).click();
        log.info("Return flights button clicked");

        wait.until(ExpectedConditions.elementToBeClickable(Search)).click();
        log.info("Search flights button clicked");
    }

    public boolean isIconDisplayed() {
        try {
            boolean isDisplayed =
                    wait.until(ExpectedConditions.visibilityOf(iconButton)).isDisplayed();
            log.info("Flight search results icon displayed: {}", isDisplayed);
            return isDisplayed;
        } catch (Exception e) {
            log.error("Flight search results icon not displayed", e);
            return false;
        }
    }
}