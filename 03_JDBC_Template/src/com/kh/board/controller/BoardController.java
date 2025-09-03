package com.kh.board.controller;

import java.util.List;

import com.kh.board.model.dto.BoardDTO;
import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;

public class BoardController {

	public int insertBoard(BoardDTO bd) {

		int result = new BoardService().insertBoard(bd);
		return result;
	}
	
	
	public List<Board> selectBoardList(){
		List<Board> boards = new BoardService().selectBoardList();
		return boards;
		
	}
}
