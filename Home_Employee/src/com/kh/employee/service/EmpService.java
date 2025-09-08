package com.kh.employee.service;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.kh.employee.model.dao.EmpDao;
import com.kh.employee.model.vo.EmpVo;

public class EmpService {

	private Connection conn = null;
	
	public EmpService() {
		
		Properties prop = new Properties();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			prop.load(new FileInputStream("driver.properties"));
			conn = DriverManager.getConnection(prop.getProperty("URL"), prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
		} catch (Exception e) {
			System.out.println("---> " + e.toString());
		}
	
	}

	public List<EmpVo> findAll(){
		
		EmpDao ed = new EmpDao();
		List evs = ed.findAll(conn);
		
		
		return evs;
	}
	
	
	public List<EmpVo> deptSearch(String deptTitle) {
		
		EmpDao ed = new EmpDao();
		List evs = ed.deptSearch(conn, deptTitle);
		
		return evs;
	}
	
	
	public List<EmpVo> jobSearch(String jobName) {
		
		EmpDao ed = new EmpDao();
		List evs = ed.jobSearch(conn, jobName);
		
		return evs;
		
	}
	
	
	public List<EmpVo> empIdDtl(String empId) {
		
		EmpDao ed = new EmpDao();
		List evs = ed.empIdDtl(conn, empId);
		
		return evs;
	}
	
	
	public List<EmpVo> maxSalary() {
		
		EmpDao ed = new EmpDao();
		List evs = ed.maxSalary(conn);
		
		return evs;
	}
	
	
	public List<EmpVo> minSalary() {
		
		EmpDao ed = new EmpDao();
		List evs = ed.minSalary(conn);
		
		return evs;
	}
	
	
	public int insertEmp(EmpVo ev) {
		
		int result = new EmpDao().insertEmp(conn, ev);
		
		return result;
		
	}
	
	
	public int updateEmp(EmpVo ev) {
		
		EmpDao ed = new EmpDao();
		int result = ed.updateEmp(conn, ev);
		
		return result;
		
	}
	
	
	public int quitEmp(EmpVo ev) {
		
		EmpDao ed = new EmpDao();
		int result = ed.quitEmp(conn, ev);
		
		return result;
		
		
		
	}
	
}
