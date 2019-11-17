package PackTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

public abstract class Reprository {
	
	WebDriver driver;
	public void Login_Tc()
	{
		driver.findElement(Locators.username).sendKeys(TestData.Username);
		driver.findElement(Locators.password).sendKeys(TestData.password);
		driver.findElement(Locators.login).click();
		
		
		
	}

	public void Launch_Tc(String brow) 
	{
		if(brow.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(brow.contains("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(TestData.URL);
		String actualURL=driver.getCurrentUrl();
		String exp=TestData.URL;
		try
		{
			Assert.assertEquals(actualURL, exp);
			Reporter.log("Launch is successs with an EXpUrl "+exp+" is equal to actualUrl :- "+actualURL);
		}
		catch(Exception e)
		{
			Assert.fail("Launch is Unsuccess");
			Reporter.log("Launch is unsuccesss with an EXpUrl "+exp+" is not equal to actualUrl :- "+actualURL);
			Generic.screenshort("Launch");
		}
		
	}
	public void Branches_TC()
	{
		try
		{
			Assert.assertTrue(driver.findElement(Locators.Branches).isDisplayed());
			driver.findElement(Locators.Branches).click();
			Reporter.log("Branches btn is displayed");
		}
		catch(Exception e)
		{
			Assert.fail("Branches Btn Is not present");
			Reporter.log("Branches btn is not displayed");
			Generic.screenshort("Branches");
		}
	}
	
	public void Branch_search_Tc()
	{
		Generic.DP_Handle(driver,Locators.country, TestData.country);
		
	}
}
