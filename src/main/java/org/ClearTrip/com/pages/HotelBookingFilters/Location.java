package org.ClearTrip.com.pages.HotelBookingFilters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class Location {

    WebDriver driver;
    WebDriverWait wait;


    @FindBy(xpath = "//p[text()='All filters']")
    private WebElement filterbtn;

    @FindBy(xpath = "//p[text()='Lavington']")
    private WebElement location;

    @FindBy(xpath="//h4[text()='Show 80 hotels']")
    private WebElement applybtn;

    @FindBy(xpath = "//p[text()='Lavington']")
    private WebElement validation;

    public Location(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver , this);

    }

    public void locationfilter(){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(filterbtn)).click();

            wait.until(ExpectedConditions.visibilityOf(location)).click();

            wait.until(ExpectedConditions.elementToBeClickable(applybtn)).click();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public boolean validation(){
        try{
            wait.until(ExpectedConditions.visibilityOf(validation));
            boolean valid = validation.isDisplayed();
            return valid;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
