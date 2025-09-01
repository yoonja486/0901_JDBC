package com.kh.music.dao;

import java.sql.Connection;
import java.sql.Statement;

public class MusicDao {

	// 0) 필요한 변수를 먼저 선언 및 null값으로 초기화
	Connection conn = null;	// 접속할 DB서버와의 연결정보를 담는 객체
	Statement stmt = null;	// SQL문 실행 후 결과를 받기 위한 객체
	int result = 0;			// DML 수행 후 결과를 받기 위한 변수
}
