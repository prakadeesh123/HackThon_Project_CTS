package org.ClearTrip.com.pages.HotelBookingFunctsPrices;

import org.ClearTrip.com.utility.ExcelUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HotelListingPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private static final Logger logger =
            LogManager.getLogger(HotelListingPage.class);

    @FindBy(css = "span.sc-fqkvVR.hDWMSz")
    private List<WebElement> hotelNameElements;

    public HotelListingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        logger.info("HotelListingPage initialized");
    }

    public void storeAndPrintHotelNamesFromExcel() {

        logger.info("Fetching hotel names from UI");

        wait.until(ExpectedConditions.visibilityOfAllElements(hotelNameElements));

        List<String> hotelNames = new ArrayList<>();

        for (WebElement hotel : hotelNameElements) {
            hotelNames.add(hotel.getText().trim());
        }

        // ✅ Write to Excel
        ExcelUtils.writeHotelNames(hotelNames);

        // ✅ Read back from Excel
        List<String> namesFromExcel = ExcelUtils.readHotelNames();

        // ✅ Print in console (explicit requirement)
        System.out.println("---- Hotel Names from Excel ----");
        for (String name : namesFromExcel) {
            System.out.println(name);
        }
    }
}