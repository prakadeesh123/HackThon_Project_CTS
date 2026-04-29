package org.MakeMyTripTest.com.Yaswanth;

import jdk.jfr.Description;
import org.MakeMyTrip.com.baseclass.BaseClass;
import org.MakeMyTrip.com.pages.Yaswanth.SearchHotel;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.management.Descriptor;
import javax.swing.*;

public class SearchHotelTest extends BaseClass {
    @Test
    public void ValidateHotelPageClick(){
        SearchHotel sh = new SearchHotel(driver);
        sh.openHotelSection();
        Assert.assertTrue(sh.ValidateopenHotelSelection(),"Failed to open Hotel section....//\\\\///");
    }

}
