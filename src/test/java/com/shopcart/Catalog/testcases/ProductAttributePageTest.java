package com.shopcart.Catalog.testcases;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shopcart.Catalog.Pages.CategoriesPage;
import com.shopcart.Catalog.Pages.ProductAttributesPages;
import com.shopcart.Catalog.Pages.ProductsPage;
import com.shopcart.Localization.pages.LocalizationPage;
import com.shopcart.base.TestBase;
import com.shopcart.dashboard.pages.DashboardPage;
import com.shopcart.login.LoginPage;

public class ProductAttributePageTest  extends TestBase{

	public ProductAttributePageTest() throws FileNotFoundException {
		super();
		
	}
	
	LoginPage loginpage;
	   DashboardPage dashboardpage;
	   LocalizationPage localizationpage;
	   ProductsPage productsPage;
	   CategoriesPage categoriesPage;
	   ProductAttributesPages productAttributePage;
		
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
			productAttributePage=dashboardpage.clickOnProductAttributesPage();
			
		}
		@Test
		public void verifyPageTitle()
		{
			String title=driver.getTitle();
			System.out.println("title is:"+title);
			String exceptedTitle="Product Attributes > Product Attributes • SHOPCART";
			Assert.assertEquals(title, exceptedTitle);
		}
		@Test
		public void verifyAddNewValueTest()
		{
			productAttributePage.verifyAddNewValue();
		}
		@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}
	

}
