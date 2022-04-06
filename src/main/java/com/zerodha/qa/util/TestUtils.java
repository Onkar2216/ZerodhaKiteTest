package com.zerodha.qa.util;

import com.zerodha.qa.base.testBase;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;

public class TestUtils extends testBase {

    public ArrayList<Object[]> getLoginTestData() {
        ArrayList<Object[]> LoginData = new ArrayList<>();
        try {
            FileInputStream ip = new FileInputStream(p.getProperty("FilePath"));
            XSSFWorkbook workbook = new XSSFWorkbook(ip);
            XSSFSheet sheet = workbook.getSheet(p.getProperty("SheetName"));
            int lastRow = sheet.getLastRowNum();
            for (int i = 1; i <= lastRow; i++)
            {
                XSSFRow row = sheet.getRow(i);
                int lastCell = row.getLastCellNum();
                Object[] objects = new Object[lastCell];
                for (int j = 0; j < lastCell; j++)
                {
                    XSSFCell cell = row.getCell(j);
                    String data = cell.getStringCellValue();
                    objects[j] = data;
                }
                LoginData.add(objects);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.print("LoginData TestData >> " + LoginData);
        return LoginData;
    }

    public void writeStatusTestCase(String userID, String status)
    {
        try
        {
            FileInputStream fis=new FileInputStream(p.getProperty("FilePath"));
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(p.getProperty("SheetName"));
            int lastRow = sheet.getLastRowNum();
            for (int i = 1; i <= lastRow; i++)
            {
                XSSFRow row = sheet.getRow(i);
                int lastCell = row.getLastCellNum();
                for (int j = 0; j < lastCell; j++)
                {
                    XSSFCell cell = row.getCell(j);
                    String data = cell.getStringCellValue();
                    if (userID.equals(data))
                    {
                        cell=row.createCell(3,CellType.STRING);
                        cell.setCellValue(status);
                    }
                }
                FileOutputStream fos = new FileOutputStream(p.getProperty("FilePath"));
                workbook.write(fos);
                fos.close();
                fis.close();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void wait(WebDriver driver, WebElement element,long sec)
    {
        new WebDriverWait(driver, Duration.ofSeconds(sec))
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void takeScreenShot(String methodName){
        File file=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        System.out.println("I am in TakeScreenshot Method date is >> "+methodName);
        try {
            FileUtils.copyFile(file,new File("Screenshot/"+methodName+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
