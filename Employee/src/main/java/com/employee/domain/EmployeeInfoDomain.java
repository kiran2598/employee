package com.employee.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_list")
public class EmployeeInfoDomain {
	
	@Id
	@Column(name = "emp_id")
	private int empid;
	@Column(name = "emp_name")
	private String empname;
	@Column(name  = "dept")
	private String dept;
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}

}
