package com.shopcart.dashboard.testcases;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shopcart.base.TestBase;
import com.shopcart.dashboard.pages.DashboardPage;
import com.shopcart.login.LoginPage;

public class DashboardPageTest extends TestBase {

	public DashboardPageTest() throws FileNotFoundException {
		super();
		
	}
	
	LoginPage loginpage;
	   DashboardPage dashboardpage;
		
		@BeforeMethod
		public void setUp() throws Exception
		{
			initialization();
			try {
				loginpage = new LoginPage();
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			dashboardpage = loginpage.Username(prop.getProperty("username"), prop.getProperty("password"));
		}
		
		@Test
		public void verifyPageTitleTest()
		{
			String actualTitle=driver.getTitle();
			System.out.println("title is:"+actualTitle);
			String exceptedTitle="ShopCartt > Administration panel (PrestaShop™)";
			Assert.assertEquals(actualTitle, exceptedTitle);
			System.out.println("******************************");
		}
		@Test
		public void verifypageLabel()
		{
			boolean flag=dashboardpage.verifypageTitleLabel();
			Assert.assertTrue(flag);
			System.out.println("is label displaed..?"+flag);
		}
		@Test
		public void verifyIconBtnTest() throws InterruptedException 
		{
			dashboardpage.verifyIconBtn();
			
		}
		@Test
		public void verifyhelpBtnTest()
		{
			dashboardpage.verifyhelpBtn();
			System.out.println("help button verified");
			
		}
		
		@Test
		public void verifyShoppingCartIcon()
		{
			dashboardpage.verifyShoppingCartIcon();
		}
		
		@Test
		public void verifylocalization() throws Exception
		{
			dashboardpage.clickonLocalization();
		}
		@Test
		public void datePickerTest() throws InterruptedException
		{
			dashboardpage.verifydatePicker();
			dashboardpage.verifyYear();
		}
		/*@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}*/
		
		
}
