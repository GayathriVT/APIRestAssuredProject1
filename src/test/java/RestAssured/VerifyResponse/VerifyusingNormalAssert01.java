package RestAssured.VerifyResponse;

import org.testng.Assert;

public class VerifyusingNormalAssert01 {
    public static void main(String[] args) {
        String responseName = "GVT";
        Assert.assertEquals("GVT",responseName);
        Assert.assertTrue(true);
    }
}
