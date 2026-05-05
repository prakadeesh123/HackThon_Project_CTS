package org.ClearTrip.com.pages.HotelBookingFilters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class GuestRating {
    public WebDriver driver;
    public WebDriverWait wait;
    //    private static final Logger log = LogManager.getLogManager().getLogger(GuestRating.class);
    @FindBy(xpath = "//p[text()='Guest ratings']")
    private WebElement guestrating;
    @FindBy(xpath = "//p[text()='4.5 & above']")
    private WebElement highrating;
    @FindBy(xpath = "//div/h4[text()='Apply']")
    private WebElement applybtn;
    @FindBy(xpath = "//p[text()='4.5 & above']")
    private WebElement filterapplied;

    public GuestRating(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver , this);
    }
    public void GuestRating(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(guestrating)).click();
            wait.until(ExpectedConditions.elementToBeClickable(highrating)).click();
            wait.until(ExpectedConditions.elementToBeClickable(applybtn)).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean validaterating(){
        return wait.until(ExpectedConditions.visibilityOf(filterapplied)).isDisplayed();

    }
}
