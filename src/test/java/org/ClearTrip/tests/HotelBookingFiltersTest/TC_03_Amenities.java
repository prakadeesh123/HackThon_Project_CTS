package org.ClearTrip.tests.HotelBookingFiltersTest;

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.HotelBookingFilters.Amenities;
import org.ClearTrip.com.pages.HotelBookingFunctsPrices.FilterHotelsInNiarobia;
import org.testng.annotations.Test;

public class TC_03_Amenities extends BaseClass {

    @Test
    public void Amenities(){

        FilterHotelsInNiarobia fh=new FilterHotelsInNiarobia(driver);
        fh.filterHotel();

        Amenities an=new Amenities(driver);
        an.Anemetiescheck();
    }
}
