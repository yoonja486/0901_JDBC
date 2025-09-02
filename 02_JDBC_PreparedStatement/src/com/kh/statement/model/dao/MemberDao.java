package com.kh.statement.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.statement.model.dto.PasswordDTO;
import com.kh.statement.model.vo.Member;

public class MemberDao {
	
	/*
	 * DAO(Date Access Object)
	 * 
	 * 지금 시점 DAO에서는 DateBase 관련된 작업(CRUD)를 전문적으로 담당하는 객체
	 * DAO안에 있는 모든 메소드를 데이터베이스 관련된 작업으로 구성할 것
	 * 
	 * SQL
	 * SELECT / INSERT / UPDATE / DELETE
	 * 
	 * 하나의 메소드는 하나의 SQL문만 실행할 것!
	 * 
	 * Controller를 통해 호출된 기능을 수행! -> 02번 프로젝트까지만
	 * DB에 직접 접근한 후 해당 SQL문을 실행한 후 결과 받아오기(JDBC)
	 */

	/*
	 * JDBC용 객체
	 * 
	 * - Connection : DB와의 연결정보를 담는 객체(IP주소, Port번호, 사용자이름, 비밀번호)
	 * - Statement 	: Connection에 담겨있는 연결정보 DB에 SQL문을 보내서 실행하고 결과도 받아오는 다재다능 객체
	 * - ResultSet	: 실행한 SQL문이 SELECT문일 경우 조회된 결과가 처음 담겨있는 객체
	 * - PreparedStatement : SQL문을 미리 준비하는 개념
	 * 						 미완성된 SQL문을 미리 전달하고 실행하기 전 완성형태로 만든 뒤 SQL문을 실행함
	 * 						 미완성된 SQL문에 사용자가 입력한 값들이 들어갈 수 있도록 공간을 확보해놓음 ==> placeholder/위치홀더)
	 * 
	 * - Statement(부모)와 PreparedStatement(자식)은 부모자식 관계
	 *
	 * -> 차이점
	 * 1) Statement는 완성된 SQL문, PreparedStatement는 미완성된 SQL문
	 * 
	 * 2) 객체 생성 방법
	 * 	  Statement == 커넥션객체.createStatement()
	 * 	  PreparedStatement == 커넥션객체.preparedStatement(sql); <-- 요게 핵심!
	 * 
	 * 3) SQL문 실행
	 * 	  Statement == stmt.executeXXX(sql);
	 * 	  PreparedStatement == pstmt.executeXXX();
	 * 
	 * ? 위치홀더에 실제 값을 Binding해준 뒤 실행한다.
	 * pstmt.setString()
	 * pstmt.setInt()
	 * 
	 * -- JDBC 절차
	 * 
	 * 0) 필요한 변수들 세팅
	 * 1) JDBC Driver 등록 : 해당 DBMS에서 제공하는 클래스를 String 형으로 동적으로 등록
	 * 2) Conntion 객체 생성 : DB와의 세션연결 연결할 때 필요한 정보를 인자로 전달(URL, 사용자이름, 비밀번호)
	 * 3_1) PreparedStatement 객체 생성 : Connection 객체 생성(미완성된 SQL문을 생성과 동시에 꼭 전달!!!)
	 * 3_2) 현재 미완성된 SQL문을 완성형태로 만들어주기
	 * 		=> 미완성일 경우에만 해당 / 완성된 경우에는 생략
	 * 4) SQL문 실행 : executeXXX() => SQL을 절대로 인자로 전달하지 않음!! 
	 * 				> SELECT : executeQuery()
	 * 				> INSERT / UPDATE / DELETE : executeUpdate()
	 * 5) 결과받기 :
	 * 				> SELECT : ResultSet(조회된 데이터들이 담겨있음)
	 * 				> INSERT / UPDATE / DELETE : int(처리된 행의 개수)
	 * 6) SELECT : Result에 담겨있는 컬럼값들을 커서를 옮겨가며 한 행씩 접근해서 하나하나 뽑아서 VO객체의 필드에 매핑(옮겨담기)
	 * 			   / VO객체가 여러개 일 경우 -> VO들을 List의 요소로 관리
	 * 		INSERT / UPDATE / DELETE : 트랜잭션 처리
	 * 7) 사용이 다 끝난 JDBC용 객체들을 생성의 역순으로 자원 반납 -> close()
	 * 8) 결과 반환
	 *    SELECT -> 6에서 만든거
	 *    INSERT / UPDATE / DELETE -> 처리된 행의 개수
	 */

	public int save(Member member) {
		
		// 0) 필요한 변수들을 선언해보자!
		Connection conn = null;		// DB와의 세션
		PreparedStatement pstmt = null;		// SQL문 실행 후 결과 받기
		int result = 0;
		
		// SQL문
		String sql = """
					    INSERT
					      INTO
					           MEMBER
					    VALUES
					           (
					           SEQ_USERNO.NEXTVAL
					         , ?
					         , ?
					         , ?
					         , ?
					         , SYSDATE
					           )
					""";
		
		try {
			// 1) JDBC Driver 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2) Connection 객체 생성(DB와 연결하겠다)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE","HGJ20","HGJ201234");
			conn.setAutoCommit(false);
			
			// 3_1) PreparedStatement객체 생성(SQL문을 미리 전달해야함!)
			pstmt = conn.prepareStatement(sql);
			
			// ID, PWD, NAME, EMAIL
			
			// 3_2) 미완성된 SQL문일 경우 완성시켜주기
			// 위치홀더에 값 바인딩
			// pstmt.setXXX(?의 위치, 실제값);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4, member.getEmail());
			
			// pstmt.setString(홀더순번, 값)
			// => '값' (양옆에 홑따옴표를 감싼 상태로 알아서 Bind)
			// pstmt.setInt(홀더순번, 값)
			// => 값 (알아서 잘 들어감 따옴표 안붙임)
			
			// 4, 5) DB에 전달된 SQL문을 실행하고 결과(처리된 행 수) 받기
			result = pstmt.executeUpdate();
			
			// 6) 트랜잭션 처리
			if(result > 0) {
				conn.commit();
			}
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			// 7) 다 쓴 JDBC용 객체 자원반납 => 생성의 역순으로 close()
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		// 8) 결과반환
		return result;
	}
		
	

}

















