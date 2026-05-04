package org.ClearTrip.com.Yaswanth;

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.Yaswanth.FilterHotelsInNiarobia;
import org.ClearTrip.com.pages.Yaswanth.SelectHotel;
import org.ClearTrip.com.pages.Yaswanth.SelectRoomPrice;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectRoomPriceTest extends BaseClass {

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
