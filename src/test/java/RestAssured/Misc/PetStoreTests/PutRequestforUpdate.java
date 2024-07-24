package RestAssured.Misc.PetStoreTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class PutRequestforUpdate {

    @Test
    public void putRequest()
    {
        String payload = "{\n" +
                "\"id\": 180,\n" +
                "\"category\": {\n" +
                "\"id\": 0,\n" +
                "\"name\": \"Chinnu\"\n" +
                "},\n" +
                "\"name\": \"dogg0\",\n" +
                "\"photoUrls\": [\n" +
                "\"string\"\n" +
                "],\n" +
                "\"tags\": [\n" +
                "{\n" +
                "\"id\": 0,\n" +
                "\"name\": \"Doberman\"\n" +
                "}\n" +
                "],\n" +
                "\"status\": \"sold\"\n" +
                "}";


        RestAssured
                .given()
                .baseUri("https://petstore.swagger.io/")
                .basePath("v2/pet/")
                .contentType(ContentType.JSON)
                .when().body(payload).put()
                .then().log().all().statusCode(200);
    }

}


