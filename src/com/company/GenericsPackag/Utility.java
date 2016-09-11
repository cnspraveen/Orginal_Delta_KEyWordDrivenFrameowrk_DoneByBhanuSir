package com.company.GenericsPackag;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Utility
{
	public static String getFormatDateTime()
	{
	SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
	String s =sdf.format(new Date());
	return s;
	}
	
	public static String getPageScreenShot(WebDriver driver, String imageFolderPath)
	{
		String imagepath = imageFolderPath+"/" + getFormatDateTime()+".png";
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		try {
			FileUtils.copyFile(edriver.getScreenshotAs(OutputType.FILE), new File(imagepath));
		} catch (Exception e) {
						//e.printStackTrace();
		}
		return imagepath;
	}
}
