package RestAssured.Misc.HashMapMethod;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import java.util.LinkedHashMap;
import java.util.Map;

public class PostRequest_payloadusingHashMap_class {
    @Test
    public void getPayload() {
       /* {
                "firstname" : "Jim",
                "lastname" : "Brown",
                "totalprice" : 111,
                "depositpaid" : true,
                "bookingdates" : {
                                    "checkin" : "2018-01-01",
                                     "checkout" : "2019-01-01"
        },
            "additionalneeds" : "Breakfast"
        } */

        // Payload converting from above String to HashMap using class and object
        Map<String,Object> jsonbodyUsingMap = new LinkedHashMap();
        jsonbodyUsingMap.put("firstname","GVT");
        jsonbodyUsingMap.put("lastname","VT");
        jsonbodyUsingMap.put("totalprice","500");
        jsonbodyUsingMap.put("depositpaid","true");
        jsonbodyUsingMap.put("additionalneeds","Dinner");

        Map<String,Object> bookingdatesmap = new LinkedHashMap();
        bookingdatesmap.put("checkin","2018-01-01");
        bookingdatesmap.put("checkout","2019-01-01");

        jsonbodyUsingMap.put("bookingdates",bookingdatesmap);
        System.out.println(jsonbodyUsingMap);

        //create booking using Post method
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .contentType(ContentType.JSON)
                .when().body(jsonbodyUsingMap).post()
                .then().log().all().statusCode(200);

    }
    }

