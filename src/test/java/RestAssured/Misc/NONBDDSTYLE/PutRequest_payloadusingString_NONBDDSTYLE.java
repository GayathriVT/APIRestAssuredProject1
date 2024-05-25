package RestAssured.Misc.NONBDDSTYLE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class PutRequest_payloadusingString_NONBDDSTYLE {
@Test
    public void putRequest()
    {
        // post request to get the token
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
//Non BDD Style to extract token from the request to use it to the next request
        RequestSpecification httprequest = RestAssured.given();
        httprequest.baseUri("https://restful-booker.herokuapp.com");
        httprequest.basePath("/auth");
        httprequest.contentType(ContentType.JSON);
        httprequest.body(payload);

        Response response = httprequest.when().post();
        String responsestring = response.asString();
        System.out.println(responsestring);

        ValidatableResponse validate = response.then().log().all();
        validate.statusCode(200);

        // to extract the token
        String token = response.then().extract().path("token");
        System.out.println("Token is " + token);

        //Post request to get id
        String payload_post = "{\n" +
                "    \"firstname\" : \"Gayathri\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 113,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        httprequest.basePath("/booking");
        httprequest.body(payload_post);
        response = httprequest.when().post();
        validate = response.then().log().all();
        validate.statusCode(200);

        // to extract the id
        int id = response.then().extract().path("bookingid");
        System.out.println("Bookind Id is " + id);

        // put request - Give the extracted token and id into Put request
        String payload_put = "{\n" +
                "    \"firstname\" : \"Thatha\",\n" +
                "    \"lastname\" : \"Nair\",\n" +
                "    \"totalprice\" : 113,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        httprequest.basePath("/booking/"+ id);
        httprequest.cookie("token",token);
        httprequest.body(payload_put);
        response = httprequest.when().put();
        validate = response.then().log().all();
        validate.statusCode(200);
        validate.body("firstname", Matchers.equalTo("Thatha"));
        //System.out.println("hello");

        //delete request
        httprequest.basePath("/booking/"+ id);
        httprequest.cookie("token",token);
        response = httprequest.when().delete();
        validate = response.then().log().all();
        validate.statusCode(201);

    }
}
