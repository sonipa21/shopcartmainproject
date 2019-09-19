package com.shopcart.Catalog.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.shopcart.base.TestBase;

public class ProductsPage extends TestBase {

	public ProductsPage() throws FileNotFoundException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"tr__1_0\"]/td[4]")
	WebElement clickOnOneOftheItem;
	@FindBy(xpath="//*[@id=\"page-header-desc-product-new_product\"]/i")
	WebElement clickOnAddNewProduct;
	
	@FindBy(xpath="//*[@id=\"name_1\"]")
	WebElement name;
	
	@FindBy(xpath="//*[@id=\"reference\"]")
	WebElement refreenceCode;
	
	@FindBy(xpath="//*[@id=\"ean13\"]")
	WebElement barcode;
	@FindBy(xpath="//*[@id=\"online_only\"]")
	WebElement onlineOnlyCheckbox;
	@FindBy(xpath="//*[@id=\"tinymce\"]")
	WebElement shortDescriptionText;
	
	@FindBy(xpath="//textarea[@id='description_1']")
	WebElement description;
	@FindBy(xpath="//*[@id=\"product-informations\"]/div[16]/button[1]")
	WebElement saveBtn;
	
	@FindBy(xpath="//*[@id=\"tr__11_0\"]/td[5]")
	WebElement blouseItem;
	
	@FindBy(xpath="//a[contains(text(),'Prices')]")
	WebElement pricesLink;
	
	@FindBy(xpath="//h3[text()='Product price']")
	WebElement productPriceLabel;
	
	@FindBy(xpath="//input[@id='wholesale_price']")
	WebElement wholesalePriceBtn;
	
	@FindBy(xpath="//input[@id='priceTE']")
	WebElement retailPrice;
	
	@FindBy(xpath="//select[@id='id_tax_rules_group']")
	WebElement pricetaxruledropDown;
	@FindBy(xpath="//a[@class='btn btn-link confirm_leave']")
	WebElement createNewTaxLink;
	@FindBy(xpath="//input[@name='unity']")
	WebElement unitPrice;
	@FindBy(xpath="//*[@id=\"product-prices\"]/div[10]/button[1]")
	WebElement pricesaveBtn;
	@FindBy(xpath="//a[contains(text(),'Associations')]")
	WebElement associationsLink;
	
	@FindBy(xpath="//h3[text()='Associations']")
	WebElement associationLabel;
	
	@FindBy(xpath="//a[@id='uncheck-all-associated-categories-tree']")
	WebElement uncheckAll;
	@FindBy(xpath="//a[@id='expand-all-associated-categories-tree']")
	WebElement expandAll;
	
	@FindBy(xpath="//input[@class='search-field tt-query']")
	WebElement searchBtn;
	@FindBy(xpath="//*[@id=\"category_block\"]/div/div/div/div/span/span[2]/div/span/div[1]/p")
	WebElement tops;
	@FindBy(xpath="//input[@id='product_autocomplete_input']")
	WebElement seacrchBoxAccessories;
	
	@FindBy(xpath="//a[@class='chosen-single']")
	WebElement manufacturerDropdown;
	@FindBy(xpath="//*[@id=\"id_manufacturer_chosen\"]/div/div/input")
	WebElement serchDropdown;
	@FindBy(xpath="//*[@id=\"product-associations\"]/div[6]/button[1]")
	WebElement accessoriessaveBtn;
	
	@FindBy(xpath="//a[@id='link-Images']")
	WebElement imagesLink;
	
	@FindBy(xpath="//button[@id='file-add-button']")
	WebElement addFilesBtn;
	
	@FindBy(xpath="//button[@id='file-upload-button']")
	WebElement uploadFileBtn;
	@FindBy(xpath="//*[@id=\"product-images\"]/div[3]/button[1]")
	WebElement imagesSaveBtn;
	
	@FindBy(xpath="//*[@id=\"tr__9_0\"]/td[4]")
	WebElement deleteitemlink;
	
	@FindBy(xpath="//*[@id=\"page-header-desc-product-delete\"]/i")
	WebElement deleteBtn;
	public void verifyoneofTheItem()
	{
		clickOnOneOftheItem.click();
	}
	public void verifyAddNewProduct() throws Exception
	{
		clickOnAddNewProduct.click();
		name.sendKeys("Blouse");
		refreenceCode.sendKeys("demo_2");
		barcode.sendKeys("0");
		onlineOnlyCheckbox.click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,400)");
		
		driver.switchTo().frame("description_short_1_ifr");
		String text="Short-sleveed blouse with feminine draped sleeve detail";
		((JavascriptExecutor)driver).executeScript("arguments[0].value = arguments[1];", shortDescriptionText,
			text);
		shortDescriptionText.sendKeys("Short-sleveed blouse with feminine draped");
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		saveBtn.click();	
	}
	
	public void verifyBouseItem()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,500)");
		blouseItem.click();
		pricesLink.click();
		
	}
	public void verifypricesTab()  
	{
		String label= productPriceLabel.getText();
		System.out.println("label is:"+label);
		wholesalePriceBtn.sendKeys("0.80");
		retailPrice.sendKeys("0.2699852");
		Select select=new Select(pricetaxruledropDown);
		select.selectByVisibleText("US-AZ Rate (6.6%)");
		createNewTaxLink.click();
		driver.switchTo().alert().dismiss();
		unitPrice.sendKeys("27.00");
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(pricesaveBtn));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", pricesaveBtn);
		
	}
	public void verifyAssociationsTab()
	{
		associationsLink.click();
		boolean label=associationLabel.isDisplayed();
		System.out.println("is label displyed?"+label);
		uncheckAll.click();
		expandAll.click();
		searchBtn.sendKeys("Tops");
		tops.click();
		seacrchBoxAccessories.sendKeys("blouse (ref: demo_2)");
		manufacturerDropdown.click();
		serchDropdown.sendKeys("Fashion Manufacturer",Keys.ENTER);
		accessoriessaveBtn.click();
		
		
	}
	
	public void verifyImagesTab() throws Exception
	{
		imagesLink.click();
		addFilesBtn.click();
		StringSelection filepath= new StringSelection("C:\\Users\\ICE\\Desktop\\5-thickbox_default.jpg");
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		   Robot rb=new Robot();
		   Thread.sleep(2000);
		   rb.keyPress(KeyEvent.VK_CONTROL);
		   rb.keyPress(KeyEvent.VK_V);
		   rb.keyRelease(KeyEvent.VK_CONTROL);
		   rb.keyRelease(KeyEvent.VK_V);
		   Thread.sleep(6000);
		   rb.keyPress(KeyEvent.VK_ENTER);
		   rb.keyRelease(KeyEvent.VK_ENTER);
		   Thread.sleep(1000);
		   uploadFileBtn.click();
		   imagesSaveBtn.click();
		
	}
	public void verifyDeleteProduct()
	{
		deleteitemlink.click();
		deleteBtn.click();
		driver.switchTo().alert().accept();
		
	}

}
