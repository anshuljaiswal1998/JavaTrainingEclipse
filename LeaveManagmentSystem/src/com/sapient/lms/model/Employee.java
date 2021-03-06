package com.sapient.lms.model;

public class Employee {
	
	private int empId;
	private String name;
	private String Dept;
	LeaveDetails details = null;

	public Employee() {
		details = new LeaveDetails();
	}
	
	public Employee(String name,String dept) {
		this.name = name;
		this.Dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", Dept=" + Dept + "]";
	}

	public LeaveDetails getDetails() {
		return details;
	}

	public void setDetails(LeaveDetails details) {
		this.details = details;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return Dept;
	}

	public void setDept(String dept) {
		Dept = dept;
	}

}
