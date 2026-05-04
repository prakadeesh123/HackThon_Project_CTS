package org.ClearTrip.com.Yaswanth;

<<<<<<<< HEAD:src/test/java/org/ClearTrip/com/Yaswanth/SelectHotelTest.java
package org.ClearTrip.com.Yaswanth;
========
package org.ClearTripTest.com.Yaswanth;
>>>>>>>> origin/master:src/test/java/org/ClearTripTest/com/Yaswanth/SelectHotelTest.java

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.Yaswanth.FilterHotelsInNiarobia;
import org.ClearTrip.com.pages.Yaswanth.SelectHotel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectHotelTest extends BaseClass {
    @Test
    public void validateSelectHotel(){
        SelectHotel sH = new SelectHotel(driver);
        FilterHotelsInNiarobia f = new FilterHotelsInNiarobia(driver);
        f.filterHotel();
        sH.clickHotel();
        Assert.assertTrue(sH.validateOpenedHotel(),"Validation Failed");
    }
}
