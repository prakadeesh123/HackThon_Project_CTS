package org.ClearTrip.com.Prakadeesh;


import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.Prakadeesh.Page_01_FlightValidation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_FlightValidationTest extends BaseClass {


    @Test
    public void FlightPageValidation() throws InterruptedException {

        Page_01_FlightValidation p1 = new Page_01_FlightValidation(driver);
        p1.closePopUp();
        p1.PopUp();
        p1.ClickHotel();
        p1.Flight();
        p1.slowScrollDown();

        Assert.assertTrue(
                p1.Text(),
                "Flight Page is not visible"
        );

    }
}
