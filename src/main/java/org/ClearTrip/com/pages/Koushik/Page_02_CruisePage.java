package org.ClearTrip.com.pages.Koushik;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Page_02_CruisePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Destination dropdown
    @FindBy(xpath = "//label[@class='lbl_input makeFlex column latoBold']")
    private WebElement destinationDropdown;

    @FindBy(xpath = "//input[@placeholder='Enter Destination']")
    private WebElement SearchBox;

    // Month dropdown
    @FindBy(xpath = "//label[@class='lbl_input latoBold makeFlex column']")
    private WebElement monthDropdown;

    @FindBy(xpath = "//div[contains(text(),'May')]")
    private WebElement mayOption;

    @FindBy(xpath = "//div[contains(text(),'June')]")
    private WebElement juneOption;

    // Apply button
    @FindBy(xpath = "//button[text()='Apply']")
    private WebElement applyButton;

    // Select button
    @FindBy(xpath = "//button[@id='search_button']")
    private WebElement selectButton;

    // Error message (appears when destination is empty)
    @FindBy(xpath = "//div[@class='error-message']")
    private WebElement destinationError;

    public Page_02_CruisePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void selectDestinationMumbai() {
        wait.until(ExpectedConditions.elementToBeClickable(destinationDropdown)).click();
        //wait.until(ExpectedConditions.elementToBeClickable(mumbaiOption)).click();
    }

    public void selectMonths() {
        wait.until(ExpectedConditions.elementToBeClickable(monthDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(mayOption)).click();
        wait.until(ExpectedConditions.elementToBeClickable(juneOption)).click();
        wait.until(ExpectedConditions.elementToBeClickable(applyButton)).click();
    }

//    public void clickSelectButton() {
//        wait.until(ExpectedConditions.elementToBeClickable(selectButton)).click();
//    }
public void ClickText(){
    wait.until(ExpectedConditions.elementToBeClickable(SearchBox)).sendKeys("Anchorage");
}

    public void clickSearchAndHandleError() {
        wait.until(ExpectedConditions.elementToBeClickable(selectButton)).click();

        try {
            // If error appears, print it
            String errorMsg = wait.until(ExpectedConditions.visibilityOf(destinationError)).getText();
            System.out.println("Error shown: " + errorMsg);
        } catch (Exception e) {
            // If no error, continue with normal flow
            System.out.println("No error, continuing with cruise booking...");
            // Example: proceed to select months or click Select
            // clickSelectButton();
        }
    }
}