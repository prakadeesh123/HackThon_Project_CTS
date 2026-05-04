package org.ClearTrip.com.pages.HotelBookingFilters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Deals {
    public WebDriver driver;
    public WebDriverWait wait;


    @FindBy(xpath = "//div/span[text()='Jackpot deals']")
    private WebElement jackpotdeal;

    @FindBy(xpath = "//button[@class='sc-kAyceB ZTUrw']")
    private WebElement filterbtn;

    @FindBy(xpath = "//p[text()='Free cancellation']")
    private WebElement freecancel;

    @FindBy(xpath = "//button[@class='sc-kAyceB ZTUrw']")
    private WebElement applybtn;

    public Deals(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void deals(){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(jackpotdeal)).click();
            wait.until(ExpectedConditions.elementToBeClickable(filterbtn)).click();
            wait.until(ExpectedConditions.elementToBeClickable(freecancel)).click();
            wait.until(ExpectedConditions.elementToBeClickable(applybtn)).click();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
