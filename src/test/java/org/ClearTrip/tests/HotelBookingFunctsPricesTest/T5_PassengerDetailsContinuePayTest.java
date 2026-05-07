package org.ClearTrip.tests.HotelBookingFunctsPricesTest;

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.HotelBookingFunctsPrices.FilterHotelsInNiarobia;
import org.ClearTrip.com.pages.HotelBookingFunctsPrices.PassengerDetailsContinuePay;
import org.ClearTrip.com.pages.HotelBookingFunctsPrices.SelectHotel;
import org.ClearTrip.com.pages.HotelBookingFunctsPrices.SelectRoomPrice;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T5_PassengerDetailsContinuePayTest extends BaseClass {
    @Test
    public void validatePassengerDCP(){
        FilterHotelsInNiarobia f = new FilterHotelsInNiarobia(driver);
        SelectHotel s = new SelectHotel(driver);
        SelectRoomPrice sp = new SelectRoomPrice(driver);
        PassengerDetailsContinuePay pdc = new PassengerDetailsContinuePay(driver);
        f.filterHotel();
        s.clickHotel();
        sp.clickBookRoom();
        pdc.fillPassDetails();
        Assert.assertTrue(pdc.validatePaymentPage(),"validation failed");
    }
}
