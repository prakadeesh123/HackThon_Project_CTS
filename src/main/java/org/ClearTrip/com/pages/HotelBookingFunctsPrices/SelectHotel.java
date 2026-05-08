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
import java.util.Set;

public class SelectHotel {

    protected WebDriver driver;
    protected WebDriverWait wait;

    private static final Logger logger = LogManager.getLogger(SelectHotel.class);
    private String expectedHotelName;
    private String expectedHotelPrice;
    private String actualHotelName;
    private String actualHotelPrice;

    public SelectHotel(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        logger.info("SelectHotel page initialized");
    }

    @FindBy(xpath = "(//div[@class='sc-aXZVg gvuMKO c-pointer p-relative'])[1]")
    private WebElement firstHotel;

    @FindBy(xpath = "(//span[@class='sc-fqkvVR hDWMSz'])[1]")
    private WebElement firstEleNameText;

    @FindBy(xpath = "(//p[@class='sc-fqkvVR hTAEcN'])[1]")
    private WebElement firstElePriceText;

    @FindBy(xpath = "//h1[@class='sc-fqkvVR jXNGCQ']")
    private WebElement openedHotelNameText;

    @FindBy(xpath = "//h2[@class='sc-fqkvVR hFFAkE mr-1']")
    private WebElement openedHotelPriceText;

    public void clickHotel() {
        try {
            logger.info("Attempting to select first hotel");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 30)");

            expectedHotelName = wait.until(ExpectedConditions.visibilityOf(firstEleNameText)).getText();
            expectedHotelPrice = wait.until(ExpectedConditions.visibilityOf(firstElePriceText)).getText();

            logger.info("Expected Hotel Name: {}", expectedHotelName);
            logger.info("Expected Hotel Price: {}", expectedHotelPrice);

            String parentWindow = driver.getWindowHandle();
            wait.until(ExpectedConditions.elementToBeClickable(firstHotel)).click();
            logger.info("Hotel clicked, waiting for new window");

            Set<String> allWindows = driver.getWindowHandles();
            for (String handle : allWindows) {
                if (!handle.equals(parentWindow)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }
            logger.info("Switched to hotel details page: {}", driver.getTitle());

            actualHotelName = wait.until(ExpectedConditions.visibilityOf(openedHotelNameText)).getText();
            actualHotelPrice = wait.until(ExpectedConditions.visibilityOf(openedHotelPriceText)).getText();

            logger.info("Actual Hotel Name: {}", actualHotelName);
            logger.info("Actual Hotel Price: {}", actualHotelPrice);

        } catch (Exception e) {
            logger.error("Failed to click hotel or switch window", e);
        }
    }

    public boolean validateOpenedHotel() {

        logger.info("Validating opened hotel details");
        try {
            boolean nameMatch = expectedHotelName.equals(actualHotelName);
            boolean priceMatch = expectedHotelPrice.equals(actualHotelPrice);

            logger.info("Hotel name match: {}", nameMatch);
            logger.info("Hotel price match: {}", priceMatch);

            if (nameMatch && priceMatch) {
                logger.info("Hotel validation PASSED");
                return true;
            } else {
                logger.error("Hotel validation FAILED");
                return false;
            }

        } catch (Exception e) {
            logger.error("Exception during hotel validation", e);
            return false;
        }
    }
}