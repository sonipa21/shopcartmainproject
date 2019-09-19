package com.shopcart.Catalog.Pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.shopcart.Util.Xls_Reader;
import com.shopcart.base.TestBase;

public class ManufacturerPage extends TestBase{

	public ManufacturerPage() throws FileNotFoundException {
		super();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id=\"page-header-desc-address-new_manufacturer_address\"]/i")
	WebElement addnewManufacturerAddress;
	@FindBy(xpath="//input[@id='lastname']")
	WebElement lastName;
	@FindBy(xpath="//input[@id='firstname']")
	WebElement firstName;
	@FindBy(xpath="//input[@id='address1']")
	WebElement address;
    @FindBy(xpath="//input[@id='address2']")
    WebElement address2;
    @FindBy(xpath="//input[@id='postcode']")
    WebElement zipCode;
    @FindBy(xpath="//input[@id='city']")
    WebElement cityW;
    @FindBy(xpath="//select[@id='id_country']")
    WebElement dropdown;
    @FindBy(xpath="//input[@id='phone']")
    WebElement homePhoneW;
    @FindBy(xpath="//input[@id='phone_mobile']")
    WebElement mobiilePhone;
    @FindBy(xpath="//*[@id=\"other\"]")
    WebElement otherW;
    @FindBy(xpath="//*[@id=\"address_form_submit_btn\"]")
    WebElement saveBtn;
	
	public void verifyAddNewManufacturer()
	{
		addnewManufacturerAddress.click();
		Xls_Reader reader=new Xls_Reader("C:\\JBK Eclipse Configured 32-bit\\ShopKartProject-master\\ShopKartProject-master\\ShopCartAdmin123\\PrestaShop.xlsx");
		String lastname=reader.getCellData("Sheet1", "lastname", 2);
		System.out.println(lastname);
		String firstname=reader.getCellData("Sheet1", "firstname", 2);
		System.out.println(firstname);
		String Address=reader.getCellData("Sheet1", "Address", 2);
		System.out.println(Address);
		String Address2=reader.getCellData("Sheet1", "Address2", 2);
		System.out.println(Address2);
		String zipcode=reader.getCellData("Sheet1", "zipcode", 2);
		System.out.println(zipcode);
		String city=reader.getCellData("Sheet1", "city", 2);
		System.out.println(city);
		String homePhone=reader.getCellData("Sheet1", "homePhone", 2);
		System.out.println(homePhone);
		String MobilePhone=reader.getCellData("Sheet1", "MobilePhone", 2);
		System.out.println(MobilePhone);
		String other=reader.getCellData("Sheet1", "other", 2);
		System.out.println(other);
		lastName.sendKeys(lastname);
		firstName.sendKeys(firstname);
		address.sendKeys(Address);
		address2.sendKeys(Address2);
		zipCode.sendKeys(zipcode);
		cityW.sendKeys(city);
		Select select=new Select(dropdown);
		select.selectByVisibleText("India");
		homePhoneW.sendKeys(homePhone);
		mobiilePhone.sendKeys(MobilePhone);
		otherW.sendKeys(other);
		saveBtn.click();
	}
	

}
