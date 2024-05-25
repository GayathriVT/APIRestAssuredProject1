package RestAssured.JsonSchemaValidation;

import com.github.fge.jsonschema.main.JsonValidator;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.io.File;

public class JSV1 {
    @Test
    public void JsonSchema()
    {
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .when().get().then()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/RestAssured/JsonSchemaValidation/Schema.json")));
    }
}
