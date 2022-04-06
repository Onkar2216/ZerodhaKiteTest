package com.zerodha.qa.pages;

import com.zerodha.qa.base.testBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage extends testBase
{
    @FindBy(xpath = "//span[@class='user-id']") WebElement userID;
    @FindBy(xpath = "//span[@class='nickname']") WebElement userNameLabel;
    @FindBy(xpath = "//a//span[text()='Orders']") WebElement orderLink;
    @FindBy(xpath = "//a//span[text()='Holdings']") WebElement holdingsLink;
    @FindBy(xpath = "//a//span[text()='Positions']") WebElement positionsLink;
    @FindBy(xpath = "//a//span[text()='Funds']") WebElement fundsLink;
    @FindBy(xpath = "//a//span[text()='Apps']") WebElement appLink;
    @FindBy(xpath = "//a[@class='dropdown-label']") WebElement profileButton;
    @FindBy(xpath = "//a[contains(text(),' My profile ')]") WebElement profileLink;

    public DashBoardPage()
    {
        PageFactory.initElements(driver,this);
    }
    public String getDashboardPageTitle()
    {
        return driver.getTitle();
    }
    public String verifyUserId()
    {
        return userID.getText();
    }
    public String verifyUserName()
    {
        return  userNameLabel.getText();
    }
    public OrderPage verifyOrderLink()
    {
        orderLink.click();
        return new OrderPage();
    }
    public  HoldingsPage verifyHoldingsLink()
    {
        holdingsLink.click();
        return new HoldingsPage();
    }
    public PositionsPage verifyPositionLink()
    {
        positionsLink.click();
        return new PositionsPage();
    }
    public FundsPage verifyFundsLink()
    {
        fundsLink.click();
        return new FundsPage();
    }
    public AppsPage verifyAppsLink()
    {
        appLink.click();
        return new AppsPage();
    }
    public ProfilePage verifyProfileLink()
    {
        profileButton.click();
        profileLink.click();
        return new ProfilePage();
    }
}
