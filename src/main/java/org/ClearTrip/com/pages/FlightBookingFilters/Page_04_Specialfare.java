package org.ClearTrip.com.pages.FlightBookingFilters;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class Page_04_Specialfare {

    private WebDriver driver;
    private WebDriverWait wait;
    public static final Logger log = LoggerFactory.getLogger(Page_04_Specialfare.class);

    public Page_04_Specialfare(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[contains(text(),'Student')]")
    private WebElement student_opt;

    @FindBy(xpath = "//p[normalize-space(text())='Search']")
    private WebElement inside_search_btn;

    @FindBy(xpath = "//h1[contains(text() , 'No flights found for MAA → PNQ')]")
    private WebElement no_result;

    public void specialfare()
    {
        wait.until(ExpectedConditions.elementToBeClickable(student_opt)).click();
    }

    public void setInside_search_btn()
    {
        wait.until(ExpectedConditions.elementToBeClickable(inside_search_btn)).click();
    }

    public void no_result()
    {
        log.info("The Result is: "+ wait.until(ExpectedConditions.visibilityOf(no_result)).getText());
    }

    public String getNoResultMessage() {
        return wait.until(ExpectedConditions.visibilityOf(no_result)).getText();
    }
}
