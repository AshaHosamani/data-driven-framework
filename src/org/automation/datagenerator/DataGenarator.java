package org.automation.datagenerator;

import java.io.FileInputStream;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataGenarator {

	@DataProvider(name="Excel")
	public static Object[][] dataGenerator(Method met) throws Exception {
		
		if(met.getName().equalsIgnoreCase("tc001_login_functionality"))
		{
		FileInputStream file=new FileInputStream("./TestData/TestData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet loginsheet=workbook.getSheet("Login");
		int numberOfData = loginsheet.getPhysicalNumberOfRows();
		
		Object [][] testData = new Object[numberOfData][2];
		
		for(int i=0;i<numberOfData;i++) {
			XSSFRow row=loginsheet.getRow(i);
			XSSFCell username=row.getCell(0);
			XSSFCell password=row.getCell(1);
			testData[i][0]= username.getStringCellValue();
			testData[i][1]= password.getStringCellValue();
		}
		return testData;
	}
		else if(met.getName().equalsIgnoreCase("tc002_register_new_user")) {
			FileInputStream file=new FileInputStream("./TestData/TestData.xlsx");
			XSSFWorkbook workbook=new XSSFWorkbook(file);
			XSSFSheet loginsheet=workbook.getSheet("Register");
			int numberOfData = loginsheet.getPhysicalNumberOfRows();
			
			Object [][] testData = new Object[numberOfData][3];
			
			for(int i=0;i<numberOfData;i++) {
				XSSFRow row=loginsheet.getRow(i);
				XSSFCell firstname=row.getCell(0);
				XSSFCell lastname=row.getCell(1);
				XSSFCell phonenumber=row.getCell(0);
				testData[i][0]= firstname.getStringCellValue();
				testData[i][1]= lastname.getStringCellValue();
				testData[i][2]= phonenumber.getStringCellValue();

			}
			return testData;
		}
		else
		{
			Object [][] testData = new Object[2][3];
			return testData;

		}
	}
	
}

/*
 * static data dataGenerator
 * Object [][] data= {{"uname1", "pass1"},{"uname2" , "pass2"}, {"uname3","pass3"}};
return data;
*/