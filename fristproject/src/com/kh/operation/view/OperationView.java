package com.kh.operation.view;

import java.util.Scanner;

public class OperationView {

	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		
		while(true) {
		System.out.println("==========도서관 관리 프로그램==========");
		
		
		System.out.println("1. 도서 관리 서비스");
		System.out.println("2. 회원 관리 서비스");
		System.out.println("0. 프로그램 종료");
		System.out.print("메뉴를 입력하세요 > ");
		int menuNo = sc.nextInt();
		sc.nextLine();
		
		switch(menuNo) {
		case 1: break;
		case 2: break;
		case 0: System.out.println("프로그램을 종료합니다.");return;
		
		default : System.out.println("잘못된 입력입니다.");
		
		
		
		}
	
		
		
		
		
		
		
		
		
		}
		
		
		
		
		
	}
	
	
}
