package RestAssured.Misc.NONBDDSTYLE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PostMethod2_NONBDDSTYLE {
    @Test
    public void postmethod()
    {
        String payload = "{\n" +
                "   \"clientName\": \"Gay\",\n" +
                "   \"clientEmail\": \"gay.00@gmail.com\"\n" +
                "}";
        // To get the Token using Post method and payload using String and using NON BDD style
        RequestSpecification httprequest = RestAssured.given();
        httprequest.baseUri("https://simple-books-api.glitch.me");
        httprequest.basePath("/api-clients");
        httprequest.contentType(ContentType.JSON);
        httprequest.body(payload);

        Response response = httprequest.when().post();
        String responsestring = response.asString();
        System.out.println(responsestring);

        ValidatableResponse validate = response.then();
        validate.statusCode(201);
    }
}
