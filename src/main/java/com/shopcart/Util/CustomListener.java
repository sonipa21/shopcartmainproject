package com.shopcart.Util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.shopcart.base.TestBase;

public class CustomListener extends TestBase implements ITestListener{

	public CustomListener() throws FileNotFoundException {
		super();
		
	}

	

	public void onTestFailure(ITestResult result) {
		System.out.println("Failed test");
		try {
			SimpleDateFormat date = new SimpleDateFormat();
		//Srting S= date.getDateTimeInstance();
			failed(result.getMethod().getMethodName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}



	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}



	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}



	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
