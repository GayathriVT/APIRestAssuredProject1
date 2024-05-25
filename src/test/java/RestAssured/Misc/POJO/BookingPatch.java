package RestAssured.Misc.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookingPatch {

    //Payload getting using JsonSchema2PoJo using GSON

        @SerializedName("firstname")
        @Expose
        private String firstname;
        @SerializedName("lastname")
        @Expose
        private String lastname;

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

    }

