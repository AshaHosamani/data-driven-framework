package org.automation.testcases;

import java.io.IOException;

import org.automation.base.DriverInstance;
import org.automation.datagenerator.DataGenarator;
import org.automation.pages.LoginPage;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class TC_002_RegisterNewUser extends DriverInstance{

	@Test(dataProvider="Excel", dataProviderClass=DataGenarator.class)
	public void tc002_register_new_user(String fname, String lname, String pnumber) throws IOException {
		
		extentTest =extentReports.startTest("tc002 passed", "Register ");
		extentTest.log(LogStatus.PASS, "Register successful");
		extentReports.endTest(extentTest);
		
		LoginPage login=new LoginPage(driver);
		login.enterFirstName(fname);
		login.enterLastName(lname);
		login.enterMobileNumber(pnumber);
	}
}
