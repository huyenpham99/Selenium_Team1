package assignment03;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Listener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println(result.getName()+" is SUCCESSFUL");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println(result.getName()+" is FAILED");

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
