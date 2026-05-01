package org.ClearTrip.com.pages.Koushik;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Page_01_HomePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Close popup button
    @FindBy(css = "span.commonModal__close")
    private WebElement closeButton;

    // Cruise tab button (adjusted locator)
    @FindBy(xpath = "//span[text()='Cruise']")
    private WebElement cruiseButton;

    public Page_01_HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void openCruise() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();
            wait.until(ExpectedConditions.elementToBeClickable(cruiseButton)).click();
        } catch (Exception e) {
            System.out.println("CommonMethods: Could not click cruise buttons.");
        }
    }
}


