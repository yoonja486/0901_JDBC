package com.kh.music.view;

import java.util.Scanner;

import com.kh.music.controller.MusicController;
import com.kh.music.vo.MusicVo;

public class MusicView {

	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();
	private MusicVo mv = new MusicVo();
	
	public void mainMenu() {
		
		while(true) {
			System.out.println();
			System.out.println(" 🎼🎶 뮤직 차트 서비스 🎼🎶");
			System.out.println("1. 뮤직 추가");
			System.out.println("2. 뮤직 타이틀 검색");
			System.out.println("3. 뮤직 전체 조회");
			System.out.println("4. 뮤직 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.println("원하시는 메뉴를 선택해주세요 > ");
			int i = sc.nextInt();
			sc.nextLine();
			
		switch(i) {
		case 1 : musicInsert(); break;
		case 2 : titleSearch(); break;
		case 3 : break;
		case 4 : break;
		case 0 : System.out.println("프로그램을 종료합니다."); return;
		default : System.out.println("번호를 잘 못 선택하셨습니다.");
			}
		}
	}
	
	private void musicInsert() {
		
		System.out.println();
		System.out.println("🎹 뮤직 추가 서비스입니다. 🎹");
		System.out.println("타이틀명을 적어주세요 > ");
		String title = sc.nextLine();
		System.out.println("아티스트를 적어주세요 > ");
		String artists = sc.nextLine();
		System.out.println("장르를 적어주세요 > ");
		String genre = sc.nextLine();
		System.out.println(title + " / " + artists + " / " + genre + " 뮤직이 추가 되었습니다.");
		
		mc.musicInsert(title, artists, genre);
		
	}
	
	private void titleSearch() {
		
		System.out.println("🎻 뮤직 타이틀 검색 서비스 🎻");
		System.out.println("검색하실 타이틀명을 적어주세요 > ");
		String title = sc.nextLine();
		
		
	}
	
	
	
	
	
	
	
}
