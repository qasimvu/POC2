package com.ccaoa.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ccaoa.Base.Base;
import com.ccaoa.pages.*;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class FrontEndTestCases extends Base {

    @BeforeTest
    public void initializeReport(){

        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/FrontEndReport.html");
        // Title of the Report
        htmlReporter.config().setDocumentTitle("Test Automation Report");
        //Name of the Report
        htmlReporter.config().setReportName("Frontend Test Report");
        htmlReporter.config().setTheme(Theme.DARK);


        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("HostName", "LocalHost");
        extent.setSystemInfo("OS", "Windows10");
        extent.setSystemInfo("OS Type", "64 bit Operating System, x64 based processor");
        extent.setSystemInfo("Tester Name", "Qasim Alam");
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("BrowserVersion", "87.0.4280.88");

    }



    //Testing of Email field population on 'Build Your Profile' page
    @Test(priority = 0)
    public void emailVerification() throws InterruptedException {

        HomePage homepage = PageFactory.initElements(driver, HomePage.class);
        SignInPage signIn = PageFactory.initElements(driver, SignInPage.class);
        ApplicationDashboard applicationDashboard = PageFactory.initElements(driver, ApplicationDashboard.class);
        BuildYourProfile yourProfile = PageFactory.initElements(driver, BuildYourProfile.class);

        String strEmail="9medo.mahmed.737d@hecou.com";

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        test=extent.createTest("emailVerification");
        test.log(Status.PASS, "Click on Dropdown menu");
        Thread.sleep(2000);
        homepage.clickDropdownMenu();
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(2000);
        test.log(Status.PASS, "Click on Sign In Link");
        homepage.clickSignIn();
        test.log(Status.PASS, "Verify Title of Sign In page");
        signIn.verifyTitle();
        test.log(Status.PASS, "Enter User Name");
        signIn.typeUserName(strEmail);
        test.log(Status.PASS, "Enter Password");
        signIn.typePassword("Yu34@qrs1234");
        test.log(Status.PASS, "Click on Login button");
        signIn.clickLogin();
        test.log(Status.PASS, "Click on Resume Application Button");
        applicationDashboard.clickResumeApplication();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        test.log(Status.PASS, "Verify Email is displaying in Email field");
        yourProfile.verifyEmail(strEmail);

    }

    @AfterTest
    public void publishReport(){
        extent.flush();
    }

}
