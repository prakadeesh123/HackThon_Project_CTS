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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Page_05_FlightDetailsPrint {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public static final Logger log =
            LoggerFactory.getLogger(Page_05_FlightDetailsPrint.class);

    public Page_05_FlightDetailsPrint(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
        log.info("Page_05_FlightDetailsPrint page initialized");
    }

    // ======================= LOCATORS =======================

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
    private WebElement nightFilter;

    @FindBy(xpath = "(//div//p[normalize-space()='IndiGo'])[1]")
    private WebElement indigoFilter;

    @FindBy(xpath = "//p[normalize-space()='Price']")
    private WebElement priceSort;

    // ======================= UTIL =======================

    private void jsScrollAndClick(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        js.executeScript("arguments[0].click();", element);
        log.info("Scrolled and clicked element using JavaScript");
    }

    // ======================= EXCEL =======================

    private void writeToExcel(List<String[]> flightData) {

        String filePath = "testdata/FlightDetails.xlsx";
        log.info("Writing {} flight records to Excel", flightData.size());

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Flight Details");

        String[] headers = {
                "Airline", "Flight Number", "Departure",
                "Arrival", "Duration", "Refund Type", "Price"
        };

        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            headerRow.createCell(i).setCellValue(headers[i]);
        }

        int rowNum = 1;
        for (String[] data : flightData) {
            Row row = sheet.createRow(rowNum++);
            for (int i = 0; i < data.length; i++) {
                row.createCell(i).setCellValue(data[i]);
            }
        }

        try (FileOutputStream fos = new FileOutputStream(new File(filePath))) {
            workbook.write(fos);
            workbook.close();
            log.info("Excel file created successfully at {}", filePath);
        } catch (Exception e) {
            log.error("Failed to write Excel file", e);
        }
    }

    // ======================= MAIN LOGIC =======================

    public int fetchAndSaveFlightDetails() {

        log.info("Starting flight details extraction");

        wait.until(ExpectedConditions.elementToBeClickable(sourceInput)).click();
        wait.until(ExpectedConditions.elementToBeClickable(chennai)).click();

        wait.until(ExpectedConditions.elementToBeClickable(destinationInput)).click();
        wait.until(ExpectedConditions.elementToBeClickable(mumbai)).click();

        wait.until(ExpectedConditions.elementToBeClickable(departureDateField)).click();
        wait.until(ExpectedConditions.elementToBeClickable(departureDate)).click();

        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        log.info("Search flights clicked");

        jsScrollAndClick(earlyMorningFilter);
        jsScrollAndClick(nightFilter);

        wait.until(ExpectedConditions.elementToBeClickable(indigoFilter)).click();
        log.info("IndiGo filter applied");

        wait.until(ExpectedConditions.elementToBeClickable(priceSort)).click();
        log.info("Price sorting applied");

        By flightCardLocator =
                By.xpath("//div[contains(@class,'bg-white') and .//h2[contains(text(),'₹')]]");

        wait.until(ExpectedConditions.visibilityOfElementLocated(flightCardLocator));

        List<WebElement> flightCards = driver.findElements(flightCardLocator);
        log.info("Visible flight cards found: {}", flightCards.size());

        List<String[]> excelData = new ArrayList<>();

        for (WebElement flight : flightCards) {
            try {
                excelData.add(new String[]{
                        flight.findElement(By.xpath(".//p[@font-weight='500']")).getText(),
                        flight.findElement(By.xpath(".//p[@font-size='10px']")).getText(),
                        flight.findElements(By.xpath(".//p[@font-size='16px']")).get(0).getText(),
                        flight.findElements(By.xpath(".//p[@font-size='16px']")).get(1).getText(),
                        flight.findElement(By.xpath(".//p[contains(text(),'h')]")).getText(),
                        flight.findElement(By.xpath(".//p[contains(text(),'Refundable')]")).getText(),
                        flight.findElement(By.xpath(".//h2[contains(text(),'₹')]")).getText()
                });
            } catch (Exception e) {
                log.warn("Skipped one flight card due to missing data");
            }
        }

        if (!excelData.isEmpty()) {
            writeToExcel(excelData);
        }

        log.info("Total valid flights captured: {}", excelData.size());
        return excelData.size();
    }
}