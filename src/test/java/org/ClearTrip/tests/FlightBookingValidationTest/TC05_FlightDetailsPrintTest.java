package org.ClearTrip.tests.FlightBookingValidationTest;

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.FlightBookingValidations.Page_01_FlightValidation;
import org.ClearTrip.com.pages.FlightBookingValidations.Page_05_FlightDetailsPrint;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05_FlightDetailsPrintTest extends BaseClass {

    @Test
    public void FlightFilter() {
        Page_01_FlightValidation p1 = new Page_01_FlightValidation(driver);
        p1.closePopUp();
        p1.PopUp();

        Page_05_FlightDetailsPrint p5 = new Page_05_FlightDetailsPrint(driver);
        p5.FlightDetails();

    }

}
