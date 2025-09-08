package com.kh.emp.menu;

import java.util.List;
import java.util.Scanner;

import com.kh.emp.ctrl.EmpCtrl;
import com.kh.emp.vo.EmpVo;

public class Menu {

	Scanner sc = new Scanner(System.in);
	EmpCtrl ec = new EmpCtrl();
	
	public void getMenu() {
		boolean isExit = true;
		while(isExit) {
			System.out.println("회원 정보 서비스 입니다.");
			System.out.println("1. 이름 조회");
			System.out.println("2. 회원 등록");
			System.out.println("3. 회원 수정");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 전체 조회");
			System.out.println("6. 프로그램 종료");
			System.out.println("무엇을 하시겠습니까? > ");
			int i = sc.nextInt();
			sc.nextLine();
			
			switch(i) {
			case 1 : 
				searchName(); 
				break;
			case 2 : 
				insUser(); 
				break;
			case 3 : break;
			case 4 : break;
			case 5 : break;
			case 6 : isExit = false;
				System.out.println("종료되었습니다.");
				break;
			default : System.out.println("잘 못 누르셨습니다. 다시 입력해주세요."); break;
		
			}
		}
	}
		
	public void searchName() {
		String nm = "";
		System.out.println("검색하실 이름을 입력해주세요 > ");
		nm = sc.nextLine();
		List<EmpVo> ev = ec.searchName(nm);
		if(!ev.isEmpty()) {
			for(int i = 0; i < ev.size(); i++) {
				EmpVo ev2 = ev.get(i);
				System.out.println("[사번 " + ev2.getEmpId() + " " + ev2.getEmpName() + "]");
				System.out.println();
			}
		} else {
			System.out.println("검색하신 결과가 없습니다.");
		}
		getMenu();
	}
	
	public void insUser() {
		// SAL_LEVEL, JOB_CODE, EMP_NO, EMP_NAME, EMP_ID
		EmpVo evo = new EmpVo();
		System.out.println("등록하실 이름를 입력해주세요 > ");
		String empname = sc.nextLine();
		evo.setEmpName(empname);
		System.out.println("등록하실 주민번호를 입력해주세요 > ");
		evo.setEmpNo(sc.nextLine());
		evo.setSalLevel("S50");
		evo.setJobCode("J50");
		evo.setEmpId("225");
		System.out.println(evo.getEmpName() + " // " + evo.getEmpNo());
		int in = ec.insUser(evo);
		if(in > 0) {
			System.out.println("정상적으로 등록 되었습니다.");
		} else {
			System.out.println("등록에 실패하였습니다. 다시 입력해주세요.");
		}
		getMenu();
	}
	
	
}
