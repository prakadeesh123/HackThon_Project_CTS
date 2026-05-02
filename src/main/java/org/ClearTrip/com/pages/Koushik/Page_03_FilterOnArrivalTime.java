package org.ClearTrip.com.pages.Koushik;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Page_03_FilterOnArrivalTime {

    private WebDriver driver;
    private WebDriverWait wait;

    public Page_03_FilterOnArrivalTime(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'Adult')]/following-sibling::span//*[local-name()='svg']")
    private WebElement travellers_dropdown;

    @FindBy(xpath = "//p[contains(text() , 'Business class')]")
    private WebElement business_class;

    @FindBy(xpath = "//p[normalize-space(text())='Landing in Pune']/following::input /following::p[normalize-space(text())='Evening']")
    private WebElement time_filter;

    public void filter_time()
    {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(time_filter)).click();
        } catch (ElementClickInterceptedException e) {
            // Fallback: force click with JS
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", time_filter);
        }
    }

    public void setBusiness_class()
    {
        wait.until(ExpectedConditions.elementToBeClickable(travellers_dropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(business_class)).click();
    }
}
