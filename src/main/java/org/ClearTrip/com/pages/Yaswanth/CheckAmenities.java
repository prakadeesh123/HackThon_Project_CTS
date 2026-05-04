package org.ClearTrip.com.pages.Yaswanth;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.WatchEvent;
import java.time.Duration;

public class CheckAmenities {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//p[contains(text(),'Terrace')]")
    private WebElement terrece;

    @FindBy(xpath = "//p[contains(text(),'Library')]")
    private WebElement library;
    public CheckAmenities(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    public boolean validateAmenities(){
        boolean a = wait.until(ExpectedConditions.visibilityOf(terrece)).isDisplayed();
        boolean b = wait.until(ExpectedConditions.visibilityOf(library)).isDisplayed();
        if(a==true && b==true){
            return true;
        }
        return false;
    }
}
