package RestAssured.Misc.Seri_DeserialUsingGson;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import RestAssured.Misc.POJO.Booking;
import RestAssured.Misc.POJO.Bookingdates;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SerDeser {

    Gson gson = new Gson();
@Test
    public void postRequest() {
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

    // Converting Java Object to Json  using GSon Library
// Serialization
    String bookingStringPayload = gson.toJson(booking);
    System.out.println(bookingStringPayload);
// Using NON BDD style to retrieve response
    RequestSpecification r = RestAssured.given();
    r.baseUri("https://restful-booker.herokuapp.com");
    r.basePath("/booking");
    r.contentType(ContentType.JSON);

    Response response = r.when().body(bookingStringPayload).post();
    ValidatableResponse vr = response.then().log().all().statusCode(200);
    String responsestring = response.asString();
    System.out.println(responsestring);


    // Converting Json to Java Object using Gson Library
    // Deserialization
    BookingResponse bookingResponse = gson.fromJson(responsestring,BookingResponse.class);
    System.out.println(bookingResponse.getBookingid());
    System.out.println(bookingResponse.getBooking().getFirstname());

    // Response Validations

    Assert.assertEquals(bookingResponse.getBooking().getFirstname(), "Loki");
    Assert.assertEquals(bookingResponse.getBooking().getLastname(),"Sinha");

}
}


