package RestAssured.Misc.PetStoreTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class E2ETestforPetStore {
    @Test
    public void createPet() {
//Post request to add a new pet and get the id
        {
            String payload = "{\n" +
                    "\"id\": 188,\n" +
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

            RequestSpecification httprequest = RestAssured.given();
            httprequest.baseUri("https://petstore.swagger.io/");
            httprequest.basePath("v2/pet/");
            httprequest.contentType(ContentType.JSON);
            httprequest.body(payload);

            Response response = httprequest.when().post();
            String responsestring = response.asString();
            System.out.println(responsestring);

            ValidatableResponse validate = response.then().log().all();
            validate.statusCode(200);

            response = httprequest.when().post();
            validate = response.then().log().all();
            validate.statusCode(200);

            // to extract the id
            int id = response.then().extract().path("id");
            System.out.println("Pet Id is " + id);



            // Put request for updating the existing pet details. Set status to sold at the newly uploaded pet  (PUT)
            String payload_put = "{\n" +
                    "\"id\": 180,\n" +
                    "\"category\": {\n" +
                    "\"id\": 0,\n" +
                    "\"name\": \"Loki\"\n" +
                    "},\n" +
                    "\"name\": \"dog\",\n" +
                    "\"photoUrls\": [\n" +
                    "\"string\"\n" +
                    "],\n" +
                    "\"tags\": [\n" +
                    "{\n" +
                    "\"id\": 0,\n" +
                    "\"name\": \"Cavalier\"\n" +
                    "}\n" +
                    "],\n" +
                    "\"status\": \"sold\"\n" +
                    "}";

            httprequest.basePath("v2/pet/");
            httprequest.body(payload_put);
            response = httprequest.when().put();
            validate = response.then().log().all();
            validate.statusCode(200);
            validate.body("status", Matchers.equalTo("sold"));

            String status = response.then().extract().path("status");
            System.out.println("The new status is " + status);

            //Find the pet by id
            httprequest.basePath("v2/pet/" + id);
            response = httprequest.when().get();
            validate = response.then().log().all();
            validate.statusCode(200);
            System.out.println("Pet Id " + id +" is found");

            //Find the  pet by checking its status
            httprequest.basePath("v2/pet/findByStatus?status=available" + status);
            response = httprequest.when().get();
            validate = response.then().log().all();
            validate.statusCode(200);
            System.out.println("Pet Id " + id +" is available");

            // Test 4 : Delete the newly added pet (where status was changed to "sold")   (DELETE)
            httprequest.basePath("v2/pet/" + id);
            response = httprequest.when().delete();
            validate = response.then().log().all();
            validate.statusCode(200);
            System.out.println("Pet Id " + id +" is deleted");


//Find pet by the deleted id - Negative TC Already deleted pet does not exist    (GET)
            httprequest.basePath("v2/pet/" + id);
            response = httprequest.when().get();
            validate = response.then().log().all();
            validate.statusCode(404);
        }

        }
    }

