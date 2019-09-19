package com.shopcart.Catalog.Pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.shopcart.base.TestBase;

public class ProductAttributesPages extends TestBase {

	public ProductAttributesPages() throws FileNotFoundException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"page-header-desc-attribute_group-new_value\"]/i")
	WebElement addnewValue;
	
	@FindBy(xpath="//select[@id='id_attribute_group']")
	WebElement attributegroupdropdown;
	
	@FindBy(xpath="//*[@id=\"name_1\"]")
	WebElement valueBtn;
	@FindBy(xpath="//input[@class='color mColorPickerInput mColorPicker']")
	WebElement colorbtn;
	@FindBy(xpath="//*[@id=\"attribute_form_submit_btn\"]")
	WebElement saveBtn;
	
	
	public void verifyAddNewValue()
	{
		addnewValue.click();
		Select select=new Select(attributegroupdropdown);
		select.selectByVisibleText("Color");
		valueBtn.sendKeys("Black");
		colorbtn.sendKeys("#000000");
		saveBtn.click();
		
		
		
	}
	

}
