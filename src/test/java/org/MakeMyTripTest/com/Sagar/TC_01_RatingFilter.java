package org.MakeMyTripTest.com.Sagar;

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.Sagar.Ratingfilter;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC_01_RatingFilter extends BaseClass {
    @Test
    public void testclass(){
        Ratingfilter pg=new Ratingfilter(driver);
        pg.apply_filter();
        Assert.assertTrue(pg.validaterating(),"Filter not applied");
    }
}
