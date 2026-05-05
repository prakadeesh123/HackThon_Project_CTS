package org.ClearTrip.com.pages.FlightBookingValidations;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.ArrayList;
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

    @FindBy(xpath = "//div//h4[normalize-space()='Search flights']")
    private WebElement searchButton;

    @FindBy(xpath = "//p[contains(text(),'Chennai, IN - Chennai Airport')]")
    private WebElement chennai;

    @FindBy(xpath = "//p[contains(text(),'Mumbai, IN - Chatrapati Shivaji Airport')]")
    private WebElement mumbai;

    @FindBy(xpath = "//div[@data-testid='dateSelectOnward']")
    private WebElement departureDateField;

    @FindBy(xpath = "//div[@role='gridcell' and @aria-label='Tue Jun 02 2026']")
    private WebElement departureDate;

    @FindBy(xpath = "(//div//p[normalize-space()='Early morning'])[1]")
    private WebElement earlyMorningFilter;

    @FindBy(xpath = "(//div//p[normalize-space()='Night'])[1]")
    private WebElement NightFilter;

    @FindBy(xpath = "(//div//p[normalize-space()='IndiGo'])[1]")
    private WebElement indigoFilter;

    @FindBy(xpath = "//p[normalize-space()='Price']")
    private WebElement Price;

    private void jsScrollAndClick(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        js.executeScript("arguments[0].click();", element);
    }

    private void writeToExcel(List<String[]> flightData) {

        String filePath = "testdata/FlightDetails.xlsx";

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Flight Details");
        int rowNum = 0;
        Row header = sheet.createRow(rowNum++);
        String[] headers = {
                "Airline", "Flight Number", "Departure",
                "Arrival", "Duration", "Refund Type", "Price"
        };

        for (int i = 0; i < headers.length; i++) {
            header.createCell(i).setCellValue(headers[i]);
        }
        for (String[] data : flightData) {
            Row row = sheet.createRow(rowNum++);
            for (int i = 0; i < data.length; i++) {
                row.createCell(i).setCellValue(data[i]);
            }
        }

        try (FileOutputStream fos = new FileOutputStream(new File(filePath))) {
            workbook.write(fos);
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void FlightDetails() {
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
        wait.until(ExpectedConditions.elementToBeClickable(Price)).click();

        List<WebElement> flightCards = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//div[contains(@class,'bg-white')]")
                )
        );

        List<String[]> excelData = new ArrayList<>();

        for (WebElement flight : flightCards) {
            try {
                String airline = flight.findElement(By.xpath(".//p[@font-weight='500']")).getText();
                String flightNo = flight.findElement(By.xpath(".//p[@font-size='10px']")).getText();
                String departTime = flight.findElements(By.xpath(".//p[@font-size='16px']")).get(0).getText();
                String arriveTime = flight.findElements(By.xpath(".//p[@font-size='16px']")).get(1).getText();
                String duration = flight.findElement(By.xpath(".//p[contains(text(),'h')]")).getText();
                String price = flight.findElement(By.xpath(".//h2[contains(text(),'₹')]")).getText();
                String refund = flight.findElement(By.xpath(".//p[contains(text(),'Refundable')]")).getText();

                excelData.add(new String[]{
                        airline, flightNo, departTime,
                        arriveTime, duration, refund, price
                });

            } catch (Exception e) {
                //
            }
        }
        writeToExcel(excelData);
    }

}