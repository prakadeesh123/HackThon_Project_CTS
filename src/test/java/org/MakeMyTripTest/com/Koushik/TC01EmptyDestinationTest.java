package org.MakeMyTripTest.com.Koushik;

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.Koushik.Page_02_CruisePage;
import org.ClearTrip.com.pages.Koushik.Page_01_EmptyDestination;
import org.testng.annotations.Test;

public class TC01EmptyDestinationTest extends BaseClass {

    @Test
    public void testCruiseFlow() {
        Page_01_EmptyDestination p0 = new Page_01_EmptyDestination(driver);
        Page_02_CruisePage p1 = new Page_02_CruisePage(driver);

        // Step 1: Close popup + print error msg
        p0.destination_error();

    }
}

