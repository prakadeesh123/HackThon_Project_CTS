package org.MakeMyTripTest.com.Sagar;

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.Sagar.Ratingfilter;
import org.ClearTrip.com.pages.Yaswanth.FilterHotelsInNiarobia;
import org.ClearTrip.com.pages.Yaswanth.SelectHotel;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC_01_RatingFilter extends BaseClass {
    @Test
    public void testclass(){
        FilterHotelsInNiarobia fh=new FilterHotelsInNiarobia(driver);
        fh.filterHotel();
        Assert.assertTrue(fh.ValidateFilter(),"Hotel not selected for nairobi");
        Ratingfilter pg=new Ratingfilter(driver);
        pg.apply_filter();
        Assert.assertTrue(pg.validaterating(),"Filter not applied");
    }
}
