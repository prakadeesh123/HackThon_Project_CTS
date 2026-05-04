package org.ClearTrip.com.pages.Yaswanth;

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

public class SelectRoomPrice {

    private static final Logger log =
            LoggerFactory.getLogger(SelectRoomPrice.class);

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "p.sc-fqkvVR.jJpeiQ.flex.flex-row.flex-middle")
    private WebElement selectRoomType;

    @FindBy(xpath = "//p[contains(text(),'Deluxe Twin Room, 2 Twin Beds, Non Smoking')]")
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

    public SelectRoomPrice(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
        log.info("SelectRoomPrice page initialized");
    }

    public void clickBookRoom(){
        try {
            log.info("Starting room selection and booking flow");

            wait.until(ExpectedConditions.elementToBeClickable(selectRoomType)).click();
            log.info("Room type section expanded");

            wait.until(ExpectedConditions.elementToBeClickable(roomTypeName)).click();
            log.info("Specific room type selected");

            String parentWindow = driver.getWindowHandle();
            wait.until(ExpectedConditions.elementToBeClickable(clickBookbtn)).click();
            log.info("Book button clicked");

            Set<String> allWindows = driver.getWindowHandles();
            for (String handle : allWindows) {
                if (!handle.equals(parentWindow)) {
                    driver.switchTo().window(handle);
                    System.out.println("Switched to Child Window: " + driver.getTitle());
                    log.info("Switched to child window: {}", driver.getTitle());
                }
            }
        } catch (Exception e) {
            System.err.println("Error during booking/switching: " + e.getMessage());
            log.error("Error during room booking or window switching", e);
        }
    }

    private int parsePrice(WebElement element) {
        String text = wait.until(ExpectedConditions.visibilityOf(element)).getText();
        log.info("Raw price text: {}", text);

        String cleaned = text.replaceAll("[^0-9]", "");
        int value = cleaned.isEmpty() ? 0 : Integer.parseInt(cleaned);

        log.info("Parsed price value: {}", value);
        return value;
    }

    public boolean validatePrices(){
        try {
            log.info("Validating room price calculation");

            int price1 = parsePrice(oneRoomOneNight);
            int price2 = parsePrice(HotelTaxes);
            int price3 = parsePrice(ConvenienceFee);

            int discount1 = parsePrice(discountPrices1);
            int discount2 = parsePrice(discountPrices2);

            int calculatedTotal =
                    (price1 + price2 + price3-1) - (discount1 + discount2);

            int actualTotalCost = parsePrice(totalPrice);


            System.out.println("Calculated Total: " + calculatedTotal);
            System.out.println("Actual Total from UI: " + actualTotalCost);

            log.info("One room price: {}", price1);
            log.info("Hotel taxes: {}", price2);
            log.info("Convenience fee: {}", price3);
            log.info("Discount 1: {}", discount1);
            log.info("Discount 2: {}", discount2);
            log.info("Calculated total: {}", calculatedTotal);
            log.info("Actual total from UI: {}", actualTotalCost);

            boolean result = calculatedTotal == actualTotalCost;
            log.info("Price validation result: {}", result);

            return result;

        } catch (Exception e) {
            System.err.println("Validation failed: " + e.getMessage());
            log.error("Price validation failed due to exception", e);
            return false;
        }
    }
}