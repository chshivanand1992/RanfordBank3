package PackTestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestExecution extends Reprository {
	
	@Parameters({"browser"})
	@Test(priority=0)
	public void Verify_Launch(String browser)
	{
		Launch_Tc(browser);
	
	}
	@Test(priority=1)
	public void Verify_login()
	{
		Login_Tc();
	}

}
