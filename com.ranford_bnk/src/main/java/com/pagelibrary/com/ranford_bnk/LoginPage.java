package com.pagelibrary.com.ranford_bnk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TestBase.Base;

public class LoginPage extends Base{

	
	public static  WebElement  Username_editbox()
	{
		return driver.findElement(getElement("username"));
	}
	public static  WebElement  Password_editbox()
	{
		return driver.findElement(getElement("password"));
	}
	public static  WebElement  Login_btn()
	{
		return driver.findElement(getElement("login"));
	}
}
