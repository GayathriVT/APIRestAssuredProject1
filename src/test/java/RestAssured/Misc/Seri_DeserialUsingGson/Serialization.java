package RestAssured.Misc.Seri_DeserialUsingGson;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import RestAssured.Misc.POJO.Booking;
import RestAssured.Misc.POJO.Bookingdates;

public class Serialization {
    public static void main(String[] args) {
        // Converting Java Objcet to Jason  using GSon Library

        Booking booking = new Booking();
        booking.setFirstname("Loki");
        booking.setLastname("Sinha");
        booking.setTotalprice(500);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("Lunch");

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2019-01-01");

// to merge booking and bookingdates
        booking.setBookingdates(bookingdates);

        // Converting Java Objcet to Jason  using GSon Library
        Gson gson = new Gson();
        String bookingStringPayload = gson.toJson(booking);
        System.out.println(bookingStringPayload);

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .contentType(ContentType.JSON)
                .when().body(bookingStringPayload).post()
                .then().log().all().statusCode(200);
    }
}
