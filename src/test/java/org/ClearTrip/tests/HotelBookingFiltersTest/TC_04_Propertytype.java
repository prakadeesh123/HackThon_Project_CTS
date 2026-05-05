package org.ClearTrip.tests.HotelBookingFiltersTest;

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.HotelBookingFilters.Propertytype;
import org.ClearTrip.com.pages.HotelBookingFunctsPrices.FilterHotelsInNiarobia;
import org.testng.annotations.Test;

public class TC_04_Propertytype extends BaseClass {
    @Test
    public void propertyfilter(){
        FilterHotelsInNiarobia fh=new FilterHotelsInNiarobia(driver);
        fh.filterHotel();

        Propertytype pf=new Propertytype(driver);
        pf.applyproperties();
    }
}
