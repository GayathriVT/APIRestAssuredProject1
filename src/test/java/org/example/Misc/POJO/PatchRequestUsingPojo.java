package org.example.Misc.POJO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostRequestUsingPojo {
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
        Booking booking = new Booking();
        booking.setFirstname("Loki");
        booking.setLastname("Sinha");
        booking.setTotalprice(500);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("Lunch");

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2019-01-01");

        booking.setBookingdates(bookingdates);
        System.out.println(booking);
        System.out.println(booking.getFirstname());
        System.out.println(booking.getLastname());

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .contentType(ContentType.JSON)
                .when().body(booking).post()
                .then().log().all().statusCode(200);



    }

        //create booking using Post method





}
