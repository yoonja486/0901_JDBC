package com.kh.employee.run;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.kh.employee.model.view.EmpView;

public class EmpRun {

	  
	public static void main(String[] args) {
//		System.out.println("test!!");
//		Properties prop = new Properties();
//		prop.setProperty("A", "B");
//		 
//		try {
//			//driver.properties
//			  String path = System.getProperty("user.dir");
//			  System.out.println("현재 작업 경로: " + path);
//			//prop.storeToXML(new FileOutputStream("emp-mapper.xml"), "EMPLOYEE SQL");
//			//prop.storeToXML(new FileOutputStream("C:\\study\\Employee\\src\\com\\kh\\employee\\resources\\emp-mapper.xml"), "EMPLOYEE SQL");
//		} catch (IOException e) {
//			e.printStackTrace();
//			System.out.println(">>>>> " + e.toString());
//		}
		
		EmpView ev = new EmpView();
		ev.mainMenu();
		
		
		
		
	}
}