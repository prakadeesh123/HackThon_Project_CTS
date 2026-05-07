package org.ClearTrip.com.utility;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {

    public static String takesScreenshot(WebDriver driver,String testName) {
        TakesScreenshot ts = ((TakesScreenshot) driver);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(System.getProperty("user.dir")+"\\screenshots\\"+testName+".png");
        sourceFile.renameTo(targetFile);
        return testName.toString();

    }

}
