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

    //Testing of First Name, Last Name and Phone Number addition
    @Test (priority = 1)
    public void userDetailsAddition() throws InterruptedException {
        test=extent.createTest("userDetailsAddition");
        HomePage homepage = PageFactory.initElements(driver, HomePage.class);
        SignInPage signIn = PageFactory.initElements(driver, SignInPage.class);
        ApplicationDashboard applicationDashboard = PageFactory.initElements(driver, ApplicationDashboard.class);
        BuildYourProfile yourProfile = PageFactory.initElements(driver, BuildYourProfile.class);

        String strEmail="9medo.mahmed.737d@hecou.com";
        String strFirstName="Qasim";
        String strLastName="Alam";
        String strPhoneNumber="Alam";


        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        test.log(Status.PASS, "Click on Dropdown menu");
        Thread.sleep(2000);
        homepage.clickDropdownMenu();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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

        test.log(Status.PASS, "Verify First Name");
        yourProfile.verifyFirstName(strFirstName);
        test.log(Status.PASS, "Verify Last Name");
        yourProfile.verifyLastName(strLastName);

    }

    //Testing of Clear form button
    @Test (priority = 2)
    public void clearButtonFunctionality() throws InterruptedException {
        test=extent.createTest("clearButtonFunctionality");
        HomePage homepage = PageFactory.initElements(driver, HomePage.class);
        SignInPage signIn = PageFactory.initElements(driver, SignInPage.class);
        ApplicationDashboard applicationDashboard = PageFactory.initElements(driver, ApplicationDashboard.class);
        BuildYourProfile yourProfile = PageFactory.initElements(driver, BuildYourProfile.class);

        String strEmail="9medo.mahmed.737d@hecou.com";
        //String strFirstName="Qasim";
        //String strLastName="Alam";
        //String strPhoneNumber="Alam";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        test.log(Status.PASS, "Click on Dropdown menu");
        Thread.sleep(2000);
        homepage.clickDropdownMenu();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
        Thread.sleep(2000);
        test.log(Status.PASS, "Click on Clear button");
        yourProfile.clickClear();
        test.log(Status.PASS, "Verify First Name Place Holder");
        yourProfile.verifyPlaceHolderFirstName();
        test.log(Status.PASS, "Verify Last Name Place Holder");
        yourProfile.verifyPlaceHolderLastName();
        test.log(Status.PASS, "Verify Email Place Holder");
        yourProfile.verifyPlaceHolderPhoneNumber();

    }

    //Sign up without email verification
    @Test(priority=5)
    public void signup() throws Exception {
        test=extent.createTest("signup");
        HomePage homepage = PageFactory.initElements(driver, HomePage.class);
        SignUpPage signup = PageFactory.initElements(driver, SignUpPage.class);
        SignInPage signIn = PageFactory.initElements(driver, SignInPage.class);
        test.log(Status.PASS, "Click on Dropdown menu");
        Thread.sleep(2000);
        homepage.clickDropdownMenu();
        test.log(Status.PASS, "Click on Sign In Link");
        Thread.sleep(2000);
        homepage.clickSignIn();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(2000);
        test.log(Status.PASS, "Click on Sign Up Link");
        signIn.clickSignUp();
        test.log(Status.PASS, "Verify Title of Sign Up page");
        signIn.verifyTitle();
        test.log(Status.PASS, "Enter First Name");
        signup.typeFirstName("Qasim");
        test.log(Status.PASS, "Enter Last Name");
        signup.typeLastName("Alam");
        test.log(Status.PASS, "Enter Password");
        signup.typePassword("Yu34@qrs1234");
        test.log(Status.PASS, "Enter Confirm Password");
        signup.typeConfirmPassword("Yu34@qrs1234");
        test.log(Status.PASS, "Enter an Email");
        signup.typeEmail("hsaraa.khan.564l@encrytech.com");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(2000);
       // signup.clickSignUp();
        signup.typePhoneNumber();
        test.log(Status.PASS, "Select Terms and Condition checkbox");


        Thread.sleep(2000);
        test.log(Status.INFO, "Click on Sign UP");
    //    signup.clickSignUp();
        //test.log(Status.INFO, "Enter Phone Number");
   //     signup.typePhoneNumber();
     //   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       // test.log(Status.PASS, "Click on Sign Up Button");
        //signup.clickSignUp();

    }

    //Sign In and Sign Out verification
    @Test (priority = 4)
    public void SignInAndSignOut() throws InterruptedException {
        test=extent.createTest("SignInAndSignOut");
        HomePage homepage = PageFactory.initElements(driver, HomePage.class);
        SignInPage signIn = PageFactory.initElements(driver, SignInPage.class);
        ApplicationDashboard applicationDashboard = PageFactory.initElements(driver, ApplicationDashboard.class);
        BuildYourProfile yourProfile = PageFactory.initElements(driver, BuildYourProfile.class);

        String strEmail="9medo.mahmed.737d@hecou.com";
        String strFirstName="Qasim";
        String strLastName="Alam";
        String strPhoneNumber="Alam";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        test.log(Status.PASS, "Click on Dropdown menu");
        Thread.sleep(2000);
        homepage.clickDropdownMenu();
        test.log(Status.PASS, "Click on Sign In Link");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        homepage.clickSignIn();
        test.log(Status.PASS, "Verify Title of Sign In page");
        signIn.verifyTitle();
        test.log(Status.PASS, "Enter User Name");
        signIn.typeUserName(strEmail);
        test.log(Status.PASS, "Enter Password");
        signIn.typePassword("Yu34@qrs1234");
        test.log(Status.PASS, "Click on Login button");
        signIn.clickLogin();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(2000);
        test.log(Status.PASS, "Click on Dropdown menu");
        homepage.clickDropdownMenu();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        test.log(Status.PASS, "Click on Sign out and Verify the Sign out Message");
        homepage.clickSignOut();

    }

    @AfterTest
    public void publishReport(){
        extent.flush();
    }

}
