package RestAssured.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener2 implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started");
    }
    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test case Start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test case Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test case Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test case Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
