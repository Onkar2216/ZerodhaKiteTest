package com.zerodha.qa.testCases;

import com.zerodha.qa.base.testBase;
import com.zerodha.qa.pages.DashBoardPage;
import com.zerodha.qa.pages.LoginPage;
import com.zerodha.qa.pages.SearchStockPage;
import com.zerodha.qa.reports.CustomizeListener;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
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
    Logger log = Logger.getLogger(SearchStockPageTest.class);

    @BeforeMethod
    public void setUp()
    {
        log.info("Set Up Process is Started..");
        initialize();
        loginPage=new LoginPage();
        dashBoardPage=loginPage.login(p.getProperty("UserName"),p.getProperty("Password"),p.getProperty("Pin"));
        searchStockPage=new SearchStockPage();
        StockName=searchStockPage.getWebElement(p.getProperty("StockName"));
    }

    @Test
    public void validateStockList()
    {
        log.info("Validate Stocklist..");
        searchStockPage.validateStockList();
    }

    @Test
    public void validateSearchBoxTest()
    {
        log.info("Validating Search Box Textfield");
        searchStockPage.validateSearchBox(p.getProperty("StockName"));
    }

    @Test
    public void validateBuyButtonTest() throws InterruptedException {
        log.info("Validating Buy Button");
        searchStockPage.validateBuyButton(StockName);
        Thread.sleep(3000);
    }

    @Test
    public void validateSellButtonTest() throws InterruptedException {
        log.info("Validating Sell Button");
        searchStockPage.validateSellButton(StockName);
        Thread.sleep(3000);
    }

    @Test
    public void validateMarketDepthButton() throws InterruptedException {
        log.info("Validating Market Depth Button");
        searchStockPage.validateMarketDepthButtoon(StockName);
        Thread.sleep(3000);
    }

    @Test
    public void validateChartButton() throws InterruptedException {
        log.info("Validating Chart Button");
        searchStockPage.validateChartButton(StockName);
        Thread.sleep(3000);
    }

    @Test(enabled = false)
    public void validateDeleteButton() throws InterruptedException {
        log.info("Validating Delete Button");
        searchStockPage.validateDeleteButton(StockName);
        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown()
    {
        log.info("Tear Down Process is started..");
        driver.quit();
    }
}
