package org.automation.testcases;

import org.automation.base.DriverInstance;
import org.automation.datagenerator.DataGenarator;
import org.automation.pages.LoginPage;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

public class TC_001_ValidateLoginFunctionality extends DriverInstance {

	
	@Test(dataProvider="Excel" , dataProviderClass=DataGenarator.class)
	public void tc001_login_functionality(String uname, String pass) throws Exception {
	
		extentTest =extentReports.startTest("tc001 passed", "Login ");
		extentTest.log(LogStatus.PASS, "tc001 login passed");
		extentReports.endTest(extentTest);

		
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(uname);
		login.enterPassword(pass);
		login.clicksignin();
	}
	
	
	
}



