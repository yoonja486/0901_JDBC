package com.kh.employee.model.view;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.kh.employee.controller.EmpController;
import com.kh.employee.model.vo.EmpVo;

public class EmpView {

	private Scanner sc = new Scanner(System.in);
	private EmpController ec = new EmpController();
	
	public void mainMenu() {
		
		boolean bl = true;
		while(bl) {
			System.out.println();
			System.out.println("===== 직원들 정보 서비스 =====");
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
			case 3 : jobSearch(); break;
			case 4 : empIdDtl(); break;
			case 5 : maxSalary(); break;
			case 6 : minSalary(); break;
			case 7 : insertEmp(); break;
			case 8 : updateEmp(); break;
			case 9 : quitEmp(); break;
			case 0 : 
				bl = false;
				System.out.println("프로그램을 종료합니다."); break;
			}
			
		}
	
	}
	
	private void findAll() {
		
		System.out.println();
		System.out.println("회원 전체 조회 서비스 입니다.");
		List<EmpVo> evs = ec.findAll();
		
		System.out.println();
		
		if(evs.isEmpty()) {
			System.out.println("조회된 목록이 없습니다.");
		} else {
			System.out.println("회원 전체 목록입니다.");
			for(int i = 0; i < evs.size(); i++) {
				EmpVo ev = evs.get(i);
				System.out.println("사번 : " + ev.getEmpId() +" / " + "이름 : " + ev.getEmpName() + " / "+ "급여 : " + ev.getSalary()
								+ " / " + "부서명 : " + ev.getDeptTitle() + " / " + "직급명 : " + ev.getJobName());
			}
		}
	}
	
	
	private void deptSearch() {
		
		System.out.println("찾으시는 부서명을 입력해주세요 > ");
		String deptTitle = sc.nextLine();
		List<EmpVo> evs = ec.deptSearch(deptTitle);
		
		if(evs.isEmpty()) {
			System.out.println("검색하신 부서명이 없습니다.");
		} else {
			System.out.println("검색된 결과입니다.");
			for(int i = 0; i < evs.size(); i++) {
				EmpVo ev = evs.get(i);
				System.out.println("이름 : " + ev.getEmpName() + " / " + "부서명 : " + ev.getDeptTitle());
			}
		}
	}

	
	private void jobSearch() {
		
		System.out.println("찾으시는 직급명을 입력해주세요 > ");
		String jobName = sc.nextLine();
		List<EmpVo> evs = ec.jobSearch(jobName);
		
		if(evs.isEmpty()) {
			System.out.println("검색하신 직급명이 없습니다.");
		} else {
			System.out.println("검색된 결과입니다.");
			for(int i = 0; i < evs.size(); i++) {
				EmpVo ev = evs.get(i);
				System.out.println("이름 : " + ev.getEmpName() + " / " + "직급명 : " + ev.getJobName());
			}
		}
	}


	public void empIdDtl() {
		
		System.out.println("사번을 입력해주세여 > ");
		String empId = sc.nextLine();
		List<EmpVo> evs = ec.empIdDtl(empId);
		
		if(evs.isEmpty()) {
			System.out.println("검색하신 사번이 없습니다.");
		} else {
			System.out.println("검색된 결과입니다.");
			for(int i = 0; i < evs.size(); i++) {
				EmpVo ev = evs.get(i);
				System.out.println("사번:" + ev.getEmpId() + " " + "이름:" + ev.getEmpName() + " " + "주민번호:" + 
				       ev.getEmpNo() + " " + "이메일:" + ev.getEmail() + " " + "전화번호:" + ev.getPhone() + " " +
					   "부서코드:" + ev.getDeptCode() + " " + "직급코드:" + ev.getJobCode() + " " + "급여레벨:" + 
				       ev.getSalLevel() + " " + "급여:" + ev.getSalary() + " " + "보너스:" + ev.getBonus() + " " +
					   "입사일자:" + ev.getHireDate());
			}
		}
	}

	// 5. 급여가 높은 사원
	public void maxSalary(){ 
		
		System.out.println("급여가 높은 다섯명의 목록입니다.");
		System.out.println();
		List<EmpVo> evs = ec.maxSalary();
		
		if(evs.isEmpty()) {
			System.out.println("조회된 목록이 없습니다.");
		} else {
			System.out.println("회원 전체 목록입니다.");
			for(int i = 0; i < evs.size(); i++) {
				EmpVo ev = evs.get(i);
				System.out.println("사번 : " + ev.getEmpId() + " / " + "이름 : " + ev.getEmpName() + " / " + "주민번호 : " 
				+ ev.getEmpNo() + " / " + "직급코드 : " + ev.getJobCode() + " / " + "급여 : " + ev.getSalary());
			}	
		}
	
	}
	
	// 6. 급여가 낮은 사원
	public void minSalary(){ 
		
		System.out.println("급여가 낮은 다섯명의 목록입니다.");
		System.out.println();
		List<EmpVo> evs = ec.minSalary();
		
		if(evs.isEmpty()) {
			System.out.println("조회된 목록이 없습니다.");
		} else {
			System.out.println("회원 전체 목록입니다.");
			for(int i = 0; i < evs.size(); i++) {
				EmpVo ev = evs.get(i);
				System.out.println("사번 : " + ev.getEmpId() + " / " + "이름 : " + ev.getEmpName() + " / " + "주민번호 : " 
				+ ev.getEmpNo() + " / " + "직급코드 : " + ev.getJobCode() + " / " + "급여 : " + ev.getSalary());
			}	
		}
	
	}
	
	
	// 7. 사원 추가
	public void insertEmp() {
		
		System.out.println("사원 추가 기능입니다.");
		System.out.println("이름을 입력해주세요 > ");
		String empName = sc.nextLine();
		System.out.println("주민번호를 입력해주세요 > ");
		String empNo = sc.nextLine();
		System.out.println("직업코드를 입력해주세요 > ");
		String jobCode = sc.nextLine();
		System.out.println("급여레벨을 입력해주세요 > ");
		String salLevel = sc.nextLine();
		
		int result = ec.insertEmp(empName, empNo, jobCode, salLevel);
		
			if(result > 0) {
				System.out.println("사원 추가에 성공하였습니다.");
			} else {
				System.out.println("사원 추가에 실패하였습니다.");
			}
		}

	
	// 8. 사원 정보 수정(사번을 입력받아 급여, 직급, 부서 수정)
	public void updateEmp() {
		
		System.out.println("사원 정보 수정 서비스 입니다.");
		System.out.println("수정하실 사번을 입력해주세요 > ");
		String empId = sc.nextLine();
		System.out.println("수정하실 급여를 입력해주세요 > ");
		String salary = sc.nextLine();
		System.out.println("수정하실 직급을 입력해주세요 > ");
		String jobCode = sc.nextLine();
		System.out.println("수정하실 부서를 입력해주세요 > ");
		String deptCode = sc.nextLine();
		
		int result = ec.updateEmp(empId, salary, jobCode, deptCode);

		if(result > 0) {
			System.out.println("정상적으로 수정되었습니다.");
		} else {
			System.out.println("수정 실패되었습니다.");
		}
		
	}
	

	// 9. 사원 퇴사 기능(사번을 입력받아 퇴사 여부, 퇴사일 수정)
	public void quitEmp() {
		
		System.out.println("퇴사 사원 수정 서비스 입니다.");
		System.out.println("퇴사 사원 사번을 입력해주세요 > ");
		String empId = sc.nextLine();
		System.out.println("퇴사 여부를 (Y 또는 N)으로 입력해주세요 > ");
		String entYn = sc.nextLine();
		System.out.println("퇴사일을 입력해주세요 > ");
		String entDate = sc.nextLine();
		
		int result = ec.quitEmp(empId, entYn, entDate);
		
		if(result > 0) {
			System.out.println("정상적으로 수정되었습니다.");
		} else {
			System.out.println("수정 실패하였습니다.");
		}
	
	
	}
	
	
	
}
