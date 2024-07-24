package RestAssured.Misc.PetStoreTests;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ReadAllPets {
    public static RequestSpecification httprequest;
    public static Response response;
    public static ValidatableResponse validate;
    public static int id;
    //public static int statusCode;

    String BASE_URL = "https://petstore.swagger.io";
    //https://petstore.swagger.io/v2/pet/findByStatus?status=available
    String BASE_PATH = "v2/pet/";
    public static String url = "https://petstore.swagger.io/v2";

    // Test 1: Get Request for reading all available pets
    @Test(priority = 0)
    public void readAllPets() {
        given()
                .when()
                //.get(BASE_URL + "/v2/pet//pet/findByStatus?status=available")
                .get(url+"/pet/findByStatus?status=available")
                .then()
                .assertThat()
                .statusCode(200);

    }
}

