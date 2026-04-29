package org.MakeMyTrip.com.utility;

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

        //2) capture the screenshot of specific section
       /*WebElement featuredProducts=driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));

       File sourcefile=featuredProducts.getScreenshotAs(OutputType.FILE);
       File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\featredproducts.png");
       sourcefile.renameTo(targetfile); // copy sourcefile to target file
       */

        //3) capture the screenshot of webelement
//     WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
//     File sourcefile=logo.getScreenshotAs(OutputType.FILE);
//     File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\logo.png");
//     sourcefile.renameTo(targetfile); // copy sourcefile to target file

        //driver.quit();



    }

}
