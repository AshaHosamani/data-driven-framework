package org.automation.base;

import java.io.IOException;

import org.automation.utility.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class DriverInstance {
    
	public WebDriver driver;
	
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	
	@BeforeTest
	public void initiateReport() {
		extentReports=new ExtentReports("./Reports/report.html", true);
		extentReports.addSystemInfo("Author name", "Facebook");
	}
	
	@BeforeMethod
	public void InitiateDriverInstance() throws IOException {		
		if(Utility.fetchProperty("browserName").toString().equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		    driver= new ChromeDriver();
		}
		else if(Utility.fetchProperty("browserName").toString().equalsIgnoreCase("firefox"))
	
		{
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
            driver= new FirefoxDriver();
			
		}
		else if(Utility.fetchProperty("browserName").toString().equalsIgnoreCase("ie"))
			
		{
			System.setProperty("webdriver.ie.driver", "./Driver/internetexplorer.exe");
			driver= new InternetExplorerDriver();
			
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
            driver= new ChromeDriver();
			
		}
	
	   driver.get(Utility.fetchProperty("applicationURL").toString());
	
	}
	
	@AfterMethod
	public void closeWedDriverInstance() {
		driver.close();
		driver.quit();
	}
	
	@AfterTest
	public void CloseDriverInstance() {
		
		extentReports.flush();

		
	}
}
