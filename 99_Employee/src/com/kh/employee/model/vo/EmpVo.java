package com.kh.employee.model.vo;

import java.util.Objects;

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
	private int bonus;
	private String managerId;
	private String hireDate;
	private String entDate;
	private String entYn;
	
	
	public EmpVo() {
		super();
	}


	public EmpVo(String empId, String empName, String empNo, String email, String phone, String deptCode,
			String jobCode, String salLevel, int salary, int bonus, String managerId, String hireDate, String entDate,
			String entYn) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empNo = empNo;
		this.email = email;
		this.phone = phone;
		this.deptCode = deptCode;
		this.jobCode = jobCode;
		this.salLevel = salLevel;
		this.salary = salary;
		this.bonus = bonus;
		this.managerId = managerId;
		this.hireDate = hireDate;
		this.entDate = entDate;
		this.entYn = entYn;
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


	public int getBonus() {
		return bonus;
	}


	public void setBonus(int bonus) {
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


	@Override
	public int hashCode() {
		return Objects.hash(bonus, deptCode, email, empId, empName, empNo, entDate, entYn, hireDate, jobCode, managerId,
				phone, salLevel, salary);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpVo other = (EmpVo) obj;
		return bonus == other.bonus && Objects.equals(deptCode, other.deptCode) && Objects.equals(email, other.email)
				&& Objects.equals(empId, other.empId) && Objects.equals(empName, other.empName)
				&& Objects.equals(empNo, other.empNo) && Objects.equals(entDate, other.entDate)
				&& Objects.equals(entYn, other.entYn) && Objects.equals(hireDate, other.hireDate)
				&& Objects.equals(jobCode, other.jobCode) && Objects.equals(managerId, other.managerId)
				&& Objects.equals(phone, other.phone) && Objects.equals(salLevel, other.salLevel)
				&& salary == other.salary;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
