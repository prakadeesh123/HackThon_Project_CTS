package org.MakeMyTrip.com.pages.Yaswanth;

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

    // --- Locators from CommonMethods ---
    @FindBy(css = "span.commonModal__close")
    private WebElement closeButton;

    @FindBy(xpath = "(//span[@class='headerIconTextAlignment chNavText darkGreyText'])[2]")
    private WebElement hotelButton;

    @FindBy(css = "button#hsw_search_button")
    private WebElement clickSearchbtn;

    @FindBy(xpath = "//span[text()='City, Property name or Location']")
    private WebElement selectCity;

    @FindBy(xpath = "//div[@class='hw__searchInputWrapper']/child::input")
    private WebElement cityInput;

    @FindBy(xpath = "//div[text()='City in Kenya']")
    private WebElement selectNairobi;

    // --- Locators from Page_01_SearchHotels ---
    @FindBy(xpath = "//span[text()='City, Property name or Location']")
    private WebElement locationLabel;

    @FindBy(xpath = "//label[@for='city']/child::span")
    private WebElement validateHotelpage;

    // Constructor
    public SearchHotel(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public void openHotelSection() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();
            wait.until(ExpectedConditions.elementToBeClickable(hotelButton)).click();
        } catch (Exception e) {
            System.out.println("SearchHotel: Navigation or modal closure failed: " + e.getMessage());
        }
    }
    public boolean ValidateopenHotelSelection(){
        try{
            return wait.until(ExpectedConditions.visibilityOf(validateHotelpage)).isDisplayed();

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
    public void enterLocationAndSearch() {
        try {
            wait.until(ExpectedConditions.visibilityOf(selectCity)).click();
            wait.until(ExpectedConditions.visibilityOf(cityInput)).sendKeys("Nairobi in Kenya");
            wait.until(ExpectedConditions.visibilityOf(selectNairobi)).click();
            // wait.until(ExpectedConditions.elementToBeClickable(clickSearchbtn)).click();
        } catch (Exception e) {
            System.out.println("SearchHotel: Input sequence failed: " + e.getMessage());
        }
    }
    public void executeSearch() {
        openHotelSection();
        enterLocationAndSearch();
    }

    public boolean validateHotelPage() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(locationLabel)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}