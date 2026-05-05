package org.ClearTrip.com.HotelBookingFunctsPricesTest;

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.HotelBookingFunctsPrices.FilterHotelsInNiarobia;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterHotelsInNiarobiaTest extends BaseClass {
    @Test
    public void assertionPerform(){
        FilterHotelsInNiarobia fN = new FilterHotelsInNiarobia(driver);
        fN.filterHotel();
        Assert.assertTrue(fN.ValidateFilter(),"Validation failed during automation task..!");
    }

}

