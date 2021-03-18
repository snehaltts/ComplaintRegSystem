package com.ltts.project.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String empName;
	private String designation;
	private String department;
	private String immediateSupervisor;
	private String password;
	private String email;
	private String mobile;

	@Id
	private String empId;


	public Employee() {
		super();
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getImmediateSupervisor() {
		return immediateSupervisor;
	}

	public void setImmediateSupervisor(String immediateSupervisor) {
		this.immediateSupervisor = immediateSupervisor;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public Employee(String empName, String designation, String department, String immediateSupervisor, String password,
			String email, String mobile, String empId) {
		super();
		this.empName = empName;
		this.designation = designation;
		this.department = department;
		this.immediateSupervisor = immediateSupervisor;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "Employee [empId = " + empId + "empName=" + empName + ", designation=" + designation + ", department=" + department
				+ ", immediateSupervisor=" + immediateSupervisor + ", password=" + password + ", email=" + email
				+ ", mobile=" + mobile + "]";
	}

}
