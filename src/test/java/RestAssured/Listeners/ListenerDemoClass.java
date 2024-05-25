package RestAssured.Listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener2.class)
//@Listeners(CustomListener1.class)
public class ListenerDemoClass {
    @Test (groups = "init")
    public void test1(){
        System.out.println("test1");
        Assert.assertTrue(false);
    }
    @Test (groups = "init")
    public void test2(){
        System.out.println("test2");
        Assert.assertTrue(true);
    }
}
