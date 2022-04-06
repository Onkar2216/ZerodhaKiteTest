package com.zerodha.qa.testCases;

import com.zerodha.qa.base.testBase;
import com.zerodha.qa.pages.DashBoardPage;
import com.zerodha.qa.pages.LoginPage;
import com.zerodha.qa.pages.SearchStockPage;
import com.zerodha.qa.reports.CustomizeListener;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomizeListener.class)
public class SearchStockPageTest extends testBase
{
    LoginPage loginPage;
    DashBoardPage dashBoardPage;
    SearchStockPage searchStockPage;
    WebElement StockName;

    @BeforeMethod
    public void setUp()
    {
        initialize();
        loginPage=new LoginPage();
        dashBoardPage=loginPage.login(p.getProperty("UserName"),p.getProperty("Password"),p.getProperty("Pin"));
        searchStockPage=new SearchStockPage();
        StockName=searchStockPage.getWebElement(p.getProperty("StockName"));
    }

    @Test
    public void validateStockList()
    {
        Reporter.log("Validating StockLIst");
        searchStockPage.validateStockList();
    }

    @Test
    public void validateSearchBoxTest()
    {
        Reporter.log("Validating Search Box Textfield");
        searchStockPage.validateSearchBox(p.getProperty("StockName"));
    }

    @Test
    public void validateBuyButtonTest() throws InterruptedException {
        Reporter.log("Validating Buy Button");
        searchStockPage.validateBuyButton(StockName);
        Thread.sleep(3000);
    }

    @Test
    public void validateSellButtonTest() throws InterruptedException {
        Reporter.log("Validating Sell Button");
        searchStockPage.validateSellButton(StockName);
        Thread.sleep(3000);
    }

    @Test
    public void validateMarketDepthButton() throws InterruptedException {
        Reporter.log("Validating Market Depth Button");
        searchStockPage.validateMarketDepthButtoon(StockName);
        Thread.sleep(3000);
    }

    @Test
    public void validateChartButton() throws InterruptedException {
        Reporter.log("Validating Chart Button");
        searchStockPage.validateChartButton(StockName);
        Thread.sleep(3000);
    }

    @Test(enabled = false)
    public void validateDeleteButton() throws InterruptedException {
        Reporter.log("Validating Delete Button");
        searchStockPage.validateDeleteButton(StockName);
        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
