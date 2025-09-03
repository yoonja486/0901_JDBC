package com.kh.music.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.music.vo.MusicVo;

public class MusicDao {
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@115.90.212.20:10000:XE";
	private final String USERNAME = "HGJ20";
	private final String PASSWORD = "HGJ201234";
	Connection conn = null;
	
	public MusicDao() {
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch(Exception e ) {
			System.out.println( e.toString());
		}
		
	}

	public int musicInsert(MusicVo musicVo) {
		// Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = """
			     INSERT
			       INTO
			            TB_MUSIC(MUSIC_ID, TITLE, ARTISTS, GENRE, RELEASE_DATE, SONGWRITER, LYRICIST)
			     VALUES
			            (
			            (SELECT count(*) + 1 FROM TB_MUSIC)
			          , ?
			          , ?
			          , ? 
			          , TO_DATE(TO_CHAR(?),'YYYYMMDD')
			          , ?
			          , ? 
			            )
				""";
		
		try {
			// Class.forName(DRIVER);
			// conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			if(conn == null) {
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			}
			
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, musicVo.getTitle());
			pstmt.setString(2, musicVo.getArtists());
			pstmt.setString(3, musicVo.getGenre());
			pstmt.setString(4, musicVo.getReleaseDate());
			pstmt.setString(5, musicVo.getSongwriter());
			pstmt.setString(6, musicVo.getLyricist());
			result = pstmt.executeUpdate();
			
			
			if(result > 0) {
				conn.commit();
			}
			
			
		// } catch (ClassNotFoundException e) {
		//	e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		return result;
	}
	
public List<MusicVo> titleSearch(String title){
		
		//Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<MusicVo> mvos = new ArrayList();
		
		String sql = """
				        SELECT
				        	   MUSIC_ID 
				             , TITLE
				             , ARTISTS
				             , GENRE
				             , RELEASE_DATE
				             , SONGWRITER
				             , LYRICIST
				             , ENTERTAINMENT
				          FROM
				               MUSIC
				         WHERE
				               TITLE LIKE '%'||?||'%'
				          ORDER BY MUSIC_ID
					""";
		
		try {
			//Class.forName(DRIVER);
			if(conn == null) {
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			rset = pstmt.executeQuery();
			
			
	 // } catch (ClassNotFoundException e) {
			//e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mvos;
	}
	

}
