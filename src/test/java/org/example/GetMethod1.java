package org.example;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetMethod1 {
    @Test (groups = {"Positive"}, priority = 2) //Using Groups and Priority
    public void getRequest_Positive()
    {
        given().baseUri("https://simple-books-api.glitch.me")
                .when().get()
                .then().log().all().statusCode(200);
    }
    @Test (groups = {"Negative"},priority = 1)
    public void getRequest_Negative()
    {
        given().baseUri("https://simple-books-api.glitch.me")
                .when().get()
                .then().log().all().statusCode(201);
    }
    @Test
    public static void getResponseBody()
    {
        given().
                when().get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1")
                .then().log().all();

    }
    @Test
    public static void getResponseBody1()
    {
        given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1")
                .when().get("http://demo.guru99.com/V4/sinkministatement.php")
                .then().log().body();
    }
    @Test
    public static void getResponseStatus()
    {

                int statusCode = given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1")
                .when().get("http://demo.guru99.com/V4/sinkministatement.php").getStatusCode();
                 System.out.println("The response status is "+ statusCode);
                //given().when().get().then().assertThat().statusCode(200);
    }
}
