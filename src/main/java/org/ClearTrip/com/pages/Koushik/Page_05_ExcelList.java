package org.ClearTrip.com.pages.Koushik;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Page_05_ExcelList {

    private WebDriver driver;
    private WebDriverWait wait;

    public Page_05_ExcelList(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[style*='width:32px'][style*='height:20px']")
    private WebElement nonstop_toggle;

    @FindBy(xpath = "//input[@type='checkbox']//following::p[normalize-space()='Air India'][1]")
    private WebElement airindia_checkbox;

    @FindBy(xpath = "//input[@type='checkbox']//following::p[normalize-space()='IndiGo'][1]")
    private WebElement indigo_checkbox;


    public void setNonstop_toggle()
    {
        wait.until(ExpectedConditions.elementToBeClickable(nonstop_toggle)).click();
    }

    public void airline_checkbox()
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", airindia_checkbox);
        wait.until(ExpectedConditions.elementToBeClickable(airindia_checkbox)).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", indigo_checkbox);
        wait.until(ExpectedConditions.elementToBeClickable(indigo_checkbox)).click();
    }

}
