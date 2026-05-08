package org.ClearTrip.tests.HotelBookingFunctsPricesTest;
import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.HotelBookingFunctsPrices.FilterHotelsInNiarobia;
import org.ClearTrip.com.pages.HotelBookingFunctsPrices.HotelListingPage;
import org.ClearTrip.com.utility.ExcelUtils;
import org.ClearTrip.com.utility.HotelData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class T6_HotelListingPageTest extends BaseClass {

    @Test
    public void validateExcelSheet() {

        FilterHotelsInNiarobia filterPage = new FilterHotelsInNiarobia(driver);
        filterPage.filterHotel();
        HotelListingPage page = new HotelListingPage(driver);
        page.storeHotelData();
        List<HotelData> data = ExcelUtils.readHotelData();
        Assert.assertTrue(!data.isEmpty(),
                "Excel is empty");
    }
}

