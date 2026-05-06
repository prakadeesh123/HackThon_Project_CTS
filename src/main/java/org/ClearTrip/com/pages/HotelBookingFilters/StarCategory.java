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

public class StarCategory {

    public static final Logger log= LoggerFactory.getLogger(StarCategory.class);
    public WebDriver driver;
    public WebDriverWait wait;

    @FindBy(xpath="//div/p[text()='Star category']")
    private WebElement filtercategory;

    @FindBy(xpath="//div/p[text()='5-star']")
    private WebElement highrating;

    @FindBy(xpath="//div/h4[text()='Apply']")
    private WebElement applybtn;

    @FindBy(xpath = "//p[text()='5-star']")
    private WebElement filteradded;

    public StarCategory(WebDriver driver){

        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver , this);
        log.info("StarCategory page initialized");

    }
    public void apply_filter(){
        try {

            wait.until(ExpectedConditions.elementToBeClickable(filtercategory)).click();
            log.info("Filter dropdown Selected ");

            wait.until(ExpectedConditions.elementToBeClickable(highrating)).click();
            log.info("High rating is applied");

            wait.until(ExpectedConditions.elementToBeClickable(applybtn)).click();
            log.info("All filters are applied");

        }
        catch (Exception e) {

            e.printStackTrace();
            log.info("Filtes not yet applied");
            
        }
    }
    public boolean validaterating(){
        try {

            log.info("Validating the filters applied or not");
            wait.until(ExpectedConditions.visibilityOf(filteradded));

            boolean filter=filteradded.isDisplayed();
            log.info("Actual results matches with Expected result");

            return filter;

        }
        catch (Exception e){

            e.printStackTrace();
            log.info("Actual results mismatch with Expected result");

            return false;

        }
    }
}