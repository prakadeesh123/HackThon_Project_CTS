package org.MakeMyTrip.com.baseclass;

import org.MakeMyTrip.com.utility.ConfigReader;
import org.MakeMyTrip.com.utility.Screenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import javax.script.ScriptEngine;

public class BaseClass {

    public WebDriver driver;
    @BeforeMethod
    public void setUp(){
        String browser = ConfigReader.getProperties("browser");
        String url = ConfigReader.getProperties("baseurl");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        if(browser.equals("chrome")){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        else if(browser.equals("edge")){
            driver = new EdgeDriver();
        }
        else if(browser.equals("firefox")){
            driver = new FirefoxDriver();
        }
        driver.get(url);
    }
    @AfterMethod
    public void tearDown(ITestResult result){
        try{
            if(result.getStatus() == ITestResult.FAILURE){
                Screenshot.takesScreenshot(driver,"_Failed");
            }
            else{
                Screenshot.takesScreenshot(driver,"_Passed");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(driver != null){
//                driver.quit();
            }

        }
    }
}
