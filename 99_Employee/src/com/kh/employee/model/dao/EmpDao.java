package com.kh.employee.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.employee.model.vo.EmpVo;

public class EmpDao {

	private Properties prop = new Properties();
	
	public EmpDao() {
		
		try {
			prop.loadFromXML(new FileInputStream("resources/emp-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public List<EmpVo> deptSearch(){
		
		List<EmpVo> ev = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("deptSearch");
		
		return null;
	}
	
	
	
}
