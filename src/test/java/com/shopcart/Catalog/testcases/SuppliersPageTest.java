package com.shopcart.Catalog.testcases;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shopcart.Catalog.Pages.CategoriesPage;
import com.shopcart.Catalog.Pages.ManufacturerPage;
import com.shopcart.Catalog.Pages.ProductAttributesPages;
import com.shopcart.Catalog.Pages.ProductsPage;
import com.shopcart.Catalog.Pages.SuppliersPage;
import com.shopcart.Localization.pages.LocalizationPage;
import com.shopcart.Util.Xls_Reader;
import com.shopcart.base.TestBase;
import com.shopcart.dashboard.pages.DashboardPage;
import com.shopcart.login.LoginPage;

public class SuppliersPageTest  extends TestBase{

	public SuppliersPageTest() throws FileNotFoundException {
		super();
		
	}
	
	LoginPage loginpage;
	   DashboardPage dashboardpage;
	   LocalizationPage localizationpage;
	   ProductsPage productsPage;
	   CategoriesPage categoriesPage;
	   ProductAttributesPages productAttributePage;
	   ManufacturerPage manufacturerPage;
	   SuppliersPage suppliersPage;
		
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
			suppliersPage=dashboardpage.clickOnSuppliersLink();
		}
		@Test
		public void verifyPageTitleTest()
		{
			String title=driver.getTitle();
			System.out.println("title is "+title);
			String excepted="Suppliers • SHOPCART";
			Assert.assertEquals(title, excepted);
		}
		@Test
		public void verifyAddnewSupplierTest() throws Exception
		{
			suppliersPage.verifyAddNewSupplier();
			
		}
		
		@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}
	

}
