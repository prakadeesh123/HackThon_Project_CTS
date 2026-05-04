package org.ClearTrip.com.pages.Prakadeesh;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Page_05_FlightDetailsPrint {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public Page_05_FlightDetailsPrint(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Where from?']")
    private WebElement sourceInput;

    @FindBy(xpath = "//input[@placeholder='Where to?']")
    private WebElement destinationInput;

    @FindBy(xpath = "//h4[normalize-space()=\"Search flights\"]")
    private WebElement searchButton;

    @FindBy(xpath = "//p[contains(text(),'Chennai, IN - Chennai Airport')]")
    private WebElement chennai;

    @FindBy(xpath = "//p[contains(text(),'Mumbai, IN - Chatrapati Shivaji Airport')]")
    private WebElement mumbai;

    // ================= DATE =================

    @FindBy(xpath = "//div[@data-testid='dateSelectOnward']")
    private WebElement departureDateField;

    @FindBy(xpath = "//div[@role='gridcell' and @aria-label='Tue Jun 02 2026']")
    private WebElement departureDate;

    // ================= FILTERS =================

    @FindBy(xpath = "(//div//p[normalize-space()='Early morning'])[1]")
    private WebElement earlyMorningFilter;

    @FindBy(xpath = "(//div//p[normalize-space()='Night'])[1]")
    private WebElement NightFilter;

    @FindBy(xpath = "//div//p[normalize-space()='IndiGo']")
    private WebElement indigoFilter;

    @FindBy(xpath = "//div[@class='sc-aXZVg iqDbdo']")
    private WebElement ExtraFilter;

    @FindBy(xpath = "(//i[@class='sc-eeDRCY kZwtFw'])[2]")
    private WebElement Adult;

    @FindBy(xpath = "(//i[@class='sc-eeDRCY kZwtFw'])[4]")
    private WebElement Child;

    @FindBy(xpath = "(//i[@class='sc-eeDRCY kZwtFw'])[6]")
    private WebElement Infant;

    @FindBy(xpath = "//h4[normalize-space()='Update']")
    private WebElement Update;

    @FindBy(xpath = "//p[normalize-space()=\"Price\"]")
    private WebElement Price;

    private void jsScrollAndClick(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        js.executeScript("arguments[0].click();", element);
    }

    public void FlightDetails(){
        wait.until(ExpectedConditions.elementToBeClickable(sourceInput)).click();
        wait.until(ExpectedConditions.elementToBeClickable(chennai)).click();

        wait.until(ExpectedConditions.elementToBeClickable(destinationInput)).click();
        wait.until(ExpectedConditions.elementToBeClickable(mumbai)).click();

        wait.until(ExpectedConditions.elementToBeClickable(departureDateField)).click();
        wait.until(ExpectedConditions.elementToBeClickable(departureDate)).click();

        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();

        jsScrollAndClick(earlyMorningFilter);
        jsScrollAndClick(NightFilter);
        wait.until(ExpectedConditions.elementToBeClickable(indigoFilter)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(ExtraFilter)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(Adult)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(Child)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(Infant)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(Update)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Price)).click();



            // Get all flight cards
            List<WebElement> flightCards = wait.until(
                    ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            By.xpath("//div[contains(@class,'bg-white')]")
                    )
            );

            System.out.println("Total Flights Found: " + flightCards.size());
            System.out.println("--------------------------------------------------");

            int index = 1;

            for (WebElement flight : flightCards) {
                try {
                    String airline = flight.findElement(By.xpath(".//p[@font-weight='500']")).getText();
                    String flightNo = flight.findElement(By.xpath(".//p[@font-size='10px']")).getText();
                    String departTime = flight.findElements(By.xpath(".//p[@font-size='16px']")).get(0).getText();
                    String arriveTime = flight.findElements(By.xpath(".//p[@font-size='16px']")).get(1).getText();
                    String duration = flight.findElement(By.xpath(".//p[contains(text(),'h')]")).getText();
                    String price = flight.findElement(By.xpath(".//h2[contains(text(),'₹')]")).getText();
                    String refund = flight.findElement(By.xpath(".//p[contains(text(),'Refundable')]")).getText();

                    System.out.println("Flight " + index);
                    System.out.println("Airline       : " + airline);
                    System.out.println("Flight Number : " + flightNo);
                    System.out.println("Departure     : " + departTime);
                    System.out.println("Arrival       : " + arriveTime);
                    System.out.println("Duration      : " + duration);
                    System.out.println("Refund Type   : " + refund);
                    System.out.println("Price         : " + price);
                    System.out.println("--------------------------------------------------");

                    index++;
                } catch (Exception e) {
                    System.out.println("Some data missing for one flight card");
                }
            }

    }



}
