package com.kh.music.vo;

public class MusicVo {

	private int musicId;    	  // MUSIC_ID NUMBER PRIMARY KEY,
	private String title;   	  // TITLE VARCHAR2(200) NOT NULL,
    private String artists; 	  // ARTISTS VARCHAR2(100) NOT NULL,
    private String genre;	      // GENRE VARCHAR2(100),
    private String releaseDate;   // RELEASE_DATE DATE,
    private String songwriter;    // SONGWRITER VARCHAR2(50),
    private String lyricist;	  // LYRICIST VARCHAR2(50),
    private String entertainment; // ENTERTAINMENT VARCHAR2(100)
	
    public MusicVo() {
		super();
	}

    public MusicVo(int musicId, String title, String artists, String genre) {
		super();
		this.musicId = musicId;
		this.title = title;
		this.artists = artists;
		this.genre = genre;
	}
    
	public MusicVo(int musicId, String title, String artists, String genre, String releaseDate, String songwriter,
			String lyricist, String entertainment) {
		super();
		this.musicId = musicId;
		this.title = title;
		this.artists = artists;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.songwriter = songwriter;
		this.lyricist = lyricist;
		this.entertainment = entertainment;
	}

	public int getMusicId() {
		return musicId;
	}

	public void setMusicId(int musicId) {
		this.musicId = musicId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtists() {
		return artists;
	}

	public void setArtists(String artists) {
		this.artists = artists;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getSongwriter() {
		return songwriter;
	}

	public void setSongwriter(String songwriter) {
		this.songwriter = songwriter;
	}

	public String getLyricist() {
		return lyricist;
	}

	public void setLyricist(String lyricist) {
		this.lyricist = lyricist;
	}

	public String getEntertainment() {
		return entertainment;
	}

	public void setEntertainment(String entertainment) {
		this.entertainment = entertainment;
	}

	@Override
	public String toString() {
		return "MusicVo [musicId=" + musicId + ", title=" + title + ", artists=" + artists + ", genre=" + genre
				+ ", releaseDate=" + releaseDate + ", songwriter=" + songwriter + ", lyricist=" + lyricist
				+ ", entertainment=" + entertainment + "]";
	}
	
	
	
    
    
}
