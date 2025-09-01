package com.kh.emp.ctrl;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.emp.vo.EmpVo;

public class EmpCtrl {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rset = null;
	
	public EmpCtrl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(ClassNotFoundException e) {
			System.out.println("ojdbc추가했나요?");
			System.out.println("oracle.jdbc.driver.OracleDriver오타없나요?" + e.toString());
		}
	}
	
	public List<EmpVo> searchName(String name) {
		String query = "SELECT * FROM EMPLOYEE\r\n"
				+ "WHERE EMP_NAME LIKE '%" + name + "%' ";
		List<EmpVo> outList = new ArrayList<EmpVo>();
		try {
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE","HGJ20","HGJ201234");
			System.out.println("DB서버 접속 성공!");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			while(rset.next()) {
				EmpVo ev = new EmpVo();
				ev.setEmpName(rset.getString("EMP_NAME"));
				ev.setEmpId(rset.getString("EMP_ID"));
				outList.add(ev);
			}
			
		}  catch(SQLException e1) {
			System.out.println("sql 오류 " + e1.toString());
		} finally {
			
			try {
				if(rset != null && !rset.isClosed()) {
					rset.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			try {
				if(stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return outList;
	}
	
	public int insUser(EmpVo ev) {
		int i = 0;
		String query = "INSERT INTO EMPLOYEE"
				+ "(SAL_LEVEL, JOB_CODE, EMP_NO, EMP_NAME, EMP_ID) "
				+ "VALUES('"+ ev.getSalLevel() + "'" 
				+ ",'"+ ev.getJobCode() + "'"
				+ ",'"+ ev.getEmpNo() + "'"
				+ ",'"+ ev.getEmpName() + "'"
				+ ",'"+ ev.getEmpId() + "')";
		
		try {
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE","HGJ20","HGJ201234");
			System.out.println("DB서버 접속 성공!");
			stmt = conn.createStatement();
			i = stmt.executeUpdate(query);

		}  catch(SQLException e1) {
			System.out.println("sql 오류 " + e1.toString());
		} finally {
			
			try {
				if(rset != null && !rset.isClosed()) {
					rset.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			try {
				if(stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return i;
	}
	
}
