package org.ClearTrip.tests.HotelBookingFiltersTest;



import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.HotelBookingFilters.StarCategory;
import org.ClearTrip.com.pages.HotelBookingFunctsPrices.FilterHotelsInNiarobia;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TC_01_StarCategory extends BaseClass {
    @Test
    public void testclass(){
        FilterHotelsInNiarobia fh=new FilterHotelsInNiarobia(driver);
        fh.filterHotel();
        Assert.assertTrue(fh.ValidateFilter(),"Hotel not selected for nairobi");
        StarCategory pg=new StarCategory(driver);
        pg.apply_filter();
        Assert.assertTrue(pg.validaterating(),"Filter not applied");
    }
}

