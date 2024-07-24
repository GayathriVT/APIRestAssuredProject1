package RestAssured.Misc.PetStoreTests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class PetstoreGet {

    @Test
        public void getRequest()

        {
            RestAssured
                    .given()
                    .when().get("https://petstore.swagger.io/#/")
                    .then().log().all().statusCode(200);
        }

    }

