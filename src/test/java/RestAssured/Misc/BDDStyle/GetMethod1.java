package RestAssured.Misc.BDDStyle;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class GetMethod1 {
    @Test (groups = {"Positive"}, priority = 2) //Using Groups and Priority
    public void getRequest_Positive()
    {
                 given().baseUri("https://simple-books-api.glitch.me")
                .when().get()
                .then().log().all().statusCode(200);
    }
    @Test (groups = {"Negative"},priority = 1)
    public void getRequest_Negative()
    {
                 given().baseUri("https://simple-books-api.glitch.me")
                .when().get()
                .then().log().all().statusCode(201);
    }
}
