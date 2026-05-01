package org.MakeMyTripTest.com.Sagar;

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.Sagar.GuestRating;
import org.ClearTrip.com.pages.Sagar.Ratingfilter;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_02_Guestrating extends BaseClass {
    @Test
    public void testclass01(){
        GuestRating gr=new GuestRating(driver);
        gr.GuestRating();
        Assert.assertTrue(gr.validaterating(),"Filter not applied");
        Ratingfilter pg=new Ratingfilter(driver);
        pg.apply_filter();
        Assert.assertTrue(pg.validaterating(),"Filter not applied");
    }


}
