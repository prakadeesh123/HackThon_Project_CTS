package org.ClearTrip.com.pages.HotelBookingFunctsPrices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SelectRoomPrice {

    private WebDriver driver;
    private WebDriverWait wait;

    private static final Logger logger = Logger.getLogger(SelectRoomPrice.class.getName());

    //Locators
    @FindBy(css = "p.sc-fqkvVR.jJpeiQ.flex.flex-row.flex-middle")
    private WebElement selectRoomType;

    @FindBy(xpath = "(//p[@class='sc-fqkvVR bwtGcK'])[5]")
    private WebElement roomTypeName;

    @FindBy(xpath = "(//button[@class='sc-kAyceB cWeWJs'])[1]")
    private WebElement clickBookbtn;

    @FindBy(xpath = "(//p[@class='sc-fqkvVR dmyhE maxContent'])[1]")
    public WebElement discountPrices1;

    @FindBy(xpath = "(//p[@class='sc-fqkvVR dmyhE maxContent'])[2]")
    public WebElement discountPrices2;

    @FindBy(xpath = "(//p[@class='sc-fqkvVR jJpeiQ maxContent'])[1]")
    public WebElement oneRoomOneNight;

    @FindBy(xpath = "(//p[@class='sc-fqkvVR jJpeiQ maxContent'])[2]")
    public WebElement HotelTaxes;

    @FindBy(xpath = "(//p[@class='sc-fqkvVR jJpeiQ maxContent'])[3]")
    public WebElement ConvenienceFee;

    @FindBy(xpath = "(//h2[@class='sc-fqkvVR hFFAkE'])[6]")
    public WebElement totalPrice;

    //Constructor
    public SelectRoomPrice(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    //Clicking the Book room Button
    public void clickBookRoom() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(selectRoomType)).click();
            logger.info("Clicked on Select Room Type");
            wait.until(ExpectedConditions.elementToBeClickable(roomTypeName)).click();
            logger.info("Selected Room Type Name");
            String parentWindow = driver.getWindowHandle();
            wait.until(ExpectedConditions.elementToBeClickable(clickBookbtn)).click();
            logger.info("Clicked on Book Button");
            Set<String> allWindows = driver.getWindowHandles();
            for (String handle : allWindows) {
                if (!handle.equals(parentWindow)) {
                    driver.switchTo().window(handle);
                    logger.info("Switched to Child Window: " + driver.getTitle());
                }
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error during booking/switching", e);
        }
    }

    private int parsePrice(WebElement element) {
        String text = wait.until(ExpectedConditions.visibilityOf(element)).getText();
        String cleaned = text.replaceAll("[^0-9]", "");
        return cleaned.isEmpty() ? 0 : Integer.parseInt(cleaned);
    }

    public boolean validatePrices() {
        try {
            int price1 = parsePrice(oneRoomOneNight);
            int price2 = parsePrice(HotelTaxes);
            int price3 = parsePrice(ConvenienceFee);

            int discount1 = parsePrice(discountPrices1);
            int discount2 = parsePrice(discountPrices2);

            int calculatedTotal = (price1 + price2 + price3) - (discount1 + discount2);
            int actualTotalCost = parsePrice(totalPrice);

            logger.info("One Room Price: " + price1);
            logger.info("Hotel Taxes: " + price2);
            logger.info("Convenience Fee: " + price3);
            logger.info("Discount 1: " + discount1);
            logger.info("Discount 2: " + discount2);
            logger.info("Calculated Total: " + calculatedTotal);
            logger.info("Actual Total from UI: " + actualTotalCost);

            if (calculatedTotal == actualTotalCost) {
                logger.info("Price validation SUCCESS");
                return true;
            } else {
                logger.warning("Price validation FAILED");
                return false;
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Validation failed", e);
            return false;
        }
    }
}