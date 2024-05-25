package RestAssured.JacksonApi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Ser {
    public static void main(String[] args) throws JsonProcessingException {
// Converting JavaObject into Json - Serialization Method

        Employee employeeobject = new Employee();
        employeeobject.setFirstName("Thatha");
        employeeobject.setLastName("Nair");
        employeeobject.setGender("Female");
        employeeobject.setAge("43");
        employeeobject.setSalary("1000");
        employeeobject.setMarried("true");

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeeobject);
        System.out.println(jsonString);


    }
}
