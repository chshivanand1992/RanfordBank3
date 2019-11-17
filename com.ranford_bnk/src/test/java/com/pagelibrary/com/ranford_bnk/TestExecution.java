package com.pagelibrary.com.ranford_bnk;

import org.testng.annotations.Test;

import excel.Excel_Class;

public class TestExecution extends Reprository{
	
	@Test(priority=0)
	public void verify_launch()
	{
		Launch();
	}

	@Test(priority=1)
	public void verify_login()
	{
		
		Excel_Class.excelconnection("data.xls", "Sheet1");
		Excel_Class.outputexcelconnection("data.xls", "output.xls", "Sheet1");
		int c=Excel_Class.columns();
		for(int r=1;r<Excel_Class.rows();r++)
		{
			 String username= Excel_Class.readdata(0, r);
			 String password= Excel_Class.readdata(1, r);
			 login_TC(username,password);
			 
			   String actualtitle= driver.getTitle();
			   if(actualtitle.contains("RANFORD BANK"))
			   {
				   Excel_Class.writedata(c++, r, "Test Passed");
				   c--;
			   }
			   else if(!actualtitle.contains("RANFORD BANK"))
			   {
				   Excel_Class.writedata(c++, r, "Test Failed");
				   c--;
			   }
			   else
			   {
				   Excel_Class.writedata(c++, r, "n/a");
				   c--;
			   }
			 
		}
		Excel_Class.saveworkbook();
		
		
	}
	
	
	
	
	
}
