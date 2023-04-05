package com.example.colleagestaff;

import java.util.Scanner;
import com.example.specification.SpecificationDept;
public class ColleageAdmin {

	College college;
	static String collegeName;
	static String principleName;
	public void callToObject(String s) {
		if(s!=null && !s.isEmpty()) {
	switch(s.toUpperCase()) {
	case "S" :
		callToSpecification(College.STUDENT);
		break;
	case "T" :
		callToSpecification(College.TEACHER);
		break;
	case "P" :
		callToSpecification(College.PRINCIPLE);
		break;
		default: 
			System.out.println("Invalid Key");
	}
	}
	}
	public void callToSpecification(College str) {
		SpecificationDept specificationDept =new SpecificationDept(str);
		System.out.println("Enter a Key For Operation :\n E:Engineenring \n G:Graduation \n ");
		try (Scanner sc = new Scanner(System.in)) {
			String spec = sc.next();
			if(!spec.isEmpty() && spec!= null) {
			specificationDept.specificationDetails(spec);
			}else {
				System.out.println("Please insert key do not null pass");
			}
		}
	}
	
	public static void main(String[] args) {
		ColleageAdmin colleageAdmin =new ColleageAdmin();
		//System.out.println("Enter Your College Name");
		System.out.println("Enter a Key For Operation :\n S:Student \n T:Teacher \n P:Principle \n");
		try(Scanner sc = new Scanner(System.in)){
		//collegeName = sc.nextLine();
		//System.out.println("Enter Your Principle Name");
		//principleName = sc.nextLine();
		
		String s = sc.next();
		colleageAdmin.callToObject(s);
	}
	}

}
