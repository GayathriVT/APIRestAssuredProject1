package RestAssured.Misc.POJO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class AuthTokenRequest {
    @Test
    public void authRequest()
    {
/* String payload = "{\n" +
        "    \"username\" : \"admin\",\n" +
        "    \"password\" : \"password123\"\n" +
        "}"; */
        AuthPayload auth = new AuthPayload();
        auth.setUsername("admin");
        auth.setPassword("password123");
//to get the Token
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON)
                .when().body(auth).post()
                .then().log().all().statusCode(200);
        System.out.println("Token no is ->");
    }
}
