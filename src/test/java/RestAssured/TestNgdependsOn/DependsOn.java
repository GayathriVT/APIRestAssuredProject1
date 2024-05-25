package RestAssured.TestNgdependsOn;

import org.testng.annotations.Test;

public class DependsOn {

    @Test(dependsOnMethods = {"method1"})

    public void Serverfirst(){
        System.out.println("Run 1 st");
    }
    @Test
    public void method1()
    {
        System.out.println("Run 2 nd");
    }

}
