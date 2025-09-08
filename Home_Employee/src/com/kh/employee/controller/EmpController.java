package com.kh.employee.controller;

import java.util.List;

import com.kh.employee.model.vo.EmpVo;
import com.kh.employee.service.EmpService;

public class EmpController {

	public List<EmpVo> findAll(){
		
		EmpService es = new EmpService();
		List ev = es.findAll();
		
		return ev;
	}
	
	
	public List<EmpVo> deptSearch(String deptTitle){
		
		EmpService es = new EmpService();
		List ev = es.deptSearch(deptTitle);
		
		return ev;
	}
	
	
	public List<EmpVo> jobSearch(String jobName) {
		
		EmpService es = new EmpService();
		List ev = es.jobSearch(jobName);
		
		return ev;
		
	}
	
	
	public List<EmpVo> empIdDtl(String empId) {
		
		EmpService es = new EmpService();
		List ev = es.empIdDtl(empId);
		
		return ev;
		
	}

	
	public List<EmpVo> maxSalary() {
		
		EmpService es = new EmpService();
		List ev = es.maxSalary();
		
		return ev;
	}
	
	
	public List<EmpVo> minSalary() {
		
		EmpService es = new EmpService();
		List ev = es.minSalary();
		
		return ev;
		
	}
	
	
	public int insertEmp(String empName, String empNo, String jobCode, String salLevel) {
		
		EmpVo ev = new EmpVo(empName, empNo, jobCode, salLevel);
		
		int result = new EmpService().insertEmp(ev);
		
		return result;
	}
	
	
	
	public int updateEmp(String empId, String salary, String jobCode, String deptCode) {
		
		EmpVo ev = new EmpVo();
		ev.setEmpId(empId);
		int sal = Integer.parseInt(salary);
		ev.setSalary(sal);
		ev.setJobCode(jobCode);
		ev.setDeptCode(deptCode);
		
		EmpService es = new EmpService();
		int result = es.updateEmp(ev);
		
		
		return result;
		
	}
	
	
	public int quitEmp(String empId, String entYn, String entDate) {
		
		EmpVo ev = new EmpVo();
		ev.setEmpId(empId);
		ev.setEntYn(entYn);
		ev.setEntDate(entDate);
		
		EmpService es = new EmpService();
		int result = es.quitEmp(ev);
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
