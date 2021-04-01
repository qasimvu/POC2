package com.ccaoa.Base;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

// Added by Qasim Alam

public class Base {
    public static WebDriver driver = null;
    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest test;



    @BeforeMethod
    public void initialize() throws IOException {

        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");

        driver = new ChromeDriver();

        //To maximize browser
        driver.manage().window().maximize();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://staging.greatchildcare.org/");


    }

    @AfterMethod
    public void TeardownTest(ITestResult result) {
            if (result.getStatus() == ITestResult.FAILURE) {
                test.log(Status.FAIL, "TEST CASE " + result.getName() +" IS FAILED");
                test.log(Status.FAIL, "TEST CASE " + result.getThrowable()+ " IS FAILED");
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                test.log(Status.PASS, "TEST CASE " + result.getName() + " IS PASSED");
            }
        driver.quit();
        }

    }

