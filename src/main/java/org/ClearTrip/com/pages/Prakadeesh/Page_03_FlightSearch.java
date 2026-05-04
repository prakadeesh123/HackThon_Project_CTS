package org.ClearTrip.com.pages.Prakadeesh;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page_03_FlightSearch{

    WebDriver driver;
    WebDriverWait wait;

    public Page_03_FlightSearch(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Where from?']")
    public WebElement Source;

    @FindBy(xpath = "//input[@placeholder='Where to?']")
    public WebElement Destination;

    @FindBy(xpath = "//h4[normalize-space()=\"Search flights\"]")
    public WebElement Button;

    @FindBy(xpath = "//p[contains(text(),'Round trip')]")
    private WebElement RoundTrip;

    @FindBy(xpath = "//span[normalize-space()=\"1 Adult, Economy\"]")
    private WebElement Filter;

    @FindBy(xpath = "(//*[name()='path' and @d='M16 9V23M9 16H23']/ancestor::button)[1]")
    private WebElement Adult;

    @FindBy(xpath = "(//*[name()='path' and @d='M16 9V23M9 16H23']/ancestor::button)[2]")
    private WebElement Children;

    @FindBy(xpath = "(//*[name()='path' and @d='M16 9V23M9 16H23']/ancestor::button)[3]")
    private WebElement Infant;

    @FindBy(xpath = "//p[contains(text(),'Chennai, IN - Chennai Airport (MAA)')]")
    private WebElement Chennai;

    @FindBy(xpath = "//p[contains(text(),'Mumbai, IN - Chatrapati Shivaji Airport (BOM)')]")
    private WebElement Mumbai;

    @FindBy(xpath = "//div[@data-testid='dateSelectOnward']")
    private WebElement DateFrom;

    @FindBy(xpath = "//div[@data-testid='dateSelectReturn']")
    private WebElement DateTo;

    @FindBy(xpath = "//div[@role='gridcell' and @aria-label='Tue Jun 02 2026']")
    private WebElement Date;

    @FindBy(xpath = "//div[contains(@style,'cursor:pointer') and contains(@style,'border-radius:12px')]")
    private WebElement NonStop;

    @FindBy(xpath = "//p[contains(text(),\"First class\")]")
    private WebElement FirstClass;

    @FindBy(xpath = "//*[name()='path' and contains(@d,'M16.115')]/ancestor::div[@cursor='pointer']")
    private WebElement iconButton;

    public void RoundTrip() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(RoundTrip)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Filter)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Adult)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Children)).click();



        wait.until(ExpectedConditions.elementToBeClickable(Infant)).click();
        //wait.until(ExpectedConditions.elementToBeClickable(FirstClass)).click();

        wait.until(ExpectedConditions.elementToBeClickable(Source)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Chennai)).click();

        wait.until(ExpectedConditions.elementToBeClickable(Destination)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Mumbai)).click();
        wait.until(ExpectedConditions.elementToBeClickable(NonStop)).click();

        wait.until(ExpectedConditions.elementToBeClickable(Button)).click();


    }


    public boolean isIconDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(iconButton)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}