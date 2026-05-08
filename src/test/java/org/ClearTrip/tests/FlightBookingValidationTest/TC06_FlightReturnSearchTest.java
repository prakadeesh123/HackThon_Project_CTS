package org.ClearTrip.tests.FlightBookingValidationTest;

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.FlightBookingValidations.Page_01_FlightValidation;
import org.ClearTrip.com.pages.FlightBookingValidations.Page_03_FlightSearch;
import org.ClearTrip.com.pages.FlightBookingValidations.Page_06_FlightReturnSearch;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06_FlightReturnSearchTest extends BaseClass {
    @Test
    public void FlightValidation() throws InterruptedException {

        Page_01_FlightValidation p1 = new Page_01_FlightValidation(driver);
        p1.closePopUp();
        p1.PopUp();

        Page_06_FlightReturnSearch p6 = new Page_06_FlightReturnSearch(driver);
        p6.RoundTrip();
        Assert.assertTrue(
                p6.isIconDisplayed(),
                "Icon button is NOT visible on the page"
        );

    }
}
