package com.example.college.principle;

import com.example.branch.Branch;
import com.example.colleagestaff.College;
import com.example.record.AllStudentRecord;
import com.example.record.AllTeacherRecord;
import com.example.record.StudentRecord;
import com.example.record.TeacherRecord;
import com.example.specification.Specification;

public class EngineeringBranchRecord {
public void detailsRecord(String branch,College dept, Specification specification) {
	if(Specification.ENGINEERING ==specification) {	
	switch (branch.toUpperCase()) {
		case "CL":
			if(College.STUDENT==dept) {
			new StudentRecord(dept,Branch.Engineering.CIVIL, specification);
			}else {
				new TeacherRecord(dept,Branch.Engineering.CIVIL, specification);	
			}
			break;
		case "MECH":
			if(College.STUDENT==dept) {
				new StudentRecord(dept,Branch.Engineering.MECHANICAL, specification);
				}else {
					new TeacherRecord(dept,Branch.Engineering.MECHANICAL, specification);	
				}
				break;
		case "IT":
			if(College.STUDENT==dept) {
				new StudentRecord(dept,Branch.Engineering.IT, specification);
				}else {
					new TeacherRecord(dept,Branch.Engineering.IT, specification);	
				}
				break;
		case "COMP":
			if(College.STUDENT==dept) {
				new StudentRecord(dept,Branch.Engineering.COMPUTER, specification);
				}else {
					new TeacherRecord(dept,Branch.Engineering.COMPUTER, specification);	
				}
				break;
		case "E&T":
			if(College.STUDENT==dept) {
				new StudentRecord(dept,Branch.Engineering.ENTC, specification);
				}else {
					new TeacherRecord(dept,Branch.Engineering.ENTC, specification);	
				}
				break;
		case "ALL":
			if(College.STUDENT==dept) {
				new AllStudentRecord(dept,specification);
				}else {
					new AllTeacherRecord(dept,specification);	
				}
				break;
		default:
			System.out.println("Invalid Key Input");
		}
	}else {
		switch (branch.toUpperCase()) {
		case "BCA":
			if(College.STUDENT==dept) {
			new StudentRecord(dept,Branch.Graduation.BCA, specification);
			}else {
				new TeacherRecord(dept,Branch.Graduation.BCA, specification);	
			}
			break;
		case "BBA":
			if(College.STUDENT==dept) {
				new StudentRecord(dept,Branch.Graduation.BBA, specification);
				}else {
					new TeacherRecord(dept,Branch.Graduation.BBA, specification);	
				}
				break;
		case "BCOM":
			if(College.STUDENT==dept) {
				new StudentRecord(dept,Branch.Graduation.BCOM, specification);
				}else {
					new TeacherRecord(dept,Branch.Graduation.BCOM, specification);	
				}
				break;
		case "BSC":
			if(College.STUDENT==dept) {
				new StudentRecord(dept,Branch.Graduation.BSC, specification);
				}else {
					new TeacherRecord(dept,Branch.Graduation.BSC, specification);	
				}
				break;
		case "BCS":
			if(College.STUDENT==dept) {
				new StudentRecord(dept,Branch.Graduation.BCS, specification);
				}else {
					new TeacherRecord(dept,Branch.Graduation.BCS, specification);	
				}
				break;
		case "ALL":
			if(College.STUDENT==dept) {
				new AllStudentRecord(dept,specification);
				}else {
					new AllTeacherRecord(dept, specification);	
				}
				break;
		default:
			System.out.println("Invalid Key Input");
		}
	}
}
}
