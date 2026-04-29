package org.MakeMyTrip.com.pages.Sagar;

//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
//import org.openqa.selenium.support.ui.WebDriverWait;

//import java.time.Duration;

public class Page_01_ApplyFilter  {
    public WebDriver driver;
    public WebDriverWait wait;
//    JavascriptExecutor js;

    @FindBy(css="button#hsw_search_button")
    private WebElement Search;

    @FindBy(name="amenities")
    private WebElement Searchamenities;

    @FindBy(xpath = "//span[text()='Elevator/Lift']")
    private WebElement selectelevator;

    @FindBy(xpath = "//button[text()='Apply']")
    private WebElement applybtn;

    @FindBy(xpath = "//span[contains(text(),'Elevator/Lift')]")
    private WebElement visibletext;

    public Page_01_ApplyFilter(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);

    }
    public void searchbtn(){
        wait.until(ExpectedConditions.elementToBeClickable(Search)).click();
    }
    public void filtersearch(String filter){
        wait.until(ExpectedConditions.elementToBeClickable(Searchamenities)).click();
    }
    public void clickelevator(){
        wait.until(ExpectedConditions.elementToBeClickable(selectelevator)).click();

    }
    public void apply(){
        wait.until(ExpectedConditions.elementToBeClickable(applybtn)).click();
    }
    public boolean Checktext(){
        boolean abc =  wait.until(ExpectedConditions.visibilityOf(visibletext)).isDisplayed();
        if(abc){
            System.out.println("sucess");
        }
        return abc;
    }


}
