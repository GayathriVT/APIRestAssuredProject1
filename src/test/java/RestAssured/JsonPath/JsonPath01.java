package RestAssured.JsonPath;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import static org.assertj.core.api.Assertions.*;

public class JsonPath01 {
    public static void main(String[] args) {
        String response = "{\n" +
                "    \"firstName\": \"John\",\n" +
                "    \"lastName\": \"doe\",\n" +
                "    \"age\": 26,\n" +
                "    \"address\": {\n" +
                "        \"streetAddress\": \"naist street\",\n" +
                "        \"city\": \"Nara\",\n" +
                "        \"postalCode\": \"630-0192\"\n" +
                "    },\n" +
                "    \"phoneNumbers\": [\n" +
                "        {\n" +
                "            \"type\": \"iPhone\",\n" +
                "            \"number\": \"0123-4567-8888\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\": \"home\",\n" +
                "            \"number\": \"0123-4567-8910\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        JsonPath jsonPath = JsonPath.from(response);

        // use https://jsonpath.com/ to find the path . Give response there and get the path by specify the field like below with $.<fieldname>
        System.out.println(jsonPath.getString("firstName"));
        System.out.println(jsonPath.getString("phoneNumbers[0].type"));
        System.out.println(jsonPath.getString("phoneNumbers[1].type"));

        //TestNg Assert
        Assert.assertEquals("firstName", ("John"));
        //AssertJ
        assertThat(jsonPath.getString("firstName")).isNotNull().isEqualTo("John").isNotBlank();

    }
}
