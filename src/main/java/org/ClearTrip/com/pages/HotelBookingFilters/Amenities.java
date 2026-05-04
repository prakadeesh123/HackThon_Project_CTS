package org.ClearTrip.com.pages.HotelBookingFilters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Amenities {
    public WebDriver driver;
    public WebDriverWait wait;

    @FindBy(xpath = "//p[text()='All filters']")
    private WebElement filterbtn;

    @FindBy(xpath = "//p[text()='Airport shuttle service']")
    private WebElement airport;

    @FindBy(xpath = "//p[text()='Parking']")
    private WebElement parking;

    @FindBy(xpath = "//button[@class='sc-kAyceB ZTUrw']")
    private WebElement applybtn;

    public Amenities(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver , Duration.ofSeconds(10));
        PageFactory.initElements(driver , this);
    }
    public void Anemetiescheck(){
        wait.until(ExpectedConditions.elementToBeClickable(filterbtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(airport)).click();
        wait.until(ExpectedConditions.elementToBeClickable(parking)).click();
        wait.until(ExpectedConditions.elementToBeClickable(applybtn)).click();
    }
}
