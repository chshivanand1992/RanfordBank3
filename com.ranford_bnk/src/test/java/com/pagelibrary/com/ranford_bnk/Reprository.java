package com.pagelibrary.com.ranford_bnk;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Log;

import TestBase.Base;
import Utility.Generic_Class;
import Wetbable.Webtable;
import junit.framework.Assert;


public abstract class Reprository extends Base{

	ExtentReports report;
	
	ExtentTest    test;
	
	@BeforeTest
	public void generate_report()
	{
		report=new ExtentReports(".\\extentreport\\report.html",true);
		
	}
	@BeforeMethod
	public void Send_method_To_report(Method method)
	{
		test=report.startTest((this.getClass().getSimpleName()+" : : "+method.getName()));
		test.assignAuthor("shiva");
		test.assignCategory("Smoke");
		
	}
	@AfterMethod
	public void save_report()
	{
		report.flush();
	}
	
	public void Launch()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\seleniumsoftware\\recordings\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		test.log(LogStatus.INFO, "BRowser Has launch");
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "BRowser Has maximized");
		driver.get(GetConfig("Build1"));
		test.log(LogStatus.INFO, "Url Is Navigated");
		String ActualUrl=driver.getCurrentUrl();
		try
		{
			
			org.testng.Assert.assertEquals(ActualUrl, GetConfig("Build1"));
			Assert.assertTrue("Launch Is success",ActualUrl.equals(GetConfig("Build1")));
			test.log(LogStatus.PASS, "My expURl :- "+GetConfig("Build1")+" is matching mith my acyualURl :- "+ActualUrl);
			test.log(LogStatus.INFO, "Launch Is done successfully");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "My expURl :- "+GetConfig("Build1")+" is not matching mith my acyualURl :- "+ActualUrl);
			test.log(LogStatus.INFO, "404 Error Page Is not ready to load");
			Assert.fail("page  is not loaded :- "+e.getMessage());
			
			
			
		}
		
		
	}
	public void login_TC(String user,String passwrd)
	{
	
		
		test.log(LogStatus.INFO, "TestCase Id :- C1234");
		test.log(LogStatus.INFO, "Verifaction of Login");
	
	   Generic_Class.JSSendkeys(LoginPage.Username_editbox(), user);
	   Generic_Class.JSSendkeys(LoginPage.Password_editbox(), passwrd);
	   Generic_Class.JSClick(LoginPage.Login_btn());
	   String actualtitle=driver.getTitle();
	   String exptitle="RANFORD BANK";
	   try
	   {
		   Assert.assertEquals(actualtitle, exptitle);
		   test.log(LogStatus.PASS, "My exptitle :- "+exptitle+" is matching mith my acyualtitle :- "+actualtitle);
		 
	   }
	   catch(Exception e)
	   {
		   Assert.fail("title is not present as expected");
		   test.log(LogStatus.FAIL, "My exptitle :- "+exptitle+" is not matching mith my acyualtitle :- "+actualtitle);
	   }
	  
	}
	public void Banches_Tc()
	{
		try
		{
			AdminPage.Branches_Btn().click();
			   
		     List<String> expdata=new ArrayList<>();
		     expdata.add("INDIA");expdata.add("EUROPE");expdata.add("USA");
		     List<String> ActualData=Generic_Class.DP_Handle_verify(AdminPage.Branches_Btn());
			
		    boolean result= Generic_Class.Is_equals(expdata, ActualData);
		     
		     Assert.assertTrue("Verifaction of Dropdown country :- ", result);
		     
		 }
		catch(Exception e)
		{
			Assert.fail("Verifaction of Dropdown country iS Failed");
		}
	   
	     
	     
	}
	public void BranchCreation_TC()
	{
		
		
		test.log(LogStatus.INFO, "1. Verifaction Of Branches_creation");
		test.log(LogStatus.INFO, "TCCase Id :- C2345");
		try
		{
			Assert.assertTrue(Branch_Creation.New_Branch().isDisplayed());
			test.log(LogStatus.INFO, "NewBranches BTn is displayed");
			Generic_Class.JSClick(Branch_Creation.New_Branch());
			test.log(LogStatus.INFO, "NewBranches BTn is Clicked");
			
			
			Assert.assertTrue(Branch_Creation.submit().isDisplayed());
			test.log(LogStatus.INFO, "submit is displayed");
			Generic_Class.JSClick(Branch_Creation.submit());
			
			String actualTest=driver.switchTo().alert().getText();
			
			String expText="Created Successfully";
			
			Assert.assertTrue("Branch is created", actualTest.contains(expText));
			
			   String BranchId=actualTest.split(" ")[4];
			driver.switchTo().alert().accept();
			test.log(LogStatus.PASS, "new Branch Is Created With Id :- "+BranchId);
			
			test.log(LogStatus.INFO, "Verify The Id "+BranchId+" is present in The table");
			
			Webtable.BR_Table_Handle("edit", By.id(""), BranchId);
			
		}
		catch(Exception e)
		{
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
