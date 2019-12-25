package org.automation.pages;

import java.io.IOException;

import org.automation.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver) {       //constructor
		this.driver=driver;
	}
	public void enterUserName(String uname) throws Exception {
		driver.findElement(By.id(Utility.fetchLocatorValue("login_username_id"))).sendKeys(uname);
	}
	
	public void enterPassword(String pass) throws IOException {
		driver.findElement(By.id(Utility.fetchLocatorValue("login_password_id"))).sendKeys(pass);
	}
	
	public void enterFirstName(String firstName) throws IOException {
		driver.findElement(By.name(Utility.fetchLocatorValue("login_firstname_name"))).sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) throws IOException {
		driver.findElement(By.name(Utility.fetchLocatorValue("login_lastname_name"))).sendKeys(lastName);
	}
	
	public void enterMobileNumber(String mobileNumber) throws IOException {
		driver.findElement(By.name(Utility.fetchLocatorValue("login_phonenumber_name"))).sendKeys(mobileNumber);
	}
	
	public void clicksignin() throws IOException {
		driver.findElement(By.xpath(Utility.fetchLocatorValue("login_signin_xpath"))).click();

	}
	
	
}
