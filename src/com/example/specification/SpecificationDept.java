package com.example.specification;
import java.util.Scanner;

import com.example.branch.BranchSelect;
import com.example.colleagestaff.College;
import com.example.college.principle.StudentAndTeacherRecordThroughPrinciple;
public class SpecificationDept {
	Specification specification;
	College category;
	public SpecificationDept(College category){
		 this.category =category;
	}
public void specificationDetails(String spec) {
	
	switch(spec.toUpperCase()) {
	case "E" :
	
		callToBranch(Specification.ENGINEERING,category );
		
		break;
	case "G" :
	
		callToBranch(Specification.GRADUATION,category);
		
		break;
	
		default: 
			System.out.println("Invalid Key");
		
	}
	
	}

public void callToBranch(Specification str,College category) {
	BranchSelect branchSelect =new BranchSelect();
	StudentAndTeacherRecordThroughPrinciple studentAndTeacherRecordThroughPrinciple =new StudentAndTeacherRecordThroughPrinciple();
	if(Specification.ENGINEERING == str) {
	if(College.STUDENT == category || College.TEACHER==category) {
	System.out.println("Enter a Key For Engieeniring :\n CL:Civil\n MECH:Mechanical \n IT:It \n COMP: Computer \n E&T: ENTC \n ");
	
	try(Scanner sc = new Scanner(System.in)){
	String spec = sc.next();
	branchSelect.engineeringBranch(spec,category,str);
	}
	}else {
		System.out.println("Enter a Key For Engieeniring Record Details :\n S:STUDENT\n T:TEACHER \n ");
		try(Scanner sc = new Scanner(System.in)){
		String department = sc.next();
		studentAndTeacherRecordThroughPrinciple.StudentDetailsRecord(department,category,str);
		}
	}
	}
	else if(Specification.GRADUATION == str) {
		if(College.STUDENT == category || College.TEACHER==category) {
		System.out.println("Enter a Key For Graguation :\n BCA:BCA \n BBA:BBA \n BCOM:BCOM \n BSC:BSC \n BCS:BCS \n ");
		try(Scanner sc = new Scanner(System.in)){
		String spec = sc.next();
		branchSelect.graduationBranch(spec,category,str);
		}
		}else {
			System.out.println("Enter a Key For Graguation Record Details :\n S:STUDENT\n T:TEACHER \n ");
			try(Scanner sc = new Scanner(System.in)){
			String spec = sc.next();
			studentAndTeacherRecordThroughPrinciple.StudentDetailsRecord(spec,category,str);
			}
	}
}
}
}

