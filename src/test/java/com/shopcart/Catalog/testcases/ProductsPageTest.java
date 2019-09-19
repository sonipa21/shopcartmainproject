package com.shopcart.Catalog.testcases;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shopcart.Catalog.Pages.ProductsPage;
import com.shopcart.Localization.pages.LocalizationPage;
import com.shopcart.base.TestBase;
import com.shopcart.dashboard.pages.DashboardPage;
import com.shopcart.login.LoginPage;

public class ProductsPageTest extends TestBase
{

	public ProductsPageTest() throws FileNotFoundException {
		super();
		
	}
	LoginPage loginpage;
	   DashboardPage dashboardpage;
	   LocalizationPage localizationpage;
	   ProductsPage productsPage;
		
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
			productsPage=dashboardpage.clickOnProductsPage();
		}
		
		@Test
		public void verifyPageTitle()
		{
			String actualTitle=driver.getTitle();
			System.out.println("title is:"+actualTitle);
			String exceptedTitle="Products • SHOPCART";
			Assert.assertEquals(actualTitle, exceptedTitle);
			System.out.println("**********************");
					
		}
		@Test
		public void verifyOneOfTheItemTest()
		{
			productsPage.verifyBouseItem();
		}
		
		@Test
		public void verifyAddNewProductTest() throws Exception
		{
			productsPage.verifyAddNewProduct();
		}
		
		@Test
		public void verifyPriceTabTest() 
		{
			productsPage.verifyBouseItem();
			productsPage.verifypricesTab();
		}
		
		@Test
		public void verifyAssociationTabTest()
		{
			productsPage.verifyBouseItem();
			productsPage.verifyAssociationsTab();
			
			
		}
		
		@Test
		public void verifyImagesTabTest() throws Exception
		{
			productsPage.verifyBouseItem();
			productsPage.verifyImagesTab();
		}
		
		@Test
		public void verifyDeleteProductest()
		{
			productsPage.verifyDeleteProduct();
		}
		@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}

}
