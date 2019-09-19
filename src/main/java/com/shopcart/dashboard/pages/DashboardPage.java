package com.shopcart.dashboard.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopcart.Catalog.Pages.CategoriesPage;
import com.shopcart.Catalog.Pages.ManufacturerPage;
import com.shopcart.Catalog.Pages.ProductAttributesPages;
import com.shopcart.Catalog.Pages.ProductsPage;
import com.shopcart.Catalog.Pages.SuppliersPage;
import com.shopcart.Catalog.Pages.TagsPage;
import com.shopcart.Localization.pages.LanguagesPage;
import com.shopcart.Localization.pages.LocalizationPage;
import com.shopcart.Orders.Pages.InvoicesPae;
import com.shopcart.Orders.Pages.OrdersPage;
import com.shopcart.base.TestBase;

public class DashboardPage extends TestBase{
	
	LocalizationPage localizationPage;
	LanguagesPage languagesPage;
	ProductsPage productsPage;

	public DashboardPage() throws FileNotFoundException {
		super();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//i[@class='process-icon-toggle-on']")
	WebElement iconbtn;
	
	@FindBy(xpath="//h2[contains(text(),'Dashboard')]")
	WebElement pageTitle;
	
	@FindBy(xpath="//i[@class='process-icon-help']")
	WebElement helpBtn;
	
	@FindBy(xpath="//*[@id=\"orders_notif\"]/a/i")
	WebElement ShoppingCartIcon;
	
	@FindBy(xpath="//*[@id=\"maintab-AdminParentLocalization\"]/a/span")
	WebElement localizationBtn;
	
	@FindBy(xpath="//*[@id=\"subtab-AdminLanguages\"]/a")
	WebElement languagesLink;
	
	@FindBy(xpath="//*[@id=\"maintab-AdminParentLocalization\"]/a")
	WebElement specificLocalizationBtn;
	
	@FindBy(xpath="//*[@id=\"maintab-AdminCatalog\"]/a")
	WebElement catalogLink;
	
	@FindBy(xpath="//*[@id=\"subtab-AdminProducts\"]/a")
	WebElement productsLink;
	
	@FindBy(xpath="//*[@id=\"subtab-AdminCategories\"]/a")
	WebElement categoriesLink;
	
	@FindBy(xpath="//*[@id=\"subtab-AdminAttributesGroups\"]/a")
	WebElement productAttributesLink;
	
	@FindBy(xpath="//*[@id=\"subtab-AdminManufacturers\"]/a")
	WebElement manufacturerLink;
	
	@FindBy(xpath="//*[@id=\"subtab-AdminSuppliers\"]")
	WebElement suppliersLink;
	@FindBy(xpath="//*[@id=\"subtab-AdminTags\"]/a")
	WebElement tagsLink;
	
	@FindBy(xpath="//*[@id=\"maintab-AdminParentOrders\"]/a")
	WebElement ordersSpecific;
	
	@FindBy(xpath="//*[@id=\"subtab-AdminOrders\"]/a")
	WebElement ordersLink;
	
	@FindBy(xpath="//*[@id=\"datepickerExpand\"]")
	WebElement datepicker;
	@FindBy(xpath="//*[@id=\"datepicker\"]/div/div/div/div[1]/div/div/div[1]/table/thead/tr[1]/th[2]")
	WebElement yeearBttn;
	
	
	@FindBy(xpath="//*[@id=\"subtab-AdminInvoices\"]/a")
	WebElement invoicesLink;
	
	
	public boolean verifypageTitleLabel()
	{
		return pageTitle.isDisplayed();
	}
	
	public void verifyIconBtn() throws InterruptedException
	{
		Actions act=new Actions(driver);
		WebElement ele=driver.findElement(By.cssSelector("#page-header-desc-configuration-switch_demo > i"));
		act.moveToElement(ele);
		Thread.sleep(2000);
		act.click(ele).build().perform();
		
	}
	
	public void verifyhelpBtn()
	{
		helpBtn.click();
	}
	public void verifyShoppingCartIcon()
	{
	   	ShoppingCartIcon.click();
	}
	
	public LocalizationPage clickonLocalization() throws Exception
	{
		Actions act=new Actions(driver);
		act.moveToElement(localizationBtn);
		act.click(localizationBtn).build().perform();
		return new LocalizationPage();
		
	}
	
	public LanguagesPage clickOnLanguages() throws FileNotFoundException
	{
		Actions act=new Actions(driver);
		act.moveToElement(specificLocalizationBtn);
		act.click(languagesLink).build().perform();
		return new LanguagesPage();
	}
	
	public void clickOnSpecificLocalizationBtn()
	{
		specificLocalizationBtn.click();
		
	}
	
	public ProductsPage clickOnProductsPage() throws FileNotFoundException
	{
		Actions act=new Actions(driver);
		act.moveToElement(catalogLink);
		act.click(productsLink).build().perform();
		return new ProductsPage();
		
	}
	public CategoriesPage clickOnCategoriesPage() throws Exception
	{
		Actions act=new Actions(driver);
		act.moveToElement(catalogLink);
		act.click(categoriesLink).build().perform();
		return new CategoriesPage();
	}
	public ProductAttributesPages clickOnProductAttributesPage() throws Exception
	{
		Actions act=new Actions(driver);
		act.moveToElement(catalogLink);
		act.click(productAttributesLink).build().perform();
		return new ProductAttributesPages();
	}
	public ManufacturerPage clickOnManufacturerPage() throws FileNotFoundException
	{
		Actions act=new Actions(driver);
		act.moveToElement(catalogLink);
		act.click(manufacturerLink).build().perform();
		return new ManufacturerPage();
		
	}
	public SuppliersPage clickOnSuppliersLink() throws FileNotFoundException
	{
		Actions act=new Actions(driver);
		act.moveToElement(catalogLink);
		act.click(suppliersLink).build().perform();
		return new SuppliersPage();
	}
	public TagsPage clickOnTagsLinlk() throws Exception
	{
		Actions act=new Actions(driver);
		act.moveToElement(catalogLink);
		act.click(tagsLink).build().perform();
		return new TagsPage();
		
	}
	public OrdersPage clickOnOrdersLink() throws FileNotFoundException
	{
		Actions act=new Actions(driver);
		act.moveToElement(ordersSpecific);
		act.click(ordersLink).build().perform();
		return new OrdersPage();
		
	}
	public InvoicesPae clickOnInvoicesLink() throws FileNotFoundException
	{
		Actions act=new Actions(driver);
		act.moveToElement(ordersSpecific);
		act.click(invoicesLink).build().perform();
		return new InvoicesPae();
		
	}
	public void verifydatePicker()
	{
		datepicker.click();
		Actions act=new Actions(driver);
		act.doubleClick(yeearBttn).build().perform();
		
	}
	public void verifyYear() throws InterruptedException
	{
		String fromyear="2015";
		//*[@id="datepicker"]/div/div/div/div[1]/div/div/div[3]/table/tbody/tr/td/span[1]
		//*[@id="datepicker"]/div/div/div/div[1]/div/div/div[3]/table/tbody/tr/td/span[2]
		//*[@id="datepicker"]/div/div/div/div[1]/div/div/div[3]/table/tbody/tr/td/span[3]
		//*[@id="datepicker"]/div/div/div/div[1]/div/div/div[3]/table/tbody/tr/td/span[4]
		String beforexpath="//*[@id=\"datepicker\"]/div/div/div/div[1]/div/div/div[3]/table/tbody/tr/td/span[";
		String afterxpath="]";
		for(int num=1;num<=12;num++)
		{
			String yearval=driver.findElement(By.xpath(beforexpath+num+afterxpath)).getText();
			System.out.println(yearval);
			if(yearval.equals(fromyear))
			{
				driver.findElement(By.xpath(beforexpath+num+afterxpath)).click();
				
			}
		}
		
		
		
	}
	
	

}
