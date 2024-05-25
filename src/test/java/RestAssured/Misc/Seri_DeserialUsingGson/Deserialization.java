package RestAssured.Misc.Seri_DeserialUsingGson;

import com.google.gson.Gson;

public class Deserialization {

    public static void main(String[] args) {

        String jsonResponse = "{\n" +
            "    \"bookingid\": 3213,\n" +
            "    \"booking\": {\n" +
            "        \"firstname\": \"Jim\",\n" +
            "        \"lastname\": \"Brown\",\n" +
            "        \"totalprice\": 111,\n" +
            "        \"depositpaid\": true,\n" +
            "        \"bookingdates\": {\n" +
            "            \"checkin\": \"2018-01-01\",\n" +
            "            \"checkout\": \"2019-01-01\"\n" +
            "        },\n" +
            "        \"additionalneeds\": \"Breakfast\"\n" +
            "    }\n" +
            "}";
// Converting Json to Java Object using Gson Library
        Gson gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(jsonResponse,BookingResponse.class);

// To veriy the Response we use Deserialization

        System.out.println(bookingResponse.getBookingid());
        System.out.println(bookingResponse.getBooking().getFirstname());
        System.out.println(bookingResponse.getBooking().getLastname());
        System.out.println(bookingResponse.getBooking().getAdditionalneeds());
        System.out.println(bookingResponse.getBooking().getTotalprice());
        System.out.println(bookingResponse.getBooking().getDepositpaid());

}
}
