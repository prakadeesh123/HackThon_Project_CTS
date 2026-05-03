package org.MakeMyTripTest.com.Prakadeesh;

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.Prakadeesh.Page_01_FlightValidation;
import org.ClearTrip.com.pages.Prakadeesh.Page_04_FlightFilter;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04_FlightFilterTest extends BaseClass {

    @Test
    public void FlightFilter(){
        Page_01_FlightValidation p1 = new Page_01_FlightValidation(driver);

        p1.closePopUp();
        p1.PopUp();

        Page_04_FlightFilter p4 = new Page_04_FlightFilter(driver);

        p4.applyFlightFilterAndContinue();

        Assert.assertTrue(
                p4.isItineraryPageDisplayed(),
                "Itinerary page is NOT displayed after clicking Continue"
        );

    }
}
