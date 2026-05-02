package org.ClearTrip.com.pages.Prakadeesh;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page_01_FlightValidation {

    WebDriver driver;
    WebDriverWait wait;

    public Page_01_FlightValidation(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[local-name()='svg' and @data-testid='closeIcon']")
    private WebElement closePopUp;

    @FindBy(xpath = "//div[@class='closeit']")
    private WebElement PopUP;

    @FindBy(xpath = "//div[@class='sc-aXZVg jTYSrJ']")
    private WebElement Hotels;

    @FindBy(xpath = "//p[contains(text(),'Flights')]")
    private WebElement Flight;

    @FindBy(xpath = "//h3[contains(text(),'Wide Range of Airlines and Routes')]")
    private WebElement Scroll;

    @FindBy(xpath = "//h2[contains(text(),'Book Domestic and International Flight Tickets at Lowest Airfares on Cleartrip')]")
    private WebElement Text;

    public void closePopUp(){
        wait.until(ExpectedConditions.elementToBeClickable(closePopUp)).click();
    }
    public void PopUp(){
        wait.until(ExpectedConditions.elementToBeClickable(PopUP)).click();
    }
    public void ClickHotel(){
        wait.until(ExpectedConditions.elementToBeClickable(Hotels)).click();
    }
    public void Flight(){
        wait.until(ExpectedConditions.elementToBeClickable(Flight)).click();
    }

    public void slowScrollDown() {

        Actions actions = new Actions(driver);

        for (int i = 0; i < 3; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Boolean Text(){
        return wait.until(ExpectedConditions.visibilityOf(Text)).isDisplayed();
    }

}


