package RestAssured.Misc.POJO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class PostRequest_payloadUsingPojo {
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

    }
}
