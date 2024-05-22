package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PostMethod2 {
    @Test
    public void postmethod()
    {
        String payload = "{\n" +
                "   \"clientName\": \"Gaya\",\n" +
                "   \"clientEmail\": \"gaya.00@gmail.com\"\n" +
                "}";
        RequestSpecification httprequest = RestAssured.given();
        httprequest.baseUri("https://simple-books-api.glitch.me");
        httprequest.basePath("/api-clients");
        httprequest.contentType(ContentType.JSON);
        httprequest.body(payload);

        Response response = httprequest.when().post();
        String responsestring = response.asString();
        System.out.println(responsestring);

        ValidatableResponse validate = response.then();
        validate.statusCode(201);
    }
}
