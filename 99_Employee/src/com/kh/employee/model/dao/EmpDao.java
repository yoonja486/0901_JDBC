package com.kh.employee.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EmpDao {

	private Properties prop = new Properties();
	
	public EmpDao() {
		
		try {
			prop.loadFromXML(new FileInputStream("resources/emp-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
