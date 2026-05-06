package org.ClearTrip.tests.FlightBookingValidationTest;

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.FlightBookingValidations.Page_01_FlightValidation;
import org.ClearTrip.com.pages.FlightBookingValidations.Page_05_FlightDetailsPrint;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05_FlightDetailsPrintTest extends BaseClass {

    @Test
    public void FlightDetailsPrintTest() {

        Page_01_FlightValidation homePage =
                new Page_01_FlightValidation(driver);

        homePage.closePopUp();
        homePage.PopUp();

        Page_05_FlightDetailsPrint flightDetailsPage =
                new Page_05_FlightDetailsPrint(driver);

        int flightCount =
                flightDetailsPage.fetchAndSaveFlightDetails();

        Assert.assertTrue(
                flightCount > 0,
                "FAILED: No flight details were captured or written to Excel"
        );
    }
}