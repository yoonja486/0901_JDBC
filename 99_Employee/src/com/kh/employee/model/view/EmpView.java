package com.kh.employee.model.view;

import java.util.Scanner;

import com.kh.employee.controller.EmpController;

public class EmpView {

	private Scanner sc = new Scanner(System.in);
	private EmpController ec = new EmpController();
	
	public void mainMenu() {
		
		while(true) {
			System.out.println("직원들 정보 서비스");
			System.out.println("1. 회원 전체 조회");
			System.out.println("2. 부서명 조회");
			System.out.println("3. 직급명 조회");
			System.out.println("4. 사원 상세 조회");
			System.out.println("5. 급여 높은 사원 조회");
			System.out.println("6. 급여 낮은 사원 조회");
			System.out.println("7. 사원 추가 등록");
			System.out.println("8. 사원 정보 수정");
			System.out.println("9. 퇴사 사원 수정");
			System.out.println("0. 프로그램 종료");
			System.out.println("메뉴 번호를 입력해주세요 > ");
			int menuNo = sc.nextInt();
			sc.nextLine();
			
			
		switch(menuNo) {
		case 1 : findAll(); break;
		case 2 : deptSearch(); break;
		case 3 : break;
		case 4 : break;
		case 5 : break;
		case 6 : break;
		case 7 : break;
		case 8 : break;
		case 9 : break;
		case 0 : break;
		}
			
		}
	
	}
	
	private void findAll() {
		
		
	}
	
	private void deptSearch() {
		System.out.println("찾으시는 부서명을 입력해주세요 > ");
		String deptTitle = sc.nextLine();
		System.out.println("부서가 동일한 사원 목록은 " + deptTitle);
		
		
	}
	
	
	
	
	}
	
