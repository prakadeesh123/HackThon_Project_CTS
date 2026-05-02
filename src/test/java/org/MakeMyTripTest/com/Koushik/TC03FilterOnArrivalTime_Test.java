package org.MakeMyTripTest.com.Koushik;

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.Koushik.Page_02_TravellersCount;
import org.ClearTrip.com.pages.Koushik.Page_01_EmptyDestination;
import org.ClearTrip.com.pages.Koushik.Page_03_FilterOnArrivalTime;
import org.testng.annotations.Test;

public class TC03FilterOnArrivalTime_Test extends BaseClass {

    @Test
    public void filerArrivalTime()
    {
        Page_01_EmptyDestination p0 = new Page_01_EmptyDestination(driver);
        Page_02_TravellersCount p1 = new Page_02_TravellersCount(driver);
        Page_03_FilterOnArrivalTime p2 = new Page_03_FilterOnArrivalTime(driver);

        p0.closePopUp();
        p2.setBusiness_class();
        p1.enter_tripdetails("Chennai","Pune");
        p0.click_search_btn();
        p2.filter_time();

    }

}
