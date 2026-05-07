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
                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless=new");
                edgeOptions.addArguments("--window-size=1920,1080");
                edgeOptions.addArguments("--disable-notifications");
//                edgeOptions.addArguments("--disable-popup-blocking");
                edgeOptions.addArguments("--disable-infobars");
                edgeOptions.addArguments("--disable-gpu");
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                throw new IllegalArgumentException(
                        "Unsupported browser: " + browserName
                );
        }
        LogUtil.info("Launching application URL");
        driver.get(ConfigReader.getProperties("baseurl"));
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE){
            Screenshot.takesScreenshot(driver,"Testcase_Failed");
        }
        else if(result.getStatus() == ITestResult.SUCCESS){
            Screenshot.takesScreenshot(driver,"Testcase_Success");
        }
        if (driver != null) {
            LogUtil.info("Closing browser");
            driver.quit();
        }
    }
}

