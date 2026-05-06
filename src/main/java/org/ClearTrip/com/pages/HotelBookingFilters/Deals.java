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

public class Deals {

    public WebDriver driver;
    public WebDriverWait wait;
    public static final Logger log= LoggerFactory.getLogger(Deals.class);

    @FindBy(xpath = "//p[text()='Sort by: Recommended']")
    private WebElement filterbtn;

    @FindBy(xpath = "//p[text()='Price: Low to High']")
    private WebElement pricelowtohigh;

    @FindBy(xpath = "//button[@class='sc-kAyceB ZTUrw']")
    private WebElement applybtn;

    @FindBy(xpath = "//span[text()='Jackpot deals']")
    private WebElement jackpotdeal;

    @FindBy(xpath = "//p[text()='Sort by: Price: Low to High']")
    private WebElement validation;

    public Deals(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        log.info("Deals page is initialized");
    }

    public void deals(){
        try{

            wait.until(ExpectedConditions.elementToBeClickable(filterbtn)).click();
            log.info("Filter button is selected ");

            wait.until(ExpectedConditions.elementToBeClickable(pricelowtohigh)).click();
            log.info("Price low to high is selected");

            wait.until(ExpectedConditions.elementToBeClickable(applybtn)).click();
            log.info("All Filters applied successfully");

            wait.until(ExpectedConditions.elementToBeClickable(jackpotdeal)).click();
            log.info("Jackpot deal is selected");
        }
        catch(Exception e){
            e.printStackTrace();
            log.info("Filters not yet applied");
        }
    }
    public boolean validation() {

        try{
            log.info("Validating the Expected result");
            wait.until(ExpectedConditions.visibilityOf(validation));

            boolean elementdisplayed =validation.isDisplayed();
            log.info("Actual conditions met the expected conditions");

            return elementdisplayed;

        }
        catch (Exception e) {

            e.printStackTrace();
            log.error("Actual conditions not met the expected conditions");

            return false;
        }
    }

}
