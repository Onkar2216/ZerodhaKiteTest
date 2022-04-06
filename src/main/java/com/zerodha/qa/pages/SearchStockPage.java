package com.zerodha.qa.pages;

import com.zerodha.qa.base.testBase;
import com.zerodha.qa.util.TestUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class SearchStockPage extends testBase
{
    @FindBy(xpath = "//li[@data-balloon='Watchlist 4']") WebElement watchlistButton;
    @FindBy(xpath = "//input[@icon='search']") WebElement searchStock;
    @FindBy(xpath = "//button[@class='button-blue buy']") WebElement buyButton;
    @FindBy(xpath = "//button[@class='button-orange sell']") WebElement sellButton;
    @FindBy(xpath = "//span[@data-balloon='Market Depth (D)']//button[@class='button-outline']") WebElement marketDepthButton;
    @FindBy(xpath = "//span[@data-balloon='Chart (C)']//button[@class='button-outline']") WebElement chartButton;
    @FindBy(xpath = "//span[@data-balloon='Delete (del)']//button[@class='button-outline']") WebElement deleteStockButton;
    @FindBy(xpath = "//span//span[text()='TATAPOWER']") WebElement tataPowerStock;
    @FindBy(xpath = "//li//span[@class='tradingsymbol']") List<WebElement> searchStockList;
    @FindBy(xpath = "//div[@class='info']//span[@class='nice-name']") List<WebElement> stocklist;

    TestUtils testUtils=new TestUtils();

    public SearchStockPage()
    {
        PageFactory.initElements(driver,this);
    }

    public WebElement getWebElement(String StockName)
    {
        validateWatchList();
        WebElement ele = null;
        for (WebElement element:stocklist)
        {
            if (element.getText().equals(StockName))
                ele=element;
        }
        return ele;
    }
    
    public void validateWatchList()
    {
        watchlistButton.click();
    }

    public void validateStockList()
    {
        validateWatchList();
        for (WebElement element:stocklist)
        {
            System.out.println(element.getText());
        }
    }

    public void validateSearchBox(String StockName) {
        validateWatchList();
        searchStock.sendKeys(p.getProperty("Stock"));
        for (WebElement stock: searchStockList)
        {
            testUtils.wait(driver,stock,10);
            String stk=stock.getText();
            if (stk.equals(StockName))
            {
                stock.click();
                break;
            }
        }
    }
    public BuyStockPage validateBuyButton(WebElement element) throws InterruptedException {
        validateWatchList();
        Actions action=new Actions(driver);
        action.moveToElement(element).build().perform();
        buyButton.click();
        Thread.sleep(5000);
        return new BuyStockPage();
    }
    public SellStockPage validateSellButton(WebElement element) throws InterruptedException {
        validateWatchList();
        Actions action=new Actions(driver);
        action.moveToElement(element).build().perform();
        sellButton.click();
        Thread.sleep(5000);
        return new SellStockPage();
    }
    public void validateMarketDepthButtoon(WebElement element) throws InterruptedException
    {
        validateWatchList();
        Actions action=new Actions(driver);
        action.moveToElement(element).build().perform();
        marketDepthButton.click();
        Thread.sleep(5000);
    }
    public void validateChartButton(WebElement element) throws InterruptedException
    {
        validateWatchList();
        Actions action=new Actions(driver);
        action.moveToElement(element).build().perform();
        chartButton.click();
        Thread.sleep(5000);
    }
    public void validateDeleteButton(WebElement element) throws InterruptedException
    {
        validateWatchList();
        Actions action=new Actions(driver);
        action.moveToElement(element).build().perform();
        deleteStockButton.click();
        Thread.sleep(5000);
    }
}
