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
    @FindBy(xpath = "//span[@class='commonModal__close']")
    private WebElement PopUp;

    @FindBy(xpath = "//li[@class='menu_Cruise']")
    private WebElement CruiseClick;

    @FindBy(xpath = "//input[@type='text' and  @placeholder='Select Destination']")
    private WebElement Destination;

    @FindBy(xpath = "//input[@placeholder='Enter Destination']")
    private WebElement TextBox;

    @FindBy(xpath = "//div[@class='no-data-found']")
    private WebElement Text;

    @FindBy(xpath = "//button[@class='ctaCardCloseBtn']")
    private WebElement Pop;

    public void ClosePopUp(){
        wait.until(ExpectedConditions.elementToBeClickable(PopUp)).click();
    }

    public void ClickCruise(){
        wait.until(ExpectedConditions.elementToBeClickable(CruiseClick)).click();
    }

    public void ClickPop(){
        wait.until(ExpectedConditions.elementToBeClickable(Pop)).click();
    }

    public void SelectDestination(){
        wait.until(ExpectedConditions.elementToBeClickable(Destination)).click();
    }

    public void ClickText(){
        wait.until(ExpectedConditions.elementToBeClickable(TextBox)).sendKeys("Delhi");
    }

    public boolean PrintResult(){
        return wait
                .until(ExpectedConditions.visibilityOf(Text))
                .isDisplayed();
    }
}
