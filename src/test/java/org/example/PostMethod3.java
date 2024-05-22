package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PostMethod3 {
    RequestSpecification httprequest;
    Response response;
    ValidatableResponse validate;
    String payload = "{\n" +
            "   \"clientName\": \"Gaya\",\n" +
            "   \"clientEmail\": \"gaya.00@gmail.com\"\n" +
            "}";


    @BeforeTest
    public void PrePostRequest()
    {
        httprequest = RestAssured.given();
        httprequest.baseUri("https://simple-books-api.glitch.me");
        httprequest.basePath("/api-clients");
        httprequest.contentType(ContentType.JSON);
    }
    @Test
    public void postmethod()
    {
        httprequest.body(payload);
        response = httprequest.when().post();
        String responsestring = response.asString();
        System.out.println(responsestring);
    }

    @AfterTest
    public void validateTest()
    {
        validate = response.then();
        validate.statusCode(201);
    }
}
