package com.zerodha.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class testBase
{
    public static WebDriver driver;
    public static Properties p;

    public testBase()
    {
        try
        {
            p=new Properties();
            FileInputStream fp=new FileInputStream("src/main/java/com/zerodha/qa/configurations/config.properties");
            p.load(fp);
        }catch (Exception e)
        {
            System.out.print(e);
        }
    }

    public static void initialize()
    {
        String browser=p.getProperty("browser");
        if (browser.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "D:/Software/Java Softwares/Testing/Browsers Driver/Chrome/chromedriver.exe"); // To Set Property
            driver=new ChromeDriver();
        }
        else if (browser.equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", "D:/Software/Java Softwares/Testing/Browsers Driver/FireFox/geckodriver.exe");
            driver=new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("url"));
    }
}
