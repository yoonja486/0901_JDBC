package com.kh.board.model.dto;

import java.sql.Date;

public class BoardDTO {

	private int boardNo; 		 
	private String boardTitle; 	
	private String boardContent; 
	private String boardWriter; 	 
	private Date createDate; 	 
	private String daleteStatus;
	

	public BoardDTO() {
		super();
	}


	public BoardDTO(String boardTitle, String boardContent, String boardWriter) {
		super();
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
	}


	public BoardDTO(int boardNo, String boardTitle, String boardContent, String boardWriter, Date createDate,
			String daleteStatus) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
		this.createDate = createDate;
		this.daleteStatus = daleteStatus;
	}


	public int getBoardNo() {
		return boardNo;
	}


	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}


	public String getBoardTitle() {
		return boardTitle;
	}


	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}


	public String getBoardContent() {
		return boardContent;
	}


	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}


	public String getBoardWriter() {
		return boardWriter;
	}


	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public String getDaleteStatus() {
		return daleteStatus;
	}


	public void setDaleteStatus(String daleteStatus) {
		this.daleteStatus = daleteStatus;
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
