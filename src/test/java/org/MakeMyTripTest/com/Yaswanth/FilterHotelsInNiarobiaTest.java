package org.MakeMyTripTest.com.Yaswanth;

import org.MakeMyTrip.com.baseclass.BaseClass;
import org.MakeMyTrip.com.pages.Yaswanth.FilterHotelsInNiarobia;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterHotelsInNiarobiaTest extends BaseClass {
    @Test
    public void assertionPerform(){
        FilterHotelsInNiarobia fN = new FilterHotelsInNiarobia(driver);
    }

}
