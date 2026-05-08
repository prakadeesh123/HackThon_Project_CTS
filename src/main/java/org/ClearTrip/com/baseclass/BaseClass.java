package org.ClearTrip.com.baseclass;
import org.ClearTrip.com.utility.ConfigReader;
import org.ClearTrip.com.utility.LogUtil;
import org.ClearTrip.com.utility.Screenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
    public static WebDriver driver;
    @BeforeMethod
    public void setUp() {
        LogUtil.info("Starting browser setup");
        String browserName = ConfigReader.getProperties("browser").toLowerCase();
        switch (browserName) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
//                chromeOptions.addArguments("--headless=new");
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--disable-popup-blocking");
                chromeOptions.addArguments("--disable-infobars");
                chromeOptions.addArguments("--disable-gpu");
                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
//                edgeOptions.addArguments("--headless=new");
                edgeOptions.addArguments("--disable-notifications");
                edgeOptions.addArguments("--disable-popup-blocking");
                edgeOptions.addArguments("--disable-infobars");
                edgeOptions.addArguments("--disable-gpu");
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
        LogUtil.info("Launching application URL");
        driver.get(ConfigReader.getProperties("baseurl"));
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String timestamp = new java.text.SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date());
        if (result.getStatus() == ITestResult.FAILURE) {
            LogUtil.error("Test Failed: " + methodName);
            Screenshot.takesScreenshot(driver, methodName + "_FAILED_" + timestamp);
        }
        else if (result.getStatus() == ITestResult.SUCCESS) {
            LogUtil.info("Test Passed: " + methodName);
            Screenshot.takesScreenshot(driver, methodName + "_PASSED_" + timestamp);
        }
        if (driver != null) {
            LogUtil.info("Closing browser for: " + methodName);
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }
}

