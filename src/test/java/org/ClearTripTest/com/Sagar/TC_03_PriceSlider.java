package org.ClearTripTest.com.Sagar;

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.Sagar.GuestRating;
import org.ClearTrip.com.pages.Sagar.PriceSlider;
import org.ClearTrip.com.pages.Sagar.StarCategory;
import org.ClearTrip.com.pages.Yaswanth.FilterHotelsInNiarobia;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_03_PriceSlider extends BaseClass {
    @Test
    public void appliyslider(){

        FilterHotelsInNiarobia fh=new FilterHotelsInNiarobia(driver);
        fh.filterHotel();
//        Assert.assertTrue(fh.ValidateFilter(),"Hotel not selected for nairobi");

//        StarCategory sc=new StarCategory(driver);
//        sc.apply_filter();
//        Assert.assertTrue(sc.validaterating(),"Filter not applied");
//
//        GuestRating gr=new GuestRating(driver);
//        gr.GuestRating();
//        Assert.assertTrue(gr.validaterating(),"Filter not applied");

        PriceSlider ps=new PriceSlider(driver);
        ps.Adjustprice();
        Assert.assertTrue(ps.validatepriceslider(),"slider not applied");

    }
}
