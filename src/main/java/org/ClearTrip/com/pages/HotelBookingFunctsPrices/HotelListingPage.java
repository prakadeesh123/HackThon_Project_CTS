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

    //Locators
    @FindBy(css = "span.sc-fqkvVR.hDWMSz")
    private List<WebElement> hotelNames;

    @FindBy(css = "span.price")
    private List<WebElement> prices;

    @FindBy(xpath = "//div[@class='sc-aXZVg gvuMKO c-pointer p-relative']")
    private List<WebElement> hotelCards;

    @FindBy(css = "span.sc-fqkvVR.hDWMSz")
    private WebElement namee;

    @FindBy(xpath = "//p[@class='sc-fqkvVR hTAEcN']")
    private WebElement pricee;

    //Constructor
    public HotelListingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // StoreHotelData
    public void storeHotelData() {
        List<HotelData> hotelList = new ArrayList<>();
        for (WebElement card : hotelCards) {
            try {
                String name = namee.getText();
                String price = pricee.getText();
                hotelList.add(new HotelData(name, price));

            } catch (Exception e) {
                logger.info("Skipping one hotel card");
            }
        }
        System.out.println("Captured hotels: " + hotelList.size());
        if (hotelList.isEmpty()) {
            logger.info(" No data captured. Fix locators.");
            return;
        }
        ExcelUtils.writeHotelData(hotelList);
        logger.info("Data written to Excel");
    }
}