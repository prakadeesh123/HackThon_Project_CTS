package org.ClearTrip.com.Yaswanth;

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.Yaswanth.CheckAmenities;
import org.ClearTrip.com.pages.Yaswanth.FilterHotelsInNiarobia;
import org.ClearTrip.com.pages.Yaswanth.SelectHotel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckAmenitiesTest extends BaseClass {

    @Test
    public void validateAmenities(){
        FilterHotelsInNiarobia f = new FilterHotelsInNiarobia(driver);
        SelectHotel s = new SelectHotel(driver);
        CheckAmenities c = new CheckAmenities(driver);
        f.filterHotel();
        s.clickHotel();
        Assert.assertTrue(c.validateAmenities(),"validation failed");


    }
}
