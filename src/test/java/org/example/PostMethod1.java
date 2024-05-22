package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class PostMethod1 {
    @Test
    public void PostRequest()
    {
        String payload = "{\n" +
                "   \"clientName\": \"Gayath\",\n" +
                "   \"clientEmail\": \"gayathrivt.00@gmail.com\"\n" +
                "}";

        RestAssured
                .given()
                .baseUri("https://simple-books-api.glitch.me")
                .basePath("/api-clients")
                .contentType(ContentType.JSON)
                .when().body(payload).post()
               .then().log().all().statusCode(201);



    }

}
