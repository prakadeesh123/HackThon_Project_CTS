package org.ClearTrip.com.utility;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.*;

public class ExtentReportManager implements ITestListener {

    private ExtentReports extent;
    private ExtentTest test;

    @Override
    public void onStart(ITestContext context) {

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(
                System.getProperty("user.dir") + "/reports/ExtentReport.html");

        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing");
        sparkReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Added System Info
        extent.setSystemInfo("Project", "ClearTrip Automation");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester", "2481415");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.PASS, "Test case PASSED is: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "Test case FAILED is: " + result.getName());
        test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.SKIP, "Test case SKIPPED: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}