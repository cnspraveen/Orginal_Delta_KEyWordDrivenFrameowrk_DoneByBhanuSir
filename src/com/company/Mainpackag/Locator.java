package com.company.Mainpackag;

import org.openqa.selenium.By;

public class Locator
{
 public static By getLocator(String ElementRepo)
  {
	 By b=null;
	 String str[] = ElementRepo.split("_");
	 String locator = str[0];
	 String value= str[1];
	 if(locator.equalsIgnoreCase("ID"))
	 {
		 b=By.id(value);
	 }
	 else if(locator.equalsIgnoreCase("NAME"))
	 {
		 b=By.name(value);
	 }
	 else if(locator.equalsIgnoreCase("XPATH"))
	 {
		 b=By.xpath(value);
	 }
	 else if(locator.equalsIgnoreCase("LinkText"))
	 {
		 
		 b=By.linkText(value);
		 System.out.println("Logout Link to be click");
	 }
	 else if(locator.equalsIgnoreCase("PartialLinkText"))
	 {
		 b=By.partialLinkText(value);
	 }
	 else if(locator.equalsIgnoreCase("CssSelector"))
	 {
		 b=By.cssSelector(value);
	 }
	 else if(locator.equalsIgnoreCase("ClassName"))
	 {
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}
			
		 System.out.println("Click on Log-in Button again by using Class='initial' locator");
		 b = By.className(value);
		 System.out.println("Clcik on Calender");
	 }
	 else if(locator.equalsIgnoreCase("TagName"))
	 {
		b =  By.tagName(value);
	 }
	 return b;
  }
}
