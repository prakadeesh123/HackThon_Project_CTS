package org.ClearTrip.com.pages.HotelBookingFunctsPrices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
public class HotelListingPage {

    private WebDriver driver;

    // UPDATE selector if needed based on actual site
    @FindBy(css = "span.sc-jrAGrp")
    private List<WebElement> hotelNameElements;

    public HotelListingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public List<String> getAllHotelNames() {

        List<String> hotelNames = new ArrayList<>();
        for (WebElement hotel : hotelNameElements) {
            String name = hotel.getText();
            hotelNames.add(name);

            // Print in terminal
            System.out.println("Hotel Name: " + name);
        }
        return hotelNames;
    }

}