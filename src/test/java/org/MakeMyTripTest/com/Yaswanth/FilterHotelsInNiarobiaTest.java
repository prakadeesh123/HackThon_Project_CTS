package org.MakeMyTripTest.com.Yaswanth;

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.Yaswanth.FilterHotelsInNiarobia;
import org.testng.annotations.Test;

public class FilterHotelsInNiarobiaTest extends BaseClass {
    @Test
    public void assertionPerform(){
        FilterHotelsInNiarobia fN = new FilterHotelsInNiarobia(driver);
        fN.clickHotel();
    }

}
