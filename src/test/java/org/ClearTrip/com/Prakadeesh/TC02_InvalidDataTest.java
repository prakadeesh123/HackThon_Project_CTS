<<<<<<<< HEAD:src/test/java/org/ClearTrip/com/Prakadeesh/TC02_InvalidDataTest.java
package org.ClearTrip.com.Prakadeesh;
========
package org.ClearTripTest.com.Prakadeesh;
>>>>>>>> origin/master:src/test/java/org/ClearTripTest/com/Prakadeesh/TC02_InvalidDataTest.java

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
        p2.Destination();
        p2.Button();
        Assert.assertTrue(
                p2.Text(),
                "Text Is Not Visible"
        );
    }
}
