package com.shopcart.Orders.TestCases;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shopcart.Orders.Pages.InvoicesPae;
import com.shopcart.Orders.Pages.OrdersPage;
import com.shopcart.base.TestBase;
import com.shopcart.dashboard.pages.DashboardPage;
import com.shopcart.login.LoginPage;

public class InvoicesPageTest extends TestBase
{

	public InvoicesPageTest() throws FileNotFoundException {
		super();
		
	}
	LoginPage loginpage;
	   DashboardPage dashboardpage;
	   OrdersPage ordersPage;
	   InvoicesPae invoicesPage;
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
		invoicesPage=dashboardpage.clickOnInvoicesLink();
			
		}
		
		@Test
		public void verifyPageTitleTest()
		{
			log.info("starting test case");
			String title=driver.getTitle();
			log.info("title is"+title);
			String excepted="Invoices • SHOPCART";
			Assert.assertEquals(title, excepted);
			log.info("ending test case");
		}
		
		@Test
		public void verifyFromDateTest() throws Exception
		{
			invoicesPage.verifyfromDate();
			invoicesPage.toDate();
			invoicesPage.clickOnGenerateBtn();
		}

}
