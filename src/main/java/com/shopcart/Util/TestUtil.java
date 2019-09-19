package com.shopcart.Util;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.shopcart.base.TestBase;

public class TestUtil extends TestBase {

	public TestUtil() throws FileNotFoundException {
		super();
		
	}
	public static String TESTDATA_SHEET_PATH="C:\\JBK Eclipse Configured 32-bit\\ShopKartProject-master\\ShopKartProject-master\\ShopCartAdmin123\\PrestaShop.xlsx";
	static Workbook book;
	static  Sheet sheet;
	public static Object[][] getTestData(String SheetName)
	{
		FileInputStream file=null;
		try {
			file=new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try
		{
		book=WorkbookFactory.create(file);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		sheet=book.getSheet(SheetName);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
			{
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
		
		return data;
		
	}
	
	

}
