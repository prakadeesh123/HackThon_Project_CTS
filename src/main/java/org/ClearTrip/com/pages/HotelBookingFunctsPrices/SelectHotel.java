package org.ClearTrip.com.pages.HotelBookingFunctsPrices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Set;

public class SelectHotel {

    private static final Logger log =
            LoggerFactory.getLogger(SelectHotel.class);

    protected WebDriver driver;
    protected WebDriverWait wait;

    private String expectedHotelName;
    private String expectedHotelPrice;

    String actualHotelName;
    String actualHotelPrice;

    public SelectHotel(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        log.info("SelectHotel page initialized");
    }

    @FindBy(xpath = "(//div[@class='sc-aXZVg gvuMKO c-pointer p-relative'])[1]")
    private WebElement firstHotel;

    @FindBy(xpath = "//span[contains(text(),'Hob House')]")
    private WebElement firstEleNameText;

    @FindBy(xpath = "//p[contains(text(),'₹7,907')]")
    private WebElement firstElePriceText;

    @FindBy(xpath = "//h1[contains(text(),'Hob House')]")
    private WebElement openedHotelNameText;

    @FindBy(xpath = "//h2[contains(text(),'₹7,907')]']")
    private WebElement openedHotelPriceText;

    public SelectHotel() {
        expectedHotelName = firstEleNameText.getText();
        expectedHotelPrice = firstElePriceText.getText();
        actualHotelName = openedHotelNameText.getText();
        actualHotelPrice = openedHotelPriceText.getText();

        log.info("Expected hotel name: {}", expectedHotelName);
        log.info("Expected hotel price: {}", expectedHotelPrice);
        log.info("Actual hotel name: {}", actualHotelName);
        log.info("Actual hotel price: {}", actualHotelPrice);
    }

    public void clickHotel() {
        try {
            log.info("Attempting to click first listed hotel");

            String parentWindow = driver.getWindowHandle();
            wait.until(ExpectedConditions.elementToBeClickable(firstHotel)).click();
            log.info("First hotel clicked");

            Set<String> allWindows = driver.getWindowHandles();
            for (String handle : allWindows) {
                if (!handle.equals(parentWindow)) {
                    driver.switchTo().window(handle);
                    log.info("Switched to hotel details window");
                    break;
                }
            }

            System.out.println("Switched focus to: " + driver.getTitle());
            log.info("Current window title: {}", driver.getTitle());

        } catch (Exception e) {
            System.err.println("Failed to click hotel or switch window: " + e.getMessage());
            log.error("Failed to click hotel or switch window", e);
        }
    }

    public boolean validateOpenedHotel() {
        try {
            log.info("Validating opened hotel details");

            boolean a = expectedHotelName == actualHotelName ? true : false;
            boolean b = expectedHotelPrice == actualHotelPrice ? true : false;

            log.info("Hotel name validation result: {}", a);
            log.info("Hotel price validation result: {}", b);

            if (a == b) {
                log.info("Hotel validation PASSED");
                return true;
            }

            log.info("Hotel validation FAILED");
            return false;

        } catch (Exception e) {
            System.err.println("Validation failed: " + e.getMessage());
            log.error("Validation failed due to exception", e);
            return false;
        }
    }
}
