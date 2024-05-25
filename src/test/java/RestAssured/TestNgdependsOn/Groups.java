package RestAssured.TestNgdependsOn;

import org.testng.annotations.Test;

public class Groups {

    @Test(groups = {"priority"})
    public void FirstRun()
    {
        System.out.println("Hi First");
    }

    @Test(groups = {"priority"})
    public void SecondRun()
    {
        System.out.println("Hi Second");
    }

    @Test(dependsOnGroups = { "priority.*" })
    public void method1()
    {
        System.out.println("I will run Last");
    }
}
