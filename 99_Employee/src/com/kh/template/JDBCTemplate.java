package com.kh.template;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class JDBCTemplate {

public static Connection getConnection() {
		
		Properties prop = new Properties();
		try {
			
			prop.load(new FileInputStream("resources/driver.properties"));
		} catch(IOException e)	{
			e.printStackTrace();
		}
			
		return null;
	}
}
