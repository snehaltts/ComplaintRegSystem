package com.ltts.project.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Department implements Serializable {
	private String departmentName;
	private String empId;
	private String issueType;

	@Id
	@GeneratedValue
	private int departmentId;

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public Department(String departmentName, String empId, String issueType, int departmentId) {
		super();
		this.departmentName = departmentName;
		this.empId = empId;
		this.issueType = issueType;
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "Department [departmentName=" + departmentName + ", empId=" + empId + ", issueType=" + issueType
				+ ", departmentId=" + departmentId + "]";
	}
	
	public Department()
	{
		super();
	}

}
