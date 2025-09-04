package com.kh.employee.service;

import java.sql.Connection;

public class EmpService {

	private Connection conn = null;

	
	public EmpService(Connection conn) {
		
		this.conn = getConnection();
	}


	private Connection getConnection() {
		
		return null;
	}

	
}
