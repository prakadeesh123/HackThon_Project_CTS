package org.MakeMyTripTest.com.Prakadeesh;

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.Prakadeesh.Page_01_FlightValidation;
import org.ClearTrip.com.pages.Prakadeesh.Page_03_FlightSearch;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03_FlightSearchTest extends BaseClass {

    @Test
    public void FlightValidation() throws InterruptedException {

        Page_01_FlightValidation p1 = new Page_01_FlightValidation(driver);

        p1.closePopUp();
        p1.PopUp();


        Page_03_FlightSearch p3 = new Page_03_FlightSearch(driver);

        p3.RoundTrip();

        Assert.assertTrue(
                p3.isIconDisplayed(),
                "Icon button is NOT visible on the page"
        );

    }
}
