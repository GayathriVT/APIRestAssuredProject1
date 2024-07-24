package RestAssured.Misc.PetStoreTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Test
public class AddAPetPost {

    public static long id;
    @Test
    public void PostRequest()
    {
        String payload = "{\n" +
                "\"id\": 180,\n" +
                "\"category\": {\n" +
                "\"id\": 180,\n" +
                "\"name\": \"Chikku\"\n" +
                "},\n" +
                "\"name\": \"doggie\",\n" +
                "\"photoUrls\": [\n" +
                "\"string\"\n" +
                "],\n" +
                "\"tags\": [\n" +
                "{\n" +
                "\"id\": 180,\n" +
                "\"name\": \"Doberman\"\n" +
                "}\n" +
                "],\n" +
                "\"status\": \"available\"\n" +
                "}";


        given()
                .baseUri("https://petstore.swagger.io/")
                .basePath("v2/pet/")
                .contentType(ContentType.JSON)
                .when().body(payload).post()
                .then().log().all().statusCode(200);





    }

    }


