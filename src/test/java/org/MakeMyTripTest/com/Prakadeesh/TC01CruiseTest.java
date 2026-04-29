package org.MakeMyTripTest.com.Prakadeesh;


import org.MakeMyTrip.com.baseclass.BaseClass;
import org.MakeMyTrip.com.pages.Prakadeesh.Page_01_CruiseValidation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01CruiseTest extends BaseClass {


    @Test
    public void CruiseValidation() throws InterruptedException {

        Page_01_CruiseValidation p1 = new Page_01_CruiseValidation(driver);
        p1.ClosePopUp();
        //Thread.sleep(7000);
        p1.ClickCruise();
        //Thread.sleep(7000);
        p1.ClickPop();
        Thread.sleep(7000);
        Assert.assertTrue(p1.CruiseText(),
                "Cruise page heading is not displayed correctly!"
        );

    }
}
