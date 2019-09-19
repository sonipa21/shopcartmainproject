package com.shopcart.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.FileChooserUI;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.shopcart.dashboard.testcases.LoginPageTest;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	static Logger log=Logger.getLogger(TestBase.class);
	
	public TestBase() throws FileNotFoundException
	{
		try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream("C:\\JBK Eclipse Configured 32-bit\\ShopKartProject-master\\ShopKartProject-master\\ShopCartAdmin123\\src\\main\\java\\com\\shopcart\\config\\config.properties");
				prop.load(ip);
			} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32 new\\chromedriver.exe");  
			driver = new ChromeDriver();
			log.info("launching chrome browser");
		}
		else if(browserName.equals("FF"))
		{
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		log.info("entering url");
	}
	public void failed(String testMethodName) throws IOException
	{
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new File(currentDir + "/screenshots/" +testMethodName+"_"+".jpg"));
		
	}
}
