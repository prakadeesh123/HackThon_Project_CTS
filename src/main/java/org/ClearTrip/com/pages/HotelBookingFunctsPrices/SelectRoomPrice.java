package org.ClearTrip.com.pages.HotelBookingFunctsPrices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class SelectRoomPrice {
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

    // Fixed XPath: Added missing / for absolute or corrected to // for relative
    @FindBy(xpath = "(//h2[@class='sc-fqkvVR hFFAkE'])[6]")
    public WebElement totalPrice;

    public SelectRoomPrice(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    public void clickBookRoom(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(selectRoomType)).click();
            wait.until(ExpectedConditions.elementToBeClickable(roomTypeName)).click();

            String parentWindow = driver.getWindowHandle();
            wait.until(ExpectedConditions.elementToBeClickable(clickBookbtn)).click();

            Set<String> allWindows = driver.getWindowHandles();
            for (String handle : allWindows) {
                if (!handle.equals(parentWindow)) {
                    driver.switchTo().window(handle);
                    System.out.println("Switched to Child Window: " + driver.getTitle());
                }
            }
        } catch (Exception e) {
            System.err.println("Error during booking/switching: " + e.getMessage());
        }
    }
    private int parsePrice(WebElement element) {
        String text = wait.until(ExpectedConditions.visibilityOf(element)).getText();
        String cleaned = text.replaceAll("[^0-9]", "");
        return cleaned.isEmpty() ? 0 : Integer.parseInt(cleaned);
    }

    public boolean validatePrices(){
        try {
            int price1 = parsePrice(oneRoomOneNight);
            int price2 = parsePrice(HotelTaxes);
            int price3 = parsePrice(ConvenienceFee);

            int discount1 = parsePrice(discountPrices1);
            int discount2 = parsePrice(discountPrices2);

            int calculatedTotal = (price1 + price2 + price3) - (discount1 + discount2);
            int actualTotalCost = parsePrice(totalPrice);
            System.out.println("oneroomprice :"+price1);
            System.out.println("HotelTaxes :"+price2);
            System.out.println("ConvenFee :"+price3);
            System.out.println("Discout1 :"+discount1);
            System.out.println("disc2 :"+discount2);

            System.out.println("Calculated Total: " + calculatedTotal);
            System.out.println("Actual Total from UI: " + actualTotalCost);

            return calculatedTotal == actualTotalCost;

        } catch (Exception e) {
            System.err.println("Validation failed: " + e.getMessage());
            return false;
        }
    }
}
