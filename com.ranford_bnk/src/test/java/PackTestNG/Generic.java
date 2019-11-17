package PackTestNG;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Generic {

	
	public static void DP_Handle(WebDriver driver,By prop,String data)
	{
		Select s=new Select(driver.findElement(prop));
		
		List<WebElement> options=s.getOptions();
		
		for(WebElement op:options)
		{
			String text=op.getText();
			System.out.println(text);
			if(text.contains(data))
			{
				op.click();
				break;
			}
		}
	}
	public static void screenshort(String screenname) 
	{
		
		try {
			Robot r=new Robot();
			
			BufferedImage bi=r.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			
			ImageIO.write(bi, "png", new File(".\\screenshort\\"+screenname+".png"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
