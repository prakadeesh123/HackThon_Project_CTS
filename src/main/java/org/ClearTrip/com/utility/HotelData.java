package org.ClearTrip.com.utility;

public class HotelData {
    private String name;
    private String price;
    public HotelData(String name, String price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public String getPrice() {
        return price;
    }
}