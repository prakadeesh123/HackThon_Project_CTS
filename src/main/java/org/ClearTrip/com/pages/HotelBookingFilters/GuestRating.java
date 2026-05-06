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


public class GuestRating {

    public WebDriver driver;
    public WebDriverWait wait;

    public static final Logger log= LoggerFactory.getLogger(GuestRating.class);

    @FindBy(xpath = "//p[text()='Guest ratings']")
    private WebElement guestrating;

    @FindBy(xpath = "//p[text()='4.5 & above']")
    private WebElement highrating;

    @FindBy(xpath = "//div/h4[text()='Apply']")
    private WebElement applybtn;

    @FindBy(xpath = "//p[@class='sc-fqkvVR jJpeiQ']")
    private WebElement filterapplied;

    public GuestRating(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver , this);
        log.info("Guest Rating page is initialized");
    }

    public void GuestRating(){
        try {

            wait.until(ExpectedConditions.elementToBeClickable(guestrating)).click();
            log.info("Guest Rating dropdown opened");

            wait.until(ExpectedConditions.elementToBeClickable(highrating)).click();
            log.info("High Guest rating checkbox has selected");

            wait.until(ExpectedConditions.elementToBeClickable(applybtn)).click();
            log.info("High Guest rating filter is applied");

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Guest Rating is not applied");

        }
    }
    public boolean validaterating(){

        try{

            log.info("Validating the rating filter is applied or not");
            wait.until(ExpectedConditions.visibilityOf(filterapplied));

            boolean elementdisplayed=filterapplied.isDisplayed();
            log.info("Actual results matches expected result ");

            return elementdisplayed;

        }
        catch (Exception e) {

            e.printStackTrace();
            log.info("Actual result mismatched expected result");

            return false;

        }
    }
}
