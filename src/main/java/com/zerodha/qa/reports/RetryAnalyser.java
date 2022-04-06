package com.zerodha.qa.reports;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer
{
    int count=0, retryLimit=3;
    @Override
    public boolean retry(ITestResult result)
    {
        if(count < retryLimit)
        {
            count++;
            return true;
        }
        return false;
    }
}
