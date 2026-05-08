package org.ClearTrip.tests.HotelBookingFiltersTest;

import org.ClearTrip.com.baseclass.BaseClass;

import org.ClearTrip.com.pages.HotelBookingFilters.Location;
import org.ClearTrip.com.pages.HotelBookingFunctsPrices.FilterHotelsInNiarobia;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_06_locationfilter extends BaseClass {

    @Test

    public void validtest(){

        FilterHotelsInNiarobia fs=new FilterHotelsInNiarobia(driver);
        Location lo=new Location(driver);
        fs.filterHotel();
        lo.locationfilter();
        Assert.assertTrue(
                lo.validation()
                ,"Filter not applied"
        );

    }
}
