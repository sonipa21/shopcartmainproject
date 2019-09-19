package com.shopcart.Orders.TestCases;



import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.shopcart.Orders.Pages.OrdersPage;
import com.shopcart.Util.TestUtil;
import com.shopcart.base.TestBase;
import com.shopcart.dashboard.pages.DashboardPage;

import com.shopcart.login.LoginPage;

public class OrdersPageTest extends TestBase {
	
	public OrdersPageTest() throws FileNotFoundException
	{
		super();
	}
	LoginPage loginpage;
	   DashboardPage dashboardpage;
	   OrdersPage ordersPage;
	   String sheetName="CustomerData";
	   
	   Logger log=Logger.getLogger(OrdersPageTest.class);
		
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
			ordersPage=dashboardpage.clickOnOrdersLink();
			
		}
		@Test
		public void verifypageTitleTest()
		{
			log.info("******Test case started");
			String title=driver.getTitle();
			log.info("title is"+title);
			String excepted="Orders • SHOPCART";
			Assert.assertEquals(title, excepted);
			log.info("***********test case ended*********8");
			
			
		}
		
		@Test
		public void verifyAddNewOrder()
		{
			log.info("click on add new order and then click on add new customer");
		    ordersPage.addNewOrderLink();
		   
		    
		    
		}
		
		@DataProvider
		public Object[][] getPrestaTestData()
		{
			Object[][] data=TestUtil.getTestData(sheetName);
			return data;
			
		}
		@Test(dataProvider="getPrestaTestData")
		public void addNewCustomerDataTest(String firstname,String lastname,String emailaddress,String password)
		{
			ordersPage.addNewOrderLink();
			ordersPage.createNewCustomer(firstname, lastname, emailaddress, password);
		}
		@Test
		public void searchCustomerTest()
		{
			ordersPage.clickOnAddNewOrder();
			ordersPage.serchCustomer();
		}
		/*@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}*/

}
