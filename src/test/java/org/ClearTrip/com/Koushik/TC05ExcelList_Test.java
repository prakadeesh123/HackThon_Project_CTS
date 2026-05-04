<<<<<<<< HEAD:src/test/java/org/ClearTrip/com/Koushik/TC05ExcelList_Test.java
package org.ClearTrip.com.Koushik;
========
package org.ClearTripTest.com.Koushik;
>>>>>>>> origin/master:src/test/java/org/ClearTripTest/com/Koushik/TC05ExcelList_Test.java

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.Koushik.*;
import org.testng.annotations.Test;

public class TC05ExcelList_Test extends BaseClass {

    @Test
    public void excel_task()
    {
        Page_01_EmptyDestination p0 = new Page_01_EmptyDestination(driver);
        Page_02_TravellersCount p1 = new Page_02_TravellersCount(driver);
        Page_03_FilterOnArrivalTime p2 = new Page_03_FilterOnArrivalTime(driver);
        Page_04_Specialfare p3 = new Page_04_Specialfare(driver);
        Page_05_ExcelList p4 = new Page_05_ExcelList(driver);

        p0.closePopUp();
        p1.enter_tripdetails("Chennai","New Delhi");
        p1.enter_dates("May","23","2026","Jun","20","2026");
        p4.setNonstop_toggle();
        p0.click_search_btn();



    }
}
