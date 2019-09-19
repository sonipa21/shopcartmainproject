package com.shopcart.Catalog.Pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.shopcart.Util.Xls_Reader;
import com.shopcart.base.TestBase;

public class SuppliersPage  extends TestBase{

	public SuppliersPage() throws FileNotFoundException {
		super();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id=\"page-header-desc-supplier-new_supplier\"]/i")
	WebElement addnewSupplier;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement nameW;
	@FindBy(xpath="//input[@id='phone']")
	WebElement phoneW;
	@FindBy(xpath="//input[@id='phone_mobile']")
	WebElement mobilePhone;
	@FindBy(xpath="//input[@id='address']")
	WebElement addressW;
	@FindBy(xpath="//input[@id='address2']")
	WebElement address2W;
	@FindBy(xpath="//input[@id='postcode']")
	WebElement postalcode;
	@FindBy(xpath="//input[@id='city']")
	WebElement cityW;
	@FindBy(xpath="//*[@id=\"id_country\"]")
	WebElement countrydropdown;
	@FindBy(xpath="//input[@id='active_on']")
	WebElement enableBtn;
	@FindBy(xpath="//*[@id=\"supplier_form_submit_btn\"]")
	WebElement saveBtn;
	
	public void verifyAddNewSupplier() throws Exception
	{
		addnewSupplier.click();
		Xls_Reader reader=new Xls_Reader("C:\\JBK Eclipse Configured 32-bit\\ShopKartProject-master\\ShopKartProject-master\\ShopCartAdmin123\\PrestaShop.xlsx");
		String name=reader.getCellData("Sheet2", "name", 2);
		System.out.println(name);
		String phone=reader.getCellData("Sheet2", "phone", 2);
		System.out.println(phone);
		String mobilephone=reader.getCellData("Sheet2", "mobilephone", 2);
		System.out.println(mobilephone);
		String Address=reader.getCellData("Sheet1", "Address", 2);
		System.out.println(Address);
		String Address2=reader.getCellData("Sheet1", "Address2", 2);
		System.out.println(Address2);
		String zipcode=reader.getCellData("Sheet1", "zipcode", 2);
		System.out.println(zipcode);
		String city=reader.getCellData("Sheet1", "city", 2);
		System.out.println(city);
		nameW.sendKeys(name);
		Thread.sleep(2000);
		phoneW.sendKeys(phone);
		mobilePhone.sendKeys(mobilephone);
		addressW.sendKeys(Address);
		address2W.sendKeys(Address2);
		postalcode.sendKeys(zipcode);
		cityW.sendKeys(city);
		Select s=new Select(countrydropdown);
		s.selectByValue("110");
		saveBtn.click();
		
		
	}

}
