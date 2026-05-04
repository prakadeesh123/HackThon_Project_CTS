package org.ClearTrip.com.pages.HotelBookingFilters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Propertytype {
    public WebDriver driver;
    public WebDriverWait wait;

    @FindBy(xpath = "//p[text()='All filters']")
    private WebElement filterbtn;

    @FindBy(xpath = "//p[text()='Hotel']")
    private WebElement Hotel;

    @FindBy(xpath="//p[text()='Apartment']")
    private WebElement Apartment;

    @FindBy(xpath = "//button[@class='sc-kAyceB ZTUrw']")
    private WebElement applybtn;

    public Propertytype(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }
    public void applyproperties(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(filterbtn)).click();
            wait.until(ExpectedConditions.elementToBeClickable(Hotel)).click();
            wait.until(ExpectedConditions.elementToBeClickable(Apartment)).click();
            wait.until(ExpectedConditions.elementToBeClickable(applybtn)).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
