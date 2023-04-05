package com.example.record;

import com.example.branch.Branch;
import com.example.colleagestaff.College;
import com.example.specification.Specification;

public class CollegeRecord {
	
	public void CollegeRecordDetails(String str,Branch.Engineering branch, College dept, Specification specification){
	switch(str) {
	case "S":
		new StudentRecord(College.STUDENT,branch,specification);
		break;
	case "T":
		new TeacherRecord(College.TEACHER,branch,specification);
		break;
	default: 
		System.out.println("Invalid Key");
	}
		
		
	}
	public void CollegeRecordDetails(String str,Branch.Graduation branch, College dept, Specification specification){
		switch(str) {
		case "S":
			new StudentRecord(College.STUDENT,branch,specification);
			break;
		case "T":
			new TeacherRecord(College.TEACHER,branch,specification);
			break;
		default: 
			System.out.println("Invalid Key");
		}	
		
	}


}
