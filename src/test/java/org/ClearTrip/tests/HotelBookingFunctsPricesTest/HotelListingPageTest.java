package org.ClearTrip.tests.HotelBookingFunctsPricesTest;

import org.ClearTrip.com.baseclass.BaseClass;
import org.ClearTrip.com.pages.HotelBookingFunctsPrices.FilterHotelsInNiarobia;
import org.ClearTrip.com.pages.HotelBookingFunctsPrices.HotelListingPage;
import org.ClearTrip.com.utility.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HotelListingPageTest extends BaseClass {

    @Test
    public void validateExcelSheet() {

        // Step 1: Filter hotels
        FilterHotelsInNiarobia filterPage =
                new FilterHotelsInNiarobia(driver);

        filterPage.filterHotel();

        // Step 2: Store hotel names in Excel
        HotelListingPage listingPage =
                new HotelListingPage(driver);

        listingPage.storeAndPrintHotelNamesFromExcel();

        // Step 3: Read data from Excel and validate
        List<String> hotelNamesFromExcel =
                ExcelUtils.readHotelNames();

        Assert.assertTrue(
                hotelNamesFromExcel.size() > 0,
                "Excel sheet is empty or hotel names not written correctly"
        );
    }
}