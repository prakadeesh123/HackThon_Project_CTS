package org.ClearTrip.tests.HotelBookingFiltersTest;


import org.ClearTrip.com.baseclass.BaseClass;

import org.ClearTrip.com.pages.HotelBookingFilters.GuestRating;
import org.ClearTrip.com.pages.HotelBookingFunctsPrices.FilterHotelsInNiarobia;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_02_GuestRating extends BaseClass {

    @Test
    public void testclass01(){

        FilterHotelsInNiarobia fh=new FilterHotelsInNiarobia(driver);
        fh.filterHotel();

        GuestRating gr=new GuestRating(driver);
        gr.GuestRating();

        Assert.assertTrue(
                gr.validaterating(),
                "Filter not applied");

    }
}
