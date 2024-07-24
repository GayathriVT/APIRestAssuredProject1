package RestAssured.Misc.PetStoreTests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestE2E {

    public static RequestSpecification httprequest;
    public static Response response;
    public static ValidatableResponse validate;
    public static int id;

    String BASE_URL = "https://petstore.swagger.io/";
    String  BASE_PATH = "v2/pet/";

    public static String url = "https://petstore.swagger.io/v2";

    // Test 1: Get Request for reading all available pets
    @Test(priority = 0)
    @Owner("GVT")
    @Description("Get Request for reading all available pets")

    public void readAllPets() {
                given()
                .when()
                //.get(BASE_URL+"v2/pet//pet/findByStatus?status=available")
                .get(url+"/pet/findByStatus?status=available")
                .then()
                .assertThat()
                .statusCode(200);
    }

    //Test 2 : Post request to add a new pet and extract the id
    @Test(priority = 1)
    @Description("Post request to add a new pet and extract the id")

    public void addNewPet() {
        String payload = "{\n" +
                    "\"id\": 189,\n" +
                    "\"category\": {\n" +
                    "\"id\": 0,\n" +
                    "\"name\": \"Chikku\"\n" +
                    "},\n" +
                    "\"name\": \"doggie\",\n" +
                    "\"photoUrls\": [\n" +
                    "\"string\"\n" +
                    "],\n" +
                    "\"tags\": [\n" +
                    "{\n" +
                    "\"id\": 0,\n" +
                    "\"name\": \"Doberman\"\n" +
                    "}\n" +
                    "],\n" +
                    "\"status\": \"available\"\n" +
                    "}";

            httprequest = given();
            httprequest.baseUri(BASE_URL);
            httprequest.basePath(BASE_PATH);
            httprequest.contentType(ContentType.JSON);
            httprequest.body(payload);

            response = httprequest.when().post();
            String responsestring = response.asString();
            System.out.println(responsestring);

            validate = response.then().log().all();
            validate.statusCode(200);

            // to extract the id
            id = response.then().extract().path("id");
            Assert.assertNotNull(id);
            System.out.println("Pet Id is " + id + " created");
    }

    //Test 3 :Get request to find the pet by id
    @Test(priority = 2)
    @Description("Get request to find the pet by id")

    public void findPetbyId()
    {
        httprequest.basePath("v2/pet/" + id);
        response = httprequest.when().get();
        validate = response.then().log().all();
        validate.statusCode(200);
        System.out.println("Pet Id " + id + " is found");
       Assert.assertNotNull(id);
    }

    //Test 4 :Put request
    @Test(priority = 3)
    @Description("Updating the existing pet details. Set status to sold for the newly created pet")

    public void sellNewPet() {

        String payload_put = "{\n" +
                    "\"id\": 189,\n" +
                    "\"category\": {\n" +
                    "\"id\": 0,\n" +
                    "\"name\": \"Chikku\"\n" +
                    "},\n" +
                    "\"name\": \"doggie\",\n" +
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

            httprequest.basePath(BASE_PATH);
            httprequest.body(payload_put);
            response = httprequest.when().put();
            validate = response.then().log().all();
            validate.statusCode(200);
       //     validate.body("status", Matchers.equalTo("sold"));

            String status = response.then().extract().path("status");
            Assert.assertEquals(status,"sold");
            System.out.println("Pet " + id +" status is changed to " + status);
    }

    // Test 5 : Delete request
    @Test(priority = 4)
    @Description("Delete request to delete the sold pet from the list - Positive TC")

    public void deleteSoldPet()
    {
        httprequest.basePath((BASE_PATH) + id);
        response = httprequest.when().delete();
        validate = response.then().log().all();
        validate.statusCode(200);
        System.out.println("Pet " + id +" is sold and deleted from the list");
    }

    // Test 6 : Delete request
    @Test(priority = 5)
    @Description("Delete request to delete already deleted pet, operation fails with Error code 404 - Negative TC")

    public void deleteSoldPetAgain_NegativeTC()
    {
        httprequest.basePath((BASE_PATH) + id);
        response = httprequest.when().delete();
        validate = response.then().log().all();
        validate.statusCode(404);
        System.out.println("Pet " + id +" is already deleted");
    }

    //Test 7 : Get Request
    @Test(priority = 6)
    @Description("Find pet by the deleted id - already deleted pet should not exist - Negative TC")
    public void findDeletedPet_NegativeTC()
    {
        httprequest.basePath((BASE_PATH) + id);
        response = httprequest.when().get();
        validate = response.then().log().all();
        validate.statusCode(404);
        System.out.println("Pet " + id +" is already Sold");

    }
    }