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

public class Page_01_EmptyDestination {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Close popup button
    @FindBy(xpath = "//*[local-name()='svg' and @data-testid='closeIcon']")
    private WebElement closePopUp;

    // Search button
    @FindBy(xpath = "//h4[@class='sc-gEvEer AHmHT']")
    private WebElement search_btn;

    @FindBy(xpath= "//span[text()='Enter departure and arrival airports / cities']")
    private WebElement destination_error_msg;

    public Page_01_EmptyDestination(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }



    public void destination_error() {
        wait.until(ExpectedConditions.elementToBeClickable(closePopUp)).click();
        //wait.until(ExpectedConditions.elementToBeClickable(search_btn)).click();
        try {
            wait.until(ExpectedConditions.elementToBeClickable(search_btn)).click();
        } catch (ElementClickInterceptedException e) {
            // Fallback: force click with JS
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", search_btn);
        }
        try
        {
            // If error appears, print it
            String errorMsg = wait.until(ExpectedConditions.visibilityOf(destination_error_msg)).getText();
            System.out.println("Error shown: " + errorMsg);
        } catch (Exception e) {
            // If no error, continue with normal flow
            System.out.println("No error, continuing with cruise booking...");
        }
    }
}


