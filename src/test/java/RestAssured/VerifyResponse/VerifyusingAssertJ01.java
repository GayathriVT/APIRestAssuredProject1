package RestAssured.VerifyResponse;

import RestAssured.JacksonApi.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.assertj.core.api.Assertions.*;

public class VerifyusingAssertJ01 {
    public static void main(String[] args) throws JsonProcessingException {
        String jsonString = "{\n" +
                "  \"age\" : \"43\",\n" +
                "  \"salary\" : \"1000\",\n" +
                "  \"gender\" : \"Female\",\n" +
                "  \"married\" : \"true\",\n" +
                "  \"lastName\" : \"Nair\",\n" +
                "  \"firstName\" : \"Thatha\"\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        Employee employee = objectMapper.readValue(jsonString, Employee.class);
        //assertThat is a function provided by AsserJ

        assertThat(employee.getFirstName()).isEqualTo("Thatha").isNotEmpty();
        System.out.println(employee.getFirstName());
        // Second example with assertJ for Normal String Verification
        String responseName = "GVT";
        assertThat(responseName).isNotNull().isEqualTo("GVT").isNotBlank();
        System.out.println(responseName);
    }
    }

