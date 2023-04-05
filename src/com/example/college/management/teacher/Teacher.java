package com.example.college.management.teacher;

import com.example.address.Address;

public class Teacher {
	private int teacherID;
	private String teacherName;
	private Long teacherMobileNo;
	private String teacherEmail;
	private String teacherTeachSubject;
	Address teacherAddress;
	private String specification;
	private String branch;
	public int getTeacherID() {
		return teacherID;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public Long getTeacherMobileNo() {
		return teacherMobileNo;
	}
	public String getTeacherEmail() {
		return teacherEmail;
	}
	public String getTeacherTeachSubject() {
		return teacherTeachSubject;
	}
	
	public String getSpecification() {
		return specification;
	}
	public String getBranch() {
		return branch;
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(int teacherID, String teacherName, Long teacherMobileNo, String teacherEmail,
			String teacherTeachSubject, Address teacherAddress, String specification, String branch) {
		super();
		this.teacherID = teacherID;
		this.teacherName = teacherName;
		this.teacherMobileNo = teacherMobileNo;
		this.teacherEmail = teacherEmail;
		this.teacherTeachSubject = teacherTeachSubject;
		this.teacherAddress = teacherAddress;
		this.specification = specification;
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Teacher [teacherID=" + teacherID + ", teacherName=" + teacherName + ", teacherMobileNo="
				+ teacherMobileNo + ", teacherEmail=" + teacherEmail + ", teacherTeachSubject=" + teacherTeachSubject
				+ ", teacherAddress=" + teacherAddress + ", specification=" + specification + ", branch=" + branch
				+ "]";
	}
	
}
