package RestAssured.JacksonApi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Deser {
    public static void main(String[] args) throws JsonProcessingException {
        //Converting Json to JavaObject
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
        System.out.println(employee.getFirstName());
    }
}
