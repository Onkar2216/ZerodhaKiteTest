package com.zerodha.qa.reports;

import org.testng.ITestListener;
import org.testng.ITestResult;
import static com.zerodha.qa.util.TestUtils.takeScreenShot;

public class CustomizeListener implements ITestListener
{
    @Override
    public void onTestFailure(ITestResult result)
    {
        System.out.println("I am in Test Fail Listener method..");
        Object[] obj=result.getParameters();
        if (obj.length > 0 )
        {
            String id = (String) obj[0];
            String name = result.getMethod().getMethodName() + "_" + id;
            takeScreenShot(name);
        }
        else
            takeScreenShot(result.getMethod().getMethodName());
    }
}
