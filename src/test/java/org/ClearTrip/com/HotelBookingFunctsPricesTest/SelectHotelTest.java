package org.ClearTrip.com.HotelBookingFunctsPricesTest;

import org.ClearTrip.com.baseclass.BaseClass;

import org.ClearTrip.com.pages.HotelBookingFunctsPrices.FilterHotelsInNiarobia;
import org.ClearTrip.com.pages.HotelBookingFunctsPrices.SelectHotel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectHotelTest extends BaseClass {
    @Test
    public void validateSelectHotel(){
        SelectHotel sH = new SelectHotel(driver);
        FilterHotelsInNiarobia f = new FilterHotelsInNiarobia(driver);
        f.filterHotel();
        sH.clickHotel();
        Assert.assertTrue(sH.validateOpenedHotel(),"Validation Failed");
    }
}
