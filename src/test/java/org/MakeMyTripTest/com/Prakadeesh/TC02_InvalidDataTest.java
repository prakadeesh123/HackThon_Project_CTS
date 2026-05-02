package org.MakeMyTripTest.com.Prakadeesh;

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.Prakadeesh.Page_01_FlightValidation;
import org.ClearTrip.com.pages.Prakadeesh.Page_02_InvalidData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02_InvalidDataTest extends BaseClass {
    @Test
    public void FlightValidation() throws InterruptedException {

        Page_01_FlightValidation p1 = new Page_01_FlightValidation(driver);

        p1.closePopUp();
        p1.PopUp();

        Page_02_InvalidData p2 = new Page_02_InvalidData(driver);

        p2.Source();
        //Thread.sleep(7000);
        p2.Destination();
        //Thread.sleep(7000);
        p2.Button();

        Assert.assertTrue(
                p2.Text(),
                "Text Is Not Visible"
        );
        System.out.println("NO Data Found");
    }
}
