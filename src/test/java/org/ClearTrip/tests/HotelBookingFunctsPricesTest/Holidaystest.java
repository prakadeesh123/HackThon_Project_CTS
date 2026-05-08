package org.ClearTrip.tests.HotelBookingFunctsPricesTest;

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.HotelBookingFunctsPrices.Holidays;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Holidaystest extends BaseClass {
    @Test
    public void holidaytest(){
        Holidays hs=new Holidays(driver);
        hs.closePopUpIfPresent();
        hs.clickHolidays();
        hs.clickAllDestinations();
        Assert.assertTrue(hs.valid(),"Destinations not displayed");
    }
}
