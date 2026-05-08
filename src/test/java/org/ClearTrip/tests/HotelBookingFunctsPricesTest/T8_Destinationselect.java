package org.ClearTrip.tests.HotelBookingFunctsPricesTest;


import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.HotelBookingFunctsPrices.Destinationselect;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T8_Destinationselect extends BaseClass {
    @Test
    public void destinationcheck(){
        Destinationselect ds=new Destinationselect(driver);
        ds.closePopUpIfPresent();
        ds.clickHolidays();
        ds.clickAllDestinations();
        ds.clickEuropeDestination();
        ds.selectFiveStar();
        ds.clickEasternEuropeHotel();

        Assert.assertTrue(ds.valid(),"Hotel not clicked");
    }
}
