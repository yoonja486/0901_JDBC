package com.kh.employee.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.employee.model.vo.EmpVo;

public class EmpDao {

	private Properties prop = new Properties();
	
	public EmpDao() {
		
		try {
			prop.loadFromXML(new FileInputStream("emp-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<EmpVo> findAll(Connection conn) {
		
		List<EmpVo> evs = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("findAll");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
		while(rset.next()) {
			EmpVo ev = new EmpVo();
			ev.setEmpId(rset.getString("EMP_ID"));
			ev.setEmpName(rset.getString("EMP_NAME"));
			ev.setSalary(rset.getInt("SALARY"));
			ev.setDeptTitle(rset.getString("DEPT_TITLE"));
			ev.setJobName(rset.getString("JOB_NAME"));
			evs.add(ev);
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return evs;
		}
	}
	
	
	public List<EmpVo> deptSearch(Connection conn, String deptTitle){
		
		List<EmpVo> evs = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("deptSearch");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deptTitle);
			rset = pstmt.executeQuery();
			
		while(rset.next()) {
			EmpVo ev = new EmpVo();
			ev.setEmpName(rset.getString("EMP_NAME"));
			ev.setDeptTitle(rset.getString("DEPT_TITLE"));
			evs.add(ev);
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return evs;
			}
		}
	
	
	
	public List<EmpVo> jobSearch(Connection conn, String jobName) {
		
		List<EmpVo> evs = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("jobSearch");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jobName);
			rset = pstmt.executeQuery();
			
		while(rset.next()) {
			EmpVo ev = new EmpVo();
			ev.setEmpName(rset.getString("EMP_NAME"));
			ev.setJobName(rset.getString("JOB_NAME"));
			evs.add(ev);
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return evs;
		
		}
	}
	
	public List<EmpVo> empIdDtl(Connection conn, String empId) {
		
		List<EmpVo> evs = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("empIdDtl");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empId);
			rset = pstmt.executeQuery();
			
		while(rset.next()) {
			EmpVo ev = new EmpVo();
			ev.setEmpId(rset.getString("EMP_ID"));
			ev.setEmpName(rset.getString("EMP_NAME"));
			ev.setEmpNo(rset.getString("EMP_NO"));
			ev.setEmail(rset.getString("EMAIL"));
			ev.setPhone(rset.getString("PHONE"));
			ev.setDeptCode(rset.getString("DEPT_CODE"));
			ev.setJobCode(rset.getString("JOB_CODE"));
			ev.setSalLevel(rset.getString("SAL_LEVEL"));
			ev.setSalary(rset.getInt("SALARY"));
			ev.setBonus(rset.getDouble("BONUS"));
			ev.setManagerId(rset.getString("MANAGER_ID"));
			ev.setHireDate(rset.getString("HIRE_DATE"));
			ev.setEntDate(rset.getString("ENT_DATE"));
			ev.setEntYn(rset.getString("ENT_YN"));
			evs.add(ev);
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return evs;
		}
	}
	
	
	public List<EmpVo> maxSalary(Connection conn) {
		
		List<EmpVo> evs = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("maxSalary");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();

		while(rset.next()) {
			EmpVo ev = new EmpVo();
			ev.setEmpId(rset.getString("EMP_ID"));
			ev.setEmpName(rset.getString("EMP_NAME"));
			ev.setEmpNo(rset.getString("EMP_NO"));
			ev.setJobCode(rset.getString("JOB_CODE"));
			ev.setSalary(rset.getInt("SALARY"));
			evs.add(ev);
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return evs;
		}
	}
	
	public List<EmpVo> minSalary(Connection conn) {
		
		List<EmpVo> evs = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("minSalary");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();

		while(rset.next()) {
			EmpVo ev = new EmpVo();
			ev.setEmpId(rset.getString("EMP_ID"));
			ev.setEmpName(rset.getString("EMP_NAME"));
			ev.setEmpNo(rset.getString("EMP_NO"));
			ev.setJobCode(rset.getString("JOB_CODE"));
			ev.setSalary(rset.getInt("SALARY"));
			evs.add(ev);
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return evs;
		}
	}	
	
	
	public int insertEmp(Connection conn, EmpVo ev) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("insertEmp");		     
		
		
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, ev.getEmpName());
			pstmt.setString(2, ev.getEmpNo());
			pstmt.setString(3, ev.getJobCode());
			pstmt.setString(4, ev.getSalLevel());
			// 1
			result = pstmt.executeUpdate();
			if(result > 0) {
				conn.commit();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		return result;
	}
	
	
	public int updateEmp(Connection conn, EmpVo ev) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("updateEmp");		     
		
		
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			String ss = String.valueOf(ev.getSalary());
			pstmt.setString(1, ss);
			pstmt.setString(2, ev.getJobCode());
			pstmt.setString(3, ev.getDeptCode());
			pstmt.setString(4, ev.getEmpId());
			// 1
			result = pstmt.executeUpdate();
			if(result > 0) {
				conn.commit();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		return result;
	}
	
	
	public int quitEmp(Connection conn, EmpVo ev) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("quitEmp");		     
		
		
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ev.getEntYn());
			pstmt.setString(2, ev.getEntDate());
			pstmt.setString(3, ev.getEmpId());
			// 1
			result = pstmt.executeUpdate();
			if(result > 0) {
				conn.commit();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		return result;
		
	}
	
}