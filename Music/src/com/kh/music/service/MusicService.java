package com.kh.music.service;

import java.sql.Connection;

import com.kh.music.common.JDBCTemplate;

public class MusicService {

	private Connection conn = null;
	
	public MusicService() {
		
		conn = JDBCTemplate.getConnection();
	}
	
	
	public void MusicInsert() {
		
	}
	
}
