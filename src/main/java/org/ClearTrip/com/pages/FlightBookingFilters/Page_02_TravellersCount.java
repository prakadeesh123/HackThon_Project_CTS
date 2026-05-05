package org.ClearTrip.com.pages.FlightBookingFilters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Page_02_TravellersCount {
    private WebDriver driver;
    private WebDriverWait wait;

    public Page_02_TravellersCount(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[text()='Adults']/following::button[1]")
    private WebElement adult_minus;

    @FindBy(xpath = "//p[text()='Adults']/following::button[2]")
    private WebElement adult_plus;

    @FindBy(xpath = "//p[text()='Children']/following::button[1]")
    private WebElement child_minus;

    @FindBy(xpath = "//p[text()='Children']/following::button[2]")
    private WebElement child_plus;

    @FindBy(xpath = "//p[text()='Infants']/following::button[1]")
    private WebElement infant_minus;

    @FindBy(xpath = "//p[text()='Infants']/following::button[2]")
    private WebElement infant_plus;

    @FindBy(xpath = "//input[@placeholder='Where from?']")
    private WebElement departure_location;

    @FindBy(xpath = "//input[@placeholder='Where to?']")
    private WebElement arrival_location;

    @FindBy(xpath = "//input[@name='travellers']")
    private WebElement travellers;

    @FindBy(xpath = "//span[contains(text(),'Adult')]/following-sibling::span//*[local-name()='svg']")
    private WebElement travellers_dropdown;

//    @FindBy(xpath = "//p[contains(text(),'Chennai, IN - Chennai Airport (MAA)')]")
//    private WebElement chennai;
//
//    @FindBy(xpath = "//p[contains(text(),'Pune, IN - Lohegaon (PNQ)')]")
//    private WebElement pune;

    @FindBy(xpath = "//div[@data-testid='dateSelectOnward']")
    private WebElement date_onward;

    @FindBy(xpath = "//div[@data-testid='dateSelectReturn']")
    private WebElement date_return;



    public void increase_travellers_count(int adult, int child, int infant) {
        wait.until(ExpectedConditions.elementToBeClickable(travellers_dropdown)).click();
        for (int i = 0; i < adult; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(adult_plus)).click();
        }
        for (int i = 0; i < child; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(child_plus)).click();
        }
        for (int i = 0; i < infant; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(infant_plus)).click();
        }
    }

    public void enter_tripdetails(String departure, String arrival)
    {
        wait.until(ExpectedConditions.elementToBeClickable(departure_location)).click();
        departure_location.sendKeys(departure);
        // Select suggestion dynamically based on departure string
        WebElement departureOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p[contains(text(),'" + departure + "')]")
        ));
        departureOption.click();

        wait.until(ExpectedConditions.elementToBeClickable(arrival_location)).click();
        arrival_location.sendKeys(arrival);
        //wait.until(ExpectedConditions.elementToBeClickable(pune)).click();
        // Select suggestion dynamically based on arrival string
        WebElement arrivalOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p[contains(text(),'" + arrival + "')]")
        ));
        arrivalOption.click();
    }

    public void enter_onwarddate(String fmonth, String fdate, String fyear)
    {
        wait.until(ExpectedConditions.elementToBeClickable(date_onward)).click();
        WebElement onward_date = wait.until((ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@aria-label,'" +fmonth+" "+fdate+" "+fyear+"')]"))));
        onward_date.click();
    }

    public void enter_returndate(String tmonth, String tdate, String tyear)
    {
        wait.until(ExpectedConditions.elementToBeClickable(date_return)).click();
        WebElement return_date = wait.until((ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@aria-label,'" +tmonth+" "+tdate+" "+tyear+"')]"))));
        return_date.click();
    }

    public int actualtraveller()
    {
        String travellersValue = travellers.getAttribute("value");
        int actualcount = Integer.parseInt(travellersValue.split(" ")[0]);
        return actualcount;
    }
}