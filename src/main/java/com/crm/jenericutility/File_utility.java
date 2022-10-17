package com.crm.jenericutility;

import java.io.FileInputStream;
import java.util.Properties;

public class File_utility {
	public String getPropertyKeyValue(String Key) throws Throwable

	{
	//FileInputStream fis=new FileInputStream("./common.properties.txt");
		
	FileInputStream fis=new FileInputStream(ipathconstant.PROPERTYFILE_PATH);
	Properties pro=new Properties();
	pro.load(fis);
	String value = pro.getProperty(Key);
	return value;

	}
}
