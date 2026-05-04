package org.ClearTrip.com.pages.Sagar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pricefilter {
    public WebDriver driver;
    public WebDriverWait wait;

    @FindBy(xpath = "//p[text()='Price']")
    private WebElement pricebtn;

    @FindBy
}
