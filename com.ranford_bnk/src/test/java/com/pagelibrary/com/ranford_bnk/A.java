package com.pagelibrary.com.ranford_bnk;


import org.testng.annotations.Test;

public class A {

	@Test(priority=0)
	public void lauch()
	{
		System.out.println("m1_method");
	}
	@Test(priority=1)
	public void login()
	{
		System.out.println("m2_method");
	}
	
	@Test(priority=2)
	public void Branches()
	{
		System.out.println("m3_method");
	}
	
	
}
