package org.MakeMyTripTest.com.Koushik;

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.Koushik.Page_02_TravellersCount;
import org.ClearTrip.com.pages.Koushik.Page_01_EmptyDestination;
import org.ClearTrip.com.pages.Koushik.Page_03_FilterOnArrivalTime;
import org.ClearTrip.com.pages.Koushik.Page_04_Specialfare;
import org.testng.annotations.Test;

public class TC04SpecialFare_Test extends BaseClass {

    @Test
    public void specialfare()
    {
        Page_01_EmptyDestination p0 = new Page_01_EmptyDestination(driver);
        Page_02_TravellersCount p1 = new Page_02_TravellersCount(driver);
        Page_03_FilterOnArrivalTime p2 = new Page_03_FilterOnArrivalTime(driver);
        Page_04_Specialfare p3 = new Page_04_Specialfare(driver);

        p0.closePopUp();
        p2.setBusiness_class();
        p1.enter_tripdetails("chennai","pune");
        p0.click_search_btn();
        p3.specialfare();
        p3.setInside_search_btn();
        String err_msg = p3.no_result();
        System.out.print("The Result is: "+ err_msg);

    }
}
