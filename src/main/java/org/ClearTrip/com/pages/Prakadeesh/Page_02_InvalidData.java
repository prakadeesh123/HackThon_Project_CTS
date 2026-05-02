package org.ClearTrip.com.pages.Prakadeesh;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page_02_InvalidData {

    WebDriver driver;
    WebDriverWait wait;

    public Page_02_InvalidData(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Where from?']")
    private WebElement Source;

    @FindBy(xpath = "//input[@placeholder='Where to?']")
    private WebElement Destination;

    @FindBy(xpath = "(//div[@class='sc-aXZVg ibgoAF'])[2]")
    private WebElement Button;

    @FindBy(xpath = "//span[contains(text(),'Enter departure and arrival airports / cities')]")
    private WebElement Text;

    public void Source(){
        wait.until(ExpectedConditions.elementToBeClickable(Source)).sendKeys("Kerala");
    }
    public void Destination(){
        wait.until(ExpectedConditions.elementToBeClickable(Destination)).sendKeys("Chennai");
    }
    public void Button(){
        wait.until(ExpectedConditions.elementToBeClickable(Button)).click();
    }
    public Boolean Text(){
        return wait.until(ExpectedConditions.visibilityOf(Text)).isDisplayed();
    }
}
