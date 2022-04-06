package com.zerodha.qa.testCases;

import com.zerodha.qa.base.testBase;
import com.zerodha.qa.pages.*;
import com.zerodha.qa.reports.CustomizeListener;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(CustomizeListener.class)
public class DashBoardPageTest extends testBase
{
    LoginPage loginPage;
    DashBoardPage dashBoardPage;
    OrderPage orderPage;
    HoldingsPage holdingsPage;
    FundsPage fundsPage;
    AppsPage appsPage;
    PositionsPage positionsPage;
    ProfilePage profilePage;

    @BeforeMethod
    public void setUp()
    {
        initialize();
        loginPage=new LoginPage();
        dashBoardPage=loginPage.login(p.getProperty("UserName"),p.getProperty("Password"),p.getProperty("Pin"));
    }
    @Test(priority = 1)
    public void validateTitleTest()
    {
        String pageTitle=dashBoardPage.getDashboardPageTitle();
        Assert.assertEquals(pageTitle,p.getProperty("DashboardPageTitle"));
    }
    @Test(priority = 2)
    @Parameters({"UserName"})
    public void validateUserNameTest(String UserName)
    {
        String userName=dashBoardPage.verifyUserName();
        Assert.assertEquals(userName,UserName);
    }
    @Test(groups = "dashboard")
    public void validateUserIdTest()
    {
        String userId=dashBoardPage.verifyUserId();
        Assert.assertEquals(userId,p.getProperty("UserName"));
    }
    @Test(groups = "dashboard")
    public void validateOrderLinkTest()
    {
        orderPage=dashBoardPage.verifyOrderLink();
        String orderLink=driver.getCurrentUrl();
        Assert.assertEquals(orderLink,p.getProperty("Orders"));
    }
    @Test(groups = "dashboard")
    public void validatePositionsLinkTest()
    {
        positionsPage=dashBoardPage.verifyPositionLink();
        String positionLink=driver.getCurrentUrl();
        Assert.assertEquals(positionLink,p.getProperty("Positions"));
    }
    @Test
    public void validateHoldingsLinkTest()
    {
        holdingsPage=dashBoardPage.verifyHoldingsLink();
        String holdingsLink=driver.getCurrentUrl();
        Assert.assertEquals(holdingsLink,p.getProperty("Holdings"));
    }
    @Test
    public void validateFundsLinkTest()
    {
        fundsPage=dashBoardPage.verifyFundsLink();
        String fundsLink=driver.getCurrentUrl();
        Assert.assertEquals(fundsLink, p.getProperty("Funds"));
    }
    @Test
    public void validateAppsLinkTest()
    {
        appsPage=dashBoardPage.verifyAppsLink();
        String appsLink=driver.getCurrentUrl();
        Assert.assertEquals(appsLink,p.getProperty("Apps"));
    }
    @Test
    public void validateProfileLinkTest()
    {
        profilePage=dashBoardPage.verifyProfileLink();
        String profileLink=driver.getCurrentUrl();
        Assert.assertEquals(profileLink,p.getProperty("Profile"));
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
