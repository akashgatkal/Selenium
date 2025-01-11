package com.crm.FileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadFromPropertyFile {

	public static String propertyData(String keys) throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("./src/test/resources/Configure.properties");
		prop.load(fis);
		String data=prop.getProperty(keys);
		return data;
	}

}
