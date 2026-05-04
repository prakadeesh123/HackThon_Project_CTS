package org.ClearTrip.com.Yaswanth;

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.Yaswanth.FilterHotelsInNiarobia;
import org.ClearTrip.com.pages.Yaswanth.PassengerDetailsContinuePay;
import org.ClearTrip.com.pages.Yaswanth.SelectHotel;
import org.ClearTrip.com.pages.Yaswanth.SelectRoomPrice;
import org.testng.annotations.Test;

public class PassengerDetailsContinuePayTest extends BaseClass {
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

    }


}
