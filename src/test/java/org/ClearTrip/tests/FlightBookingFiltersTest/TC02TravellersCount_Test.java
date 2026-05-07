package org.ClearTrip.tests.FlightBookingFiltersTest;

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.FlightBookingFilters.Page_02_TravellersCount;
import org.ClearTrip.com.pages.FlightBookingFilters.Page_01_EmptyDestination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC02TravellersCount_Test extends BaseClass{

    @Test
    public void travellers_count(){

        final Logger log = LoggerFactory.getLogger(Page_01_EmptyDestination.class);

        Page_01_EmptyDestination p0 = new Page_01_EmptyDestination(driver);
        Page_02_TravellersCount p1 = new Page_02_TravellersCount(driver);

        p0.closePopUp();
        p1.increase_travellers_count(1,2,2);
        p1.enter_tripdetails("Chennai","Pune");
        p0.click_search_btn();
        int actual_count = p1.actualtraveller();
        int expected_count = 6;
        if (actual_count == expected_count) {
            log.info("Traveller count matches: " + actual_count);
        } else {
            log.info("Traveller count mismatch! Expected " + expected_count + " but found " + actual_count);
        }

        // Assertion
        Assert.assertEquals(actual_count, expected_count,
                "Traveller count mismatch! Expected " + expected_count + " but found " + actual_count);
    }

}
