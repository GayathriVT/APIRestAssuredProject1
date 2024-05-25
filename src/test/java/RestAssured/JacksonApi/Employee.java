package RestAssured.JacksonApi;

public class Employee {
    private String FirstName;
    private String LastName;
    private String Gender;
    private String age;
    private String Salary;
    private String Married;


    //Right Click and take generate and select constructor with no selection

    public Employee() {
    }
    //Getter Setter Method

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }

    public String getMarried() {
        return Married;
    }

    public void setMarried(String married) {
        Married = married;
    }
}