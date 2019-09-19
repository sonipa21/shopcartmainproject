package com.shopcart.Orders.Pages;

import java.io.FileNotFoundException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.shopcart.Util.Xls_Reader;
import com.shopcart.base.TestBase;

public class OrdersPage  extends TestBase{

	public OrdersPage() throws FileNotFoundException {
		super();
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//*[@id=\"page-header-desc-order-new_order\"]/i")
	WebElement addnewOderlink;
	
	@FindBy(xpath="//a[@class='fancybox_customer btn btn-default']")
	WebElement addnewCustomer;
	
	@FindBy(xpath="/html/body/div[4]/div/div/a")
	WebElement closeBtn;
	
	@FindBy(xpath="//input[@id='gender_1']")
	WebElement gendercheckbox;
	
	@FindBy(xpath="//input[@id='firstname']")
	WebElement firstName;
	@FindBy(xpath="//input[@id='lastname']")
	WebElement lastName;
	@FindBy(xpath="//input[@id='email']")
	WebElement emailAddress;
	@FindBy(xpath="//input[@id='passwd']")
	WebElement 	passwordW;
	@FindBy(xpath="//select[@name='days']")
	WebElement days;
	@FindBy(xpath="//select[@name='months']")
	WebElement months;
	@FindBy(xpath="//select[@name='years']")
	WebElement years;
	@FindBy(xpath="//*[@id=\"fieldset_0\"]/div[2]/div[8]/div/span/label[1]")
	WebElement newsletterbtn;
	@FindBy(xpath="//*[@id=\"customer_form_submit_btn\"]")
	WebElement saveBtn;
	@FindBy(xpath="//input[@id='customer']")
	WebElement searchBtn;
	@FindBy(xpath="//*[@id=\"customers\"]/div/div/div[2]/a")
	WebElement detailsBtn;
	
	public void clickOnAddNewOrder()
	{
		addnewOderlink.click();
	}
	public void addNewOrderLink()
	{
		addnewOderlink.click();
		addnewCustomer.click();
		/*List<WebElement> frame=driver.findElements(By.tagName("iframe"));
		System.out.println(frame.size());*/
		//closeBtn.click();
		driver.switchTo().frame(1);
	}
	public void createNewCustomer(String firstname,String lastname,String emailaddress,String password)
	{
		gendercheckbox.click();
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		emailAddress.sendKeys(emailaddress);
		passwordW.sendKeys(password);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,400)");
		Select select=new Select(days);
		select.selectByVisibleText("21");
		Select select1=new Select(months);
		select1.selectByVisibleText("May");
		Select select2=new Select(years);
		select2.selectByVisibleText("1991");
		newsletterbtn.click();
		saveBtn.click();
		
	}
	public void serchCustomer()
	{
		searchBtn.sendKeys("pramod",Keys.ENTER);
		detailsBtn.click();
		
	}
}
