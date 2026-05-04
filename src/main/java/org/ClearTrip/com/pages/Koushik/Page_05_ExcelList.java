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

    //New Delhi, IN - Indira Gandhi Airport (DEL)

    @FindBy(xpath = "//p[contains(text(),'New Delhi, IN - Indira Gandhi Airport (DEL)')]")
    private WebElement delhi;

    public void setNonstop_toggle()
    {
        wait.until(ExpectedConditions.elementToBeClickable(nonstop_toggle)).click();
    }

}
