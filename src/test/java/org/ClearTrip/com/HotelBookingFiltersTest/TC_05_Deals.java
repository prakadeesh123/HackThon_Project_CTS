package org.ClearTrip.com.HotelBookingFiltersTest;

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.HotelBookingFilters.Deals;
import org.testng.annotations.Test;

public class TC_05_Deals extends BaseClass {
    @Test
    public void Dealfilter(){
        FilterHotelsInNiarobia fn=new FilterHotelsInNiarobia(driver);
        fn.filterHotel();

        Deals ds=new Deals(driver);
        ds.deals();
    }
}
