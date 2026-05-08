package org.ClearTrip.tests.HotelBookingFiltersTest;

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.HotelBookingFilters.CheckAvailableAmenities;
import org.ClearTrip.com.pages.HotelBookingFunctsPrices.FilterHotelsInNiarobia;
import org.ClearTrip.com.pages.HotelBookingFunctsPrices.SelectHotel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_07_CheckAvailableAmenities extends BaseClass {

    @Test
    public void validateGamenities(){
        FilterHotelsInNiarobia f = new FilterHotelsInNiarobia(driver);
        SelectHotel s = new SelectHotel(driver);
        CheckAvailableAmenities ah = new CheckAvailableAmenities(driver);
        f.filterHotel();
        s.clickHotel();
        ah.clickSee();
        Assert.assertTrue(ah.validateAmenities(),"Validation failed");
    }
}
