package RestAssured.VerifyResponse;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class AssertJ02 {
    @Test
    public void asserj() {

        String responseName = "GVT";
        assertThat(responseName).isNotNull().isEqualTo("GVT").isNotBlank();
        System.out.println(responseName);

        Integer bookId = 123;
        assertThat(bookId).isNotNegative().isNotNull().isGreaterThan(0);
        System.out.println(bookId);


    }
}