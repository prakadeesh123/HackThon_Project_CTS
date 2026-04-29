package org.MakeMyTripTest.com.Prakadeesh;

import org.MakeMyTrip.com.baseclass.BaseClass;
import org.MakeMyTrip.com.pages.Prakadeesh.Page_01_CruiseValidation;
import org.MakeMyTrip.com.pages.Prakadeesh.Page_02_InvalidData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02InvalidTest extends BaseClass {
    @Test
    public void CruiseValidation() throws InterruptedException {

        Page_02_InvalidData p1 = new Page_02_InvalidData(driver);
        p1.ClosePopUp();
        //Thread.sleep(7000);
        p1.ClickCruise();
        //Thread.sleep(7000);
        p1.ClickPop();
        Thread.sleep(7000);
        p1.SelectDestination();
        p1.ClickText();
        Assert.assertTrue(
                p1.PrintResult(),
                "Cruise heading is not visible"
        );
        System.out.println("NO Data Found");
    }
}
