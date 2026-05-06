package org.ClearTrip.com.pages.HotelBookingFilters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class Propertytype {

    public WebDriver driver;
    public WebDriverWait wait;

    public static final Logger log= LoggerFactory.getLogger(Propertytype.class);

    @FindBy(xpath = "//p[text()='All filters']")
    private WebElement filterbtn;

    @FindBy(xpath = "//p[text()='Hotel']")
    private WebElement Hotel;

    @FindBy(xpath="//p[text()='Apartment']")
    private WebElement Apartment;

    @FindBy(xpath = "//button[@class='sc-kAyceB ZTUrw']")
    private WebElement applybtn;

    @FindBy(xpath = "//p[text()='Hotel']")
    private WebElement validation1;

    @FindBy(xpath = "//p[text()='Apartment']")
    private WebElement validation2;

    public Propertytype(WebDriver driver){

        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(25));
        PageFactory.initElements(driver,this);
        log.info("Property Type page is initialized");

    }

    public void applyproperties(){

        try {

            wait.until(ExpectedConditions.elementToBeClickable(filterbtn)).click();
            log.info("Filter button is selected");

            wait.until(ExpectedConditions.elementToBeClickable(Hotel)).click();
            log.info("Hotel checkbox is selected");

            wait.until(ExpectedConditions.elementToBeClickable(Apartment)).click();
            log.info("Apartment checkbox is selected");

            wait.until(ExpectedConditions.elementToBeClickable(applybtn)).click();
            log.info("All Filters are applied");

        }
        catch (Exception e) {

            e.printStackTrace();
            log.info("Filters not yet applied");
        }
    }
    public boolean validation(){

        try {

            wait.until(ExpectedConditions.visibilityOf(validation1));
            wait.until(ExpectedConditions.visibilityOf(validation2));

            boolean valid1 = validation1.isDisplayed();
            boolean valid2 = validation2.isDisplayed();

            log.info("Hotel property is filtered: " + valid1);
            log.info("Apartment property is filtered: " + valid2);

            return valid1 && valid2;

        }
        catch (Exception e) {

            e.printStackTrace();
            log.error("Actual result not yet met Expected result ");

            return false;
        }
    }
}
