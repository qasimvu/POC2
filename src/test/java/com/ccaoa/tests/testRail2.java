package com.ccaoa.tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;



public class testRail2 {

    private static String requestBody = "{\n" +
            "    \"suite_id\": 4,\n" +
            "    \"name\": \"Automated Test Execution-Created By Automated Test - for R&D\",\n" +
            "    \"include_all\": true\n" +
            "}";

    @Test
    void checkAuthorizationTest() {

        given().auth().preemptive().basic("shussain@enquizit.com","SarfrazHussain@123").
                contentType("application/json")
                .body(requestBody)
                .when().post("https://greatchildcare.testrail.io/index.php?/api/v2/add_run/1")
                .then().log().all().assertThat().statusCode(200);
    }
}


