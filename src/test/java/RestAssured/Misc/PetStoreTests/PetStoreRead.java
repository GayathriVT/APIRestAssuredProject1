package RestAssured.Misc.PetStoreTests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class PetStoreRead {
    @Test
    public void readRequest()
    {
        RestAssured
                .given()
                .when().get("https://petstore.swagger.io/v2/pet/findByStatus?status=available")
                .then().log().all().statusCode(200);
    }
}
