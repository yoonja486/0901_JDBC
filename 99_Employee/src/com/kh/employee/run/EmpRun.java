package com.kh.employee.run;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class EmpRun {

	
	public static void main(String[] args) {
		
		Properties prop = new Properties();
		prop.setProperty("A", "B");
		
		try {
			prop.storeToXML(new FileOutputStream("emp-mapper.xml"), "EMPLOYEE SQL");
		
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		
		
		
		
	}
}
