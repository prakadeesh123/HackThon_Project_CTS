package org.ClearTrip.com.pages.HotelBookingFunctsPrices;

import org.ClearTrip.com.utility.HotelData;
import org.ClearTrip.com.utility.ExcelUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HotelListingPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private static final Logger logger = LogManager.getLogger(HotelListingPage.class);

    @FindBy(css = "span.sc-fqkvVR.hDWMSz")
    private List<WebElement> hotelNames;

    @FindBy(css = "span.price")
    private List<WebElement> prices;

    public HotelListingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void storeHotelData() {

        By hotelCardLocator = By.xpath("//div[@class='sc-aXZVg gvuMKO c-pointer p-relative']");
        wait.until(ExpectedConditions.presenceOfElementLocated(hotelCardLocator));
        List<WebElement> hotelCards = driver.findElements(hotelCardLocator);
        List<HotelData> hotelList = new ArrayList<>();
        for (WebElement card : hotelCards) {

            try {
                String name = card.findElement(By.cssSelector("span.sc-fqkvVR.hDWMSz")).getText();
                String price = card.findElement(By.xpath("//p[@class='sc-fqkvVR hTAEcN']")).getText();
                hotelList.add(new HotelData(name, price));

            } catch (Exception e) {
                System.out.println("Skipping one hotel card");
            }
        }
        System.out.println("Captured hotels: " + hotelList.size());
        if (hotelList.isEmpty()) {
            System.out.println(" No data captured. Fix locators.");
            return;
        }
        ExcelUtils.writeHotelData(hotelList);
        System.out.println("Data written to Excel");
    }
}