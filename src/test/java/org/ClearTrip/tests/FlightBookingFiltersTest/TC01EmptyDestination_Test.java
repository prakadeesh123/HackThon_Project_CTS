package org.ClearTrip.tests.FlightBookingFiltersTest;

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.FlightBookingFilters.Page_02_TravellersCount;
import org.ClearTrip.com.pages.FlightBookingFilters.Page_01_EmptyDestination;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01EmptyDestination_Test extends BaseClass {

    @Test
    public void testCruiseFlow() {
        Page_01_EmptyDestination p0 = new Page_01_EmptyDestination(driver);
        Page_02_TravellersCount p1 = new Page_02_TravellersCount(driver);

        String error_msg = p0.destination_error();
        // Assertion
        Assert.assertEquals(error_msg, "Enter departure and arrival airports / cities",
                "Error message did not match expected text!");

    }
}

