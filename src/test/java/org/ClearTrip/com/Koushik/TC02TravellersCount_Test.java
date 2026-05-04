<<<<<<<< HEAD:src/test/java/org/ClearTrip/com/Koushik/TC02TravellersCount_Test.java
package org.ClearTrip.com.Koushik;
========
package org.ClearTripTest.com.Koushik;
>>>>>>>> origin/master:src/test/java/org/ClearTripTest/com/Koushik/TC02TravellersCount_Test.java

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.Koushik.Page_02_TravellersCount;
import org.ClearTrip.com.pages.Koushik.Page_01_EmptyDestination;
import org.testng.annotations.Test;

public class TC02TravellersCount_Test extends BaseClass{

    @Test
    public void travellers_count(){
        Page_01_EmptyDestination p0 = new Page_01_EmptyDestination(driver);
        Page_02_TravellersCount p1 = new Page_02_TravellersCount(driver);

        p0.closePopUp();
        p1.increase_travellers_count(1,2,2);
        p1.enter_tripdetails("MAA","PNQ");
        p0.click_search_btn();

        int actual_count = p1.actualtraveller();
        int expected_count = 6;

        if (actual_count == expected_count) {
            System.out.println("Traveller count matches: " + actual_count);
        } else {
            System.out.println("Traveller count mismatch! Expected " + expected_count + " but found " + actual_count);
        }

    }

}
