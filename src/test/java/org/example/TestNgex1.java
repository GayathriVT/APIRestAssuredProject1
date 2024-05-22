package org.example;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestNgex1 {

@Test
    public void getRequest()

    {
        RestAssured.given().baseUri("https://simple-books-api.glitch.me")
                .when().get()
                .then().log().all().statusCode(200);
    }
}
