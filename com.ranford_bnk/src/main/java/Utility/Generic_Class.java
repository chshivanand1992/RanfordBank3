package Utility;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import TestBase.Base;

public class Generic_Class extends Base{

	
	public static  void JSClick(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click()",element);
	}
	public static  void JSSendkeys(WebElement element,String data)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].value="+data+"",element);
	}
	
	public static Select Select_Dp(WebElement element)
	{
		Select s=new Select(element);
		return s;
	}
	public static List<String> DP_Handle_verify(WebElement element)
	{
		List<String> mydata=new ArrayList<String>();
		Select s=new Select(element);
		
		List<WebElement>  list=s.getOptions();
		
		for(WebElement ele:list)
		{
			String text=ele.getText();
			mydata.add(text);
		}
		return mydata;
	}
	
	public static boolean Is_equals(List<String> l1,List<String> l2)
	{
		 if(l1.size()!=l2.size())
		 {
			 return false;
		 }
		 for(String s:l1)
		 {
			 if(!l2.contains(s))
			 {
				 return false;
			 }
		 }
		 return true;
		 
	}
	
}
