package org.ClearTrip.tests.HotelBookingFunctsPricesTest;

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.HotelBookingFunctsPrices.FilterHotelsInNiarobia;
import org.ClearTrip.com.pages.HotelBookingFunctsPrices.SelectHotel;
import org.ClearTrip.com.pages.HotelBookingFunctsPrices.SelectRoomPrice;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T4_SelectRoomPriceTest extends BaseClass {

    @Test
    public void validateSelectRoomPrice(){
        FilterHotelsInNiarobia f = new FilterHotelsInNiarobia(driver);
        SelectHotel s = new SelectHotel(driver);
        SelectRoomPrice p = new SelectRoomPrice(driver);
        f.filterHotel();
        s.clickHotel();
        p.clickBookRoom();
        Assert.assertTrue(p.validatePrices(),"Validation failed");
    }
}

