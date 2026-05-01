package org.ClearTrip.com.pages.Yaswanth;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class SelectHotel {
    protected WebDriver driver;
    protected WebDriverWait wait;

    private String expectedHotelName;
    private String expectedHotelPrice;

    String actualHotelName ;
    String actualHotelPrice;

    public SelectHotel(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "(//div[@class='sc-aXZVg gvuMKO c-pointer p-relative'])[1]")
    private WebElement firstHotel;

    @FindBy(xpath = "//span[contains(text(),'Hob House')]")
    private WebElement firstEleNameText;

    // Using contains for price to be more flexible with formatting/whitespace
    @FindBy(xpath = "//p[contains(text(),'₹7,907')]")
    private WebElement firstElePriceText;

    @FindBy(xpath = "//h1[contains(text(),'Hob House')]")
    private WebElement openedHotelNameText;

    @FindBy(xpath = "//h2[contains(text(),'₹7,907')]']")
    private WebElement openedHotelPriceText;

    public SelectHotel(){
        expectedHotelName = firstEleNameText.getText();
        expectedHotelPrice = firstElePriceText.getText();
        actualHotelName = openedHotelNameText.getText();
        actualHotelPrice = openedHotelPriceText.getText();
    }
    public void clickHotel() {
        try {

            String parentWindow = driver.getWindowHandle();

            wait.until(ExpectedConditions.elementToBeClickable(firstHotel)).click();

            Set<String> allWindows = driver.getWindowHandles();
            for (String handle : allWindows) {
                if (!handle.equals(parentWindow)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }

            System.out.println("Switched focus to: " + driver.getTitle());

        } catch (Exception e) {
            System.err.println("Failed to click hotel or switch window: " + e.getMessage());
        }
    }

    public boolean validateOpenedHotel() {
        try {
            // 4. Capture info from the detailed hotel page (new window)

            System.out.println("expectedname: "+expectedHotelName+"expectedprice :"+expectedHotelPrice);

            System.out.println("actualname: "+actualHotelName+"actualprice :"+actualHotelPrice);
            boolean a = expectedHotelName == actualHotelName ? true:false;
            boolean b = expectedHotelPrice == actualHotelPrice ? true:false;
            if(a==b){
                return true;
            }
            return false;

        } catch (Exception e) {
            System.err.println("Validation failed: " + e.getMessage());
            return false;
        }
    }
}