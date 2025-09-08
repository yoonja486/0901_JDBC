package com.kh.employee.model.vo;

public class EmpVo {

	private String empId; 
	private String empName;
	private String empNo;
	private String email;
	private String phone;
	private String deptCode;
	private String jobCode;
	private String salLevel;
	private int salary;
	private Double bonus;
	private String managerId;
	private String hireDate;
	private String entDate;
	private String entYn;
	private String deptTitle;
	private String jobName;
	
	
	public EmpVo() {
		super();
	}

	public EmpVo(String empName, String empNo, String jobCode, String salLevel) {
		super();
		this.empName = empName;
		this.empNo = empNo;
		this.jobCode = jobCode;
		this.salLevel = salLevel;
	}

	public String getEmpId() {
		return empId;
	}
	
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	public String getEmpName() {
		return empName;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public String getEmpNo() {
		return empNo;
	}
	
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getDeptCode() {
		return deptCode;
	}
	
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getJobCode() {
		return jobCode;
	}
	
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
	
	public String getSalLevel() {
		return salLevel;
	}
	
	public void setSalLevel(String salLevel) {
		this.salLevel = salLevel;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public double getBonus() {
		return bonus;
	}
	
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	public String getManagerId() {
		return managerId;
	}
	
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	
	public String getHireDate() {
		return hireDate;
	}
	
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	
	public String getEntDate() {
		return entDate;
	}
	
	public void setEntDate(String entDate) {
		this.entDate = entDate;
	}
	
	public String getEntYn() {
		return entYn;
	}
	
	public void setEntYn(String entYn) {
		this.entYn = entYn;
	}

	public String getDeptTitle() {
		return deptTitle;
	}

	public void setDeptTitle(String deptTitle) {
		this.deptTitle = deptTitle;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
	
}
