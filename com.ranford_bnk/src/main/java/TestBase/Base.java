package TestBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Base {

	 public  static WebDriver driver;
	
	static Properties p;
	public static void loadproperty() 
	{
		
		try {
			File f=new File(".\\src\\main\\java\\configuration\\OR.properties");
			
			FileReader fr=new FileReader(f);
			
			 p=new Properties();
			p.load(fr);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static By getElement(String key) 
	{
		 loadproperty();
		By loc=null;
		String value=   p.getProperty(key);  
		
		  String loctype= value.split(":")[0];
		  String locvalue=value.split(":")[1];
		
		switch(loctype)
		{
		case "id":
			loc=By.id(locvalue);
			break;
		case "name":
		loc=	By.name(locvalue);
			break;
		}
		return loc;
		
	}
	
	public static void loadpropertyconfig() 
	{
		
		try {
			File f=new File(".\\src\\main\\java\\configuration\\config.properties");
			
			FileReader fr=new FileReader(f);
			
			 p=new Properties();
			p.load(fr);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String GetConfig(String key)
	{
		loadpropertyconfig() ;
		String data=  p.getProperty(key);
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
