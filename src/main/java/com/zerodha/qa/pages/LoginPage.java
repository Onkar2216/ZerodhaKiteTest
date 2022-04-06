package com.zerodha.qa.pages;
import com.zerodha.qa.base.testBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends testBase
{
    @FindBy(xpath = "//img[@alt='Kite']") WebElement Logo;
    @CacheLookup @FindBy(id = "userid") WebElement UserName;
    @CacheLookup @FindBy(id = "password") WebElement Password;
    @CacheLookup @FindBy(xpath = "//button[text()='Login ']") WebElement LoginButton;
    @FindBy(linkText = "Forgot user ID or password?") WebElement ForgetLink;
    @FindBy(id = "pin") WebElement PinCode;
    @FindBy(xpath = "//button[text()='Continue ']") WebElement ContinueButton;

    public LoginPage()
    {
        PageFactory.initElements(driver,this);
    }

    public String getLoginPageTitle()
    {
        return driver.getTitle();
    }

    public boolean validateLoginPageLogo()
    {
        return Logo.isDisplayed();
    }

    public DashBoardPage login(String un, String pwd,String pin)
    {
        UserName.sendKeys(un);
        Password.sendKeys(pwd);
        LoginButton.click();
        PinCode.sendKeys(pin);
        ContinueButton.click();
        return new DashBoardPage();
    }
    public ForgetPasswordPage ForgetPasswordLink()
    {
        ForgetLink.click();
        return  new ForgetPasswordPage();
    }
}
