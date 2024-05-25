package RestAssured.Misc.POJO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class PatchRequest_payloadUsingPojo {
    @Test
    public void getPatchRequest()
    {
        AuthPayload auth = new AuthPayload();
        auth.setUsername("admin");
        auth.setPassword("password123");

        RestAssured
                .given().baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON)
                .when().body(auth).post()
                .then().log().all().statusCode(200);

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

        System.out.println("Booking details are -> " +booking);
        System.out.println(booking.getFirstname());
        System.out.println(booking.getLastname());
        System.out.println(bookingdates);

//create booking using Post method
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .contentType(ContentType.JSON)
                .when().body(booking).post()
                .then().log().all().statusCode(200);

        BookingPatch bookingpatch = new BookingPatch();
        bookingpatch.setFirstname("MiaMOL");
        bookingpatch.setLastname("Menon");

        System.out.println("Booking details are -> " +bookingpatch);
        System.out.println(bookingpatch.getFirstname());
        System.out.println(bookingpatch.getLastname());

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/1")
                .contentType(ContentType.JSON)
                .cookie("abc123")
                .when().body(booking).patch()
                .then().log().all().statusCode(200) ;

        System.out.println("Booking details are -> " +booking);

     }

}