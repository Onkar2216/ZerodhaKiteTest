package com.zerodha.qa.testCases;

import com.zerodha.qa.base.testBase;
import com.zerodha.qa.pages.DashBoardPage;
import com.zerodha.qa.pages.ForgetPasswordPage;
import com.zerodha.qa.pages.LoginPage;
import com.zerodha.qa.reports.CustomizeListener;
import com.zerodha.qa.util.TestUtils;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.ArrayList;
import java.util.Iterator;

@Listeners(CustomizeListener.class)
public class LoginPageTest extends testBase
{
    LoginPage loginPage;
    DashBoardPage dashboard;
    ForgetPasswordPage forgetPasswordLink;
    TestUtils testUtils;

    @BeforeMethod
    public void setup()
    {
        initialize();
        testUtils = new TestUtils();
        loginPage=new LoginPage();
    }

    @Test(retryAnalyzer = com.zerodha.qa.reports.RetryAnalyser.class)
    public void validateLogo()
    {
        Boolean flag=loginPage.validateLoginPageLogo();
        Assert.assertTrue(flag);
    }

    @Test
    public void validateTitle()
    {
        String title=loginPage.getLoginPageTitle();
        Assert.assertEquals(title,p.getProperty("LoginPageTitle"));
    }

    @DataProvider
    public Iterator<Object[]>  getLoginTestCaseData() // Object[][]
    {
        ArrayList<Object[]> loginTestData=testUtils.getLoginTestData();
        System.out.print("Login Test Case Data >> "+loginTestData);
        Iterator<Object[]> data=loginTestData.iterator();
        return data;
    }

    @Test(dataProvider = "getLoginTestCaseData")
    public void ValidateLogin(String UserID,String Password, String Pin, String status)
    {
        boolean flag=false;
        try
        {
            dashboard = loginPage.login(UserID, Password, Pin);
            testUtils.writeStatusTestCase(UserID,"pass");
            flag=true;
            Assert.assertTrue(flag);
        }catch (Exception e)
        {
            testUtils.writeStatusTestCase(UserID,"fail");
            Assert.assertTrue(flag);
        }
    }

    @Test
    public void ValidateForgetPasswordLink()
    {
        forgetPasswordLink=loginPage.ForgetPasswordLink();
        String currentUrl=driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,p.getProperty("ForgetPassword"));
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
