package org.ClearTrip.com.pages.HotelBookingFunctsPrices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StoreAndRetreiveDataFromExcel {
    private WebDriver driver;
    private WebDriverWait wait;
    public StoreAndRetreiveDataFromExcel(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);

    }
//    public


}
