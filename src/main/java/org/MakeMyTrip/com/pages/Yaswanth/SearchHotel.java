package org.MakeMyTrip.com.pages.Yaswanth;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SearchHotel {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(css = "i.close-icon.fi.fi-close")
    protected WebElement closePopup1;

    @FindBy(css = "div.oh-pwa__close")
    private WebElement closePopup2;

    @FindBy(css = "input#destinationInput")
    private WebElement selectDest;

    @FindBy(css = "div.xNA4LozTCRNX8kIscFcs")
    private WebElement selectNiarobia;

    @FindBy(css = "button.tripui-online-btn.tripui-online-btn-large.tripui-online-btn-solid-primary.tripui-online-btn-block.kDYEOBquYIGEsXVEHYOg")
    private WebElement searchBtn;


    // Constructor
    public SearchHotel(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public void clickHotel(){
        wait.until(ExpectedConditions.elementToBeClickable(closePopup1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(closePopup2)).click();
        wait.until(ExpectedConditions.visibilityOf(selectDest)).sendKeys("Nairobi");
        wait.until(ExpectedConditions.visibilityOf(selectNiarobia)).click();
        // Scroll down by 20px before clicking
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,20)");

        wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();

    }
    public void ValidateClick(){

    }


}