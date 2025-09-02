package com.kh.music.controller;

import java.util.List;

import com.kh.music.dao.MusicDao;
import com.kh.music.vo.MusicVo;

public class MusicController {

	private MusicDao mDao = new MusicDao();
	
	public int musicInsert(String title, String artists, String genre) {
		
		MusicVo mv = new MusicVo();
		mv.setTitle(title);
		mv.setArtists(artists);
		mv.setGenre(genre);
		int result = new MusicDao().musicInsert(mv);
		
		return result;
	}
	

	public List<MusicVo> titleSearch(String title){
		
		List<MusicVo> mvos = new MusicDao().titleSearch(title);
		
		return mvos;
		
	}

}
