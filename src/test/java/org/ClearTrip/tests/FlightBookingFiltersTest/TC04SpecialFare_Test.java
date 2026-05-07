package org.ClearTrip.tests.FlightBookingFiltersTest;

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.FlightBookingFilters.Page_02_TravellersCount;
import org.ClearTrip.com.pages.FlightBookingFilters.Page_01_EmptyDestination;
import org.ClearTrip.com.pages.FlightBookingFilters.Page_03_FilterOnArrivalTime;
import org.ClearTrip.com.pages.FlightBookingFilters.Page_04_Specialfare;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC04SpecialFare_Test extends BaseClass {

    @Test
    public void specialfare()
    {
        Page_01_EmptyDestination p0 = new Page_01_EmptyDestination(driver);
        Page_02_TravellersCount p1 = new Page_02_TravellersCount(driver);
        Page_03_FilterOnArrivalTime p2 = new Page_03_FilterOnArrivalTime(driver);
        Page_04_Specialfare p3 = new Page_04_Specialfare(driver);

        p0.closePopUp();
        p2.setBusiness_class();
        p1.enter_tripdetails("Chennai","Pune");
        p0.click_search_btn();
        p3.specialfare();
        p3.setInside_search_btn();
        p3.no_result();
        String actualMsg = p3.getNoResultMessage();
        String expectedMsg = "No flights found for MAA → PNQ";

        Assert.assertEquals(actualMsg, expectedMsg,
                "Special fare filter did not show the expected no-results message!");
    }
}
