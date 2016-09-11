package com.company.Mainpackag;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.company.GenericsPackag.Excel;
import com.company.GenericsPackag.InputProperty;
import com.company.GenericsPackag.Utility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Delta extends BaseDriver
{
	public String browser;
	@BeforeMethod
	public void AppLaunch(XmlTest x) throws MalformedURLException
	{
		
		String AppURL = InputProperty.Property(propertyFilePath, "url");
		String TimeOut = InputProperty.Property(propertyFilePath, "Time");
		
		//Multiple Browser Launch
		/*String browser = x.getParameter("browser");
				if(browser.equalsIgnoreCase("firefox"))
				{
					driver = new FirefoxDriver();
					System.out.println("Firefox Launched");
				}
				else if(browser.equalsIgnoreCase("chrome"))
				{
					System.setProperty("webdriver.chrome.driver", "./ExeFiles/chromedriver.exe");
					driver = new ChromeDriver();
					System.out.println("ChromeDriver launched");
				}
				else if(browser.equalsIgnoreCase("ie"))
				{
					System.setProperty("webdriver.chrome.driver", "./ExeFiles/IEDriverServer.exe");
					driver = new InternetExplorerDriver();
					System.out.println("IE Launched");
				}*/
		
				/*URL remoteaddress =new URL(x.getParameter("URL"));
				driver =new RemoteWebDriver(remoteaddress, DesiredCapabilities.firefox());  //new RemoteWebDriver(remoteaddress, DesiredCapabilities.firefox());
				driver.get("http://localhost:8080/login.do");
				driver.close();
				
				driver =new RemoteWebDriver(remoteaddress, DesiredCapabilities.chrome());  //new RemoteWebDriver(remoteaddress, DesiredCapabilities.firefox());
				driver.get("http://localhost:8080/login.do");
				driver.close();*/
		
		driver = new FirefoxDriver();
		System.out.println("Firefox Launched");
		driver.get(AppURL);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(TimeOut), TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	/*@Test(dataProvider="getScenario")
	public void Login(String ScenarioSheet)
	{
		
		etestreports = ereports.startTest(ScenarioSheet);
		
	 int rc2 = Excel.GetRowCount(ScenarioPath, ScenarioSheet);
	 System.out.println(rc2);
	 for(int i=0;i<=rc2;i++)
	 {
		String Desc = Excel.GetCellValue(ScenarioPath, ScenarioSheet, i, 0);
		String Action = Excel.GetCellValue(ScenarioPath, ScenarioSheet, i, 1);
		String ElementRepo = Excel.GetCellValue(ScenarioPath, ScenarioSheet, i, 2);
		String input = Excel.GetCellValue(ScenarioPath, ScenarioSheet, i, 3);
		System.out.println(Desc);
		System.out.println(Action);
		System.out.println(ElementRepo);
		System.out.println(input);
		
		String msg="description:"+Desc+"  action:"+Action+"  input1:"+ElementRepo+"  input2:"+input;
		etestreports.log(LogStatus.INFO, msg);
		KeyWord.executeKeyWord(driver, Action, ElementRepo, input);
		//Assert.fail();
		
	 }
	 }*/
	
	/*@Test(dataProvider="getScenarios")
	public void ScenarioName(String ScenarioSheet, String ExecutionStatus)
	{
		etestreports = ereports.startTest(ScenarioSheet);
	
	if(ExecutionStatus.equalsIgnoreCase("Yes"))
	{
	 int rc2 = Excel.GetRowCount(ScenarioPath, ScenarioSheet);
	 System.out.println(rc2);
	 for(int i=0;i<=rc2;i++)
	 {
		String Desc = Excel.GetCellValue(ScenarioPath, ScenarioSheet, i, 0);
		String Action = Excel.GetCellValue(ScenarioPath, ScenarioSheet, i, 1);
		String ElementRepo = Excel.GetCellValue(ScenarioPath, ScenarioSheet, i, 2);
		String input = Excel.GetCellValue(ScenarioPath, ScenarioSheet, i, 3);
		System.out.println(Desc);
		System.out.println(Action);
		System.out.println(ElementRepo);
		System.out.println(input);
		
		String msg="description:"+Desc+"  action:"+Action+"  input1:"+ElementRepo+"  input2:"+input;
		etestreports.log(LogStatus.INFO, msg);
		KeyWord.executeKeyWord(driver, Action, ElementRepo, input);
		//Assert.fail()
	 }
	}
	else
	{
		etestreports.log(LogStatus.SKIP, "Execution Status is 'NO' ");
		throw new SkipException("Skipping this scenario");
	}
}*/
	
	
	@Test(dataProvider="getMultipleScenarios")
	public void ScenarioName3(String ScenarioSheet, String ExecutionStatus)
	{
		etestreports = ereports.startTest(browser + " " + ScenarioSheet);
	
	if(ExecutionStatus.equalsIgnoreCase("Yes"))
	{
	 int rc2 = Excel.GetRowCount(ScenarioPath, ScenarioSheet);
	 System.out.println(ScenarioPath);
	 System.out.println(ScenarioSheet);
	 System.out.println(rc2);
	 
	 for(int i=1;i<=rc2;i++)
	 {
		String Desc = Excel.GetCellValue(ScenarioPath, ScenarioSheet, i, 0);
		String Action = Excel.GetCellValue(ScenarioPath, ScenarioSheet, i, 1);
		String ElementRepo = Excel.GetCellValue(ScenarioPath, ScenarioSheet, i, 2);
		String input = Excel.GetCellValue(ScenarioPath, ScenarioSheet, i, 3);
		System.out.println(Desc);
		System.out.println(Action);
		System.out.println(ElementRepo);
		System.out.println(input);
		
		String msg="description:"+Desc+"  action:"+Action+"  input1:"+ElementRepo+"  input2:"+input;
		System.out.println(msg);
		etestreports.log(LogStatus.INFO, msg);
		KeyWord.executeKeyWord(driver, Action, ElementRepo, input);
		//Assert.fail()
	 }
	}
	else
	{
		etestreports.log(LogStatus.SKIP, "Execution Status is 'NO' ");
		throw new SkipException("Skipping this scenario");
	}
}
	
	@AfterMethod()
	public void quitApp(ITestResult test)
	{
		System.out.println("inside after method");
		System.out.println(test.getStatus());
		if(test.getStatus()==ITestResult.FAILURE)   //or  (test.getStatus()==2);
		{
			String pImage = Utility.getPageScreenShot(driver, imageFolderPath);
			System.out.println(pImage);
		    String p = etestreports.addScreenCapture("." +pImage );
		    etestreports.log(LogStatus.FAIL, "Page Screen Shot: "+ p);
		}
		
		ereports.endTest(etestreports);
		//System.out.println("skipped");
		//driver.close();
	}
	
	
}

