package org.MakeMyTrip.com.pages.Yaswanth;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v143.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class SelectHotel {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public SelectHotel(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//div[@class='sc-aXZVg gvuMKO c-pointer p-relative'])[1]")
    private WebElement firstHotel;

    @FindBy(xpath = "(//span[text()='Hob House'])")
    private WebElement firstEleNameText;

    @FindBy(xpath = "//div[text()='₹7,907\n" +
            "+ ₹2,020 taxes & fees\n" +
            "\n" +
            "/ night']")
    private WebElement firstElePriceText;

    @FindBy(xpath = "//h1[text()='Hob House']")
    private WebElement openedHotelNameText;

    @FindBy(xpath = "(//div[@class='sc-aXZVg hKtzvB flex flex-baseline'])[1]")
    private WebElement openedHotelPriceText;


    public void clickHotel(){
        try{
            String parentWindow = driver.getWindowHandle();
            wait.until(ExpectedConditions.elementToBeClickable(firstHotel)).click();
            Set<String> allWindows = driver.getWindowHandles();
            for (String handle : allWindows) {
                if (!handle.equals(parentWindow)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }
            System.out.println("New window title: " + driver.getTitle());
//            driver.close();
//            driver.switchTo().window(parentWindow);

        }catch (Exception e){
            e.printStackTrace();
            return;
        }
    }
    public boolean validateOpenedHotel(){
        try{

            String hotelName = wait.until(ExpectedConditions.visibilityOf(firstEleNameText)).getText();
            String hotelPrice = wait.until(ExpectedConditions.visibilityOf(firstElePriceText)).getText();
            String OpenedHotelName = wait.until(ExpectedConditions.visibilityOf(openedHotelNameText)).getText();
            String OpenedHotelPrice = wait.until(ExpectedConditions.visibilityOf(openedHotelPriceText)).getText();

            return (hotelName.equals(OpenedHotelName) && hotelPrice.equals(OpenedHotelPrice));


        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
