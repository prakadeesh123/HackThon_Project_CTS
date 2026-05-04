package org.ClearTrip.com.pages.HotelBookingFilters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PriceSlider {
    public WebDriver driver;
    public WebDriverWait wait;

    @FindBy(xpath = "//p[text()='All filters']")
    private WebElement filters;

    @FindBy(xpath = "//div[@class='slider-track slider-track-1']")
    private WebElement priceslider;

    @FindBy(xpath = "//div/button[@class='sc-kAyceB ZTUrw']")
    private WebElement applybtn;

    @FindBy(xpath = "//p[text()='₹0 - ₹20,000']")
    private WebElement sliderapplied;

    public PriceSlider(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        PageFactory.initElements(driver, this );
    }
    public void Adjustprice(){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(filters)).click();
            WebElement slider=wait.until(ExpectedConditions.elementToBeClickable(priceslider));
            Actions actions=new Actions(driver);
            actions.clickAndHold(slider)
                    .moveByOffset(0,60)
                    .release()
                    .perform();
            wait.until(ExpectedConditions.elementToBeClickable(applybtn)).click();
        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println(e.getMessage());
        }
    }
    public boolean validatepriceslider(){
        return wait.until(ExpectedConditions.visibilityOf(sliderapplied)).isDisplayed();

    }

}
