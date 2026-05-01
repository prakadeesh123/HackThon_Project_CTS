package org.ClearTrip.com.pages.Yaswanth;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class FilterHotelsInNiarobia {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(xpath = "(//div[@data-testid='loginPopup']/div/div)[2]")
    private WebElement closePopUp;

    @FindBy(xpath = "//p[text()='Hotels']")
    private WebElement hotelBtn;

    @FindBy(xpath = "//div[@class='sc-aXZVg dhukqX']/input")
    private WebElement destination;

    @FindBy(xpath = "//div[@class='sc-eDPEul flPszU c-inherit place__name ']/p[text()='Nairobi County, Kenya']")
    private WebElement clickDestination;

    @FindBy(css = "p.sc-gEvEer.dtOwVR")
    private WebElement searchBtn;

    @FindBy(css = "span.sc-fqkvVR.bwtGcK")
    private WebElement validLocation;

    @FindBy(xpath = "//h1[text()='Showing hotels in Nairobi']")
    private WebElement validResult;

    @FindBy(css = "div.sc-aXZVg.gvuMKO.c-pointer.p-relative")
    private List<WebElement> listedOutput;


    // Constructor
    public FilterHotelsInNiarobia(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public void filterHotel(){
        wait.until(ExpectedConditions.elementToBeClickable(closePopUp)).click();
        wait.until(ExpectedConditions.elementToBeClickable(hotelBtn)).click();
        wait.until(ExpectedConditions.visibilityOf(destination)).sendKeys("Nairobi");
        wait.until(ExpectedConditions.elementToBeClickable(clickDestination)).click();
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();

    }
    public boolean ValidateFilter(){
        boolean a = wait.until(ExpectedConditions.visibilityOf(validLocation)).isDisplayed();
        boolean b = wait.until(ExpectedConditions.visibilityOf(validResult)).isDisplayed();
        boolean c = listedOutput.size() > 0 ? true:false;
        if(a==true && b == true && c == true){
            return true;
        }
        return false;
    }


}