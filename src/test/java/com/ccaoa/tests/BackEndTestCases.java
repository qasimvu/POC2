package com.ccaoa.tests;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ccaoa.Base.RestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.*;
import static io.restassured.RestAssured.given;


@Test
public class BackEndTestCases extends RestBase {

    @BeforeSuite
    public void initializeReport(){

        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/BackEndReport.html");
        // Title of the Report
        htmlReporter.config().setDocumentTitle("Test Automation Report");
        //Name of the Report
        htmlReporter.config().setReportName("Backend Test Report");
        htmlReporter.config().setTheme(Theme.STANDARD);


        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("HostName", "LocalHost");
        extent.setSystemInfo("OS", "Windows10");
        extent.setSystemInfo("OS Type", "64 bit Operating System, x64 based processor");
        extent.setSystemInfo("Tester Name", "Qasim Alam");
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("BrowserVersion", "87.0.4280.88");

    }
    //Provider Search status code verification
    @Test (priority = 0)
    public void getResponseStatus()throws InterruptedException{
        test=extent.createTest("getResponseStatus");
       // test=test.createTest("getResponseStatus");
        test.log(Status.PASS, "Verify the Status Code");
        int statusCode= given()
                .queryParam("providerId","9244745")
                .queryParam("accredited","true")
                .queryParam("pageNumber","0") .when()
                .get("https://api.dev.greatchildcare.org/api/provider/search")
                .getStatusCode();
        System.out.println("The response status is "+statusCode);
    }

    //Provider Search Based on Provider ID
    @Test (priority = 1)
    public void ProviderIdSearch(){
        test=extent.createTest("ProviderIdSearch");
    RestAssured.baseURI= "https://api.dev.greatchildcare.org/api/provider/search";
    test.log(Status.PASS, "Enter Provider Id in Provider ID field");
    Response response = RestAssured.given().queryParam("providerId", "9245349").when().get();
    test.log(Status.PASS, "Printing response Body");
    System.out.println("Response Body " + response.prettyPrint());
    ResponseBody body = response.getBody();
    // Verify Body contains Business Name correctly
    String businessName = body.asString();
    test.log(Status.PASS, "Verify the Business Name in JSON Body");
    Assert.assertEquals(businessName.contains("Accreditation Home"), true, "Response Body contains Business Name as Accreditation Home");

    // Verify Body contains City correctly
        String city = body.asString();
        test.log(Status.PASS, "Verify the City in JSON Body");
        Assert.assertEquals(city.contains("Dallas"), true, "Response Body contains City as Dallas");

}

    //Provider Search Based on Accredited
    @Test (priority = 2)
    public void accreditedSearch(){
        test=extent.createTest("accreditedSearch");
        RestAssured.baseURI= "https://api.dev.greatchildcare.org/api/provider/search";
        test.log(Status.PASS, "Enter Page Number, City and Accreditation in parameters");
        Response response = RestAssured.given()
                .queryParam("pageNumber", "0")
                .queryParam("city", "Dallas")
                .queryParam("accredited", "true")
                .when().get();
        System.out.println("Response Body " + response.prettyPrint());

        ResponseBody body = response.getBody();

        // Verifying Body contains Provider Id correctly
        test.log(Status.PASS, "Verify the Provider ID in JSON Body");
        String providerId = body.asString();
        Assert.assertEquals(providerId.contains("9245349"), true, "Response Body contains Provider ID as 9245349");

        // Verifying Body contains Zip Code correctly
        test.log(Status.PASS, "Verify the Zip Code in JSON Body");
        String zipCode = body.asString();
        Assert.assertEquals(zipCode.contains("75241"), true, "Response Body contains Zip Code as 75241");
    }

    @Test (priority = 2)
    public void zipCodeSearch(){
        test=extent.createTest("accreditedSearch");
        RestAssured.baseURI= "https://api.dev.greatchildcare.org/api/provider/search";
        test.log(Status.PASS, "Enter Page Number, City and Accreditation in parameters");
        Response response = RestAssured.given()
                .queryParam("zipCode", "02472")
                .when().get();
        System.out.println("Response Body " + response.prettyPrint());

        ResponseBody body = response.getBody();

        // Verifying Body contains Provider Id correctly
        test.log(Status.PASS, "Verify the Provider ID in JSON Body");
        String providerId = body.asString();
        Assert.assertEquals(providerId.contains("9244745"), true, "Response Body contains Provider ID as 9245349");

        // Verifying Body contains Zip Code correctly
        test.log(Status.PASS, "Verify the Zip Code in JSON Body");
        String zipCode = body.asString();
        Assert.assertEquals(zipCode.contains("02472"), true, "Response Body contains Zip Code as 75241");
    }


    @AfterSuite
    public void publish(){

        extent.flush();
    }
}



