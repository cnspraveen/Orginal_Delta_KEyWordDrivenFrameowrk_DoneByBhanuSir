package com.company.GenericsPackag;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class InputProperty 
{
  public static String Property(String inputPropFile, String Key)
  {
	  String value="";
	  Properties prop = new Properties();
	  try {
		prop.load(new FileInputStream(inputPropFile));
		value = prop.getProperty(Key);
		}
	  catch (Exception e) {
		//e.printStackTrace();}
	
  }
	  return value;
  }
}
