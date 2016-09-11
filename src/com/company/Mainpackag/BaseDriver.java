package com.company.Mainpackag;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.company.GenericsPackag.Excel;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseDriver implements AutomationConstants
{
	public WebDriver driver;
	public ExtentReports ereports;
	public ExtentTest etestreports;
	
	
	@BeforeTest//BeforeSuite
	public void initFrameWork()
	{
		ereports = new ExtentReports(reportFilePath);
		String erpo = ereports.toString();
		System.out.println(erpo);
	}
	
	@AfterTest //AfterSuite()
	public void endFramework()
	{
		ereports.flush();
	}
	
   @DataProvider
   public String[][] getScenario()
   {
	   String[][] data = new String[2][1];
	   data[0][0] = "LoginScenario";
	   data[1][0] = "LoginScenario2";
	   return data;
   }
   
   @DataProvider   //(Reading only 1 row (2 columns)  
   public String[][] getScenarios()
   {
	   String[][] data2 = new String[1][2];
	   String ScenarioName = Excel.GetCellValue(Controllerpath, suiteSheet, 1, 0);
	   String ExecutionStatus = Excel.GetCellValue(Controllerpath, suiteSheet, 1, 1);
	   data2[0][0]=ScenarioName;
	   data2[0][1]=ExecutionStatus;	   
	   return data2;
   }
   
   @DataProvider  //(Reading Multiple rows (as per number of  columns)
   public String[][] getMultipleScenarios()
   {
	   int ScenarioCount = Excel.GetRowCount(Controllerpath, suiteSheet);
	  
	   String[][] data3 = new String[ScenarioCount][2];
	   for(int j=1;j<=ScenarioCount;j++)
	   {
	   String ScenarioName = Excel.GetCellValue(Controllerpath, suiteSheet, j, 0);
	   String ExecutionStatus = Excel.GetCellValue(Controllerpath, suiteSheet, j, 1);
	   System.out.println(ScenarioName);
	   System.out.println(ExecutionStatus);
	   
	   data3[j-1][0]=ScenarioName;
	   data3[j-1][1]=ExecutionStatus;	   
   }
	   return data3;
}
}


