package com.company.GenericsPackag;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class Excel
{
	@Test
	public static int GetRowCount(String path, String sheet)
	{
		int rcount=0; 
		try {rcount = WorkbookFactory.create(new FileInputStream(path)).getSheet(sheet).getLastRowNum();
		       System.out.println(rcount);} 
		catch (Exception e) 
		{ //e.printStackTrace();	
		}
		return rcount;
	}
	
	@Test
public static String GetCellValue(String path, String sheet, int r, int c)
{
	String cellvalue ="";
	try {cellvalue = WorkbookFactory.create(new FileInputStream(path)).getSheet(sheet).getRow(r).getCell(c).toString();
           //System.out.println(cellvalue);
	} 
    catch (Exception e) 
{}//e.printStackTrace();	}
	return cellvalue;
}
	
	
}


