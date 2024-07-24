package RestAssured.Misc.BDDStyle;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class PostMethod1_String_RestAssured {
    @Test
    public void PostRequest()
    {
        String payload = "{\n" +
                "   \"clientName\": \"Gayathri\",\n" +
                "   \"clientEmail\": \"gayathrivt.10@gmail.com\"\n" +
                "}";
// To get the Token using Post method and payload using String and BDD style
        RestAssured
                .given()
                .baseUri("https://simple-books-api.glitch.me")
                .basePath("/api-clients")
                .contentType(ContentType.JSON)
                .when().body(payload).post()
                .then().log().all().statusCode(201);
    }

}
