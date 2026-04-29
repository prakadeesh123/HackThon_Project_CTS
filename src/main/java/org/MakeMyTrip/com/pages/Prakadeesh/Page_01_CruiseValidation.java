package org.MakeMyTrip.com.pages.Prakadeesh;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page_01_CruiseValidation {

    WebDriver driver;
    WebDriverWait wait;

    public Page_01_CruiseValidation(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='commonModal__close']")
    private WebElement PopUp;

    @FindBy(xpath = "//li[@class='menu_Cruise']")
    private WebElement CruiseClick;

    @FindBy(xpath = "//h1[@class='desc' and contains(text(),'Book Domestic and International Cruises')]")
    private WebElement Text;

    @FindBy(xpath = "//button[@class='ctaCardCloseBtn']")
    private WebElement Pop;

    public void ClosePopUp(){
        wait.until(ExpectedConditions.elementToBeClickable(PopUp)).click();
    }

    public void ClickCruise(){
        wait.until(ExpectedConditions.elementToBeClickable(CruiseClick)).click();
    }

    public void ClickPop(){
        wait.until(ExpectedConditions.elementToBeClickable(Pop)).click();
    }

    public boolean CruiseText(){
        try{
            String str =  wait.until(ExpectedConditions.visibilityOf(Text)).getText();
            return str.equals("Book Domestic and International Cruises");

        }catch (Exception e){
            e.printStackTrace();
            return false;

        }
    }
}

