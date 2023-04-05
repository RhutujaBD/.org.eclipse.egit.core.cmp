package com.example.college.management.student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.address.Address;
import com.example.branch.Branch;
import com.example.colleagestaff.College;
import com.example.specification.Specification;

public class StudentDetails {
	Student student;
	String branch;
	String dept;
	String specification;
	List<Student> studentDetils;
	public StudentDetails(Branch.Engineering branch, College dept, Specification specification){
		this.branch = branch.name();
		this.dept = dept.name();
		this.specification=specification.name();
		List<Student> studentList = addStudentDetails();
		writeStudentDetailsFile(studentList);
	}
	public StudentDetails(Branch.Graduation branch, College dept, Specification specification){
		this.branch = branch.name();
		this.dept = dept.name();
		this.specification=specification.name();
		List<Student> studentList = addStudentDetails();
		writeStudentDetailsFile(studentList);
	}
	public List<Student> addStudentDetails(){
		studentDetils=new ArrayList<>();
		System.out.println("\nPlease Fill Student Details\n");
		try(Scanner sc = new Scanner(System.in)){
		System.out.print("Enter Your RollNo : ");
		int rollNo = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Your Name : ");
		String name = sc.nextLine();
		System.out.print("Enter Your Mobile No : ");
		Long mobileNo = sc.nextLong();
		sc.nextLine();
		System.out.print("Enter Your Email Id : ");
		String emailId = sc.nextLine();
		System.out.print("Enter Your Current Address : ");
		String cAddress = sc.nextLine();
		System.out.print("Enter Your Permanent Address : ");
		String pAddress = sc.nextLine();
		
		Address address = new Address(cAddress,pAddress);
		studentDetils.add(new Student(rollNo,name,mobileNo,emailId,address,specification,branch));
		}
		return studentDetils;
	}
	public void writeStudentDetailsFile(List<Student> studentList) {
		int rollNoList=0;
		List<String> rollNo = new ArrayList<String>();
		String[] values=null;
		String fileName = ".\\"+branch.toLowerCase()+""+specification.toLowerCase()+""+dept.toLowerCase()+".csv";
		File file = new File(fileName);
		BufferedReader bufferedReader = null;
		FileWriter fileWrite;
		try {
			file.createNewFile();
			fileWrite = new FileWriter(file,true);
			if(file.length()==0) {
				fileWrite.write("Roll No,"+"Student Name,"+"Student Mobile No,"+"Student Email,"+"Student Current Address,"+"Student Permanent Address,"+"Student Branch,"+"Student Specification\n");
			}
			bufferedReader = new BufferedReader(new FileReader(file));
			BufferedWriter bufferedWriter = new BufferedWriter(fileWrite);
			try {
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					values = line.split(",");
					rollNo.add(values[0]);
				}
				for(Student s:studentList) {
				for(String roll:rollNo) {
					if(roll.contains(Integer.toString(s.getStudentRollNo()))) {
						rollNoList = Integer.parseInt(roll);
					}
				}
				}
				for(Student student:studentList) {
					if(file.length() == 0){
					bufferedWriter.append(student.getStudentRollNo()+","+student.getStudentName() +","+student.getStudentMobileNo()+","+student.getStudentEmail()+","+student.address+","+student.getBranch()+", "+student.getSpecification()+"\n");
					System.out.println("Record Created Succesfully");
					System.out.println("Please Check Record in File : "+fileName);
				}else if (rollNoList!=student.getStudentRollNo()) {
					bufferedWriter.append(student.getStudentRollNo()+","+student.getStudentName() +","+student.getStudentMobileNo()+","+student.getStudentEmail()+","+student.address+","+student.getBranch()+", "+student.getSpecification()+"\n");
					System.out.println("Record Created Succesfully");
					System.out.println("Please Check Record in File : "+fileName);
				}else {
					System.err.println("Roll Numberd Already Exists");
					break;
				}
			}
			}catch(IOException e) {
				e.printStackTrace();
			}finally {
				try {
					if(bufferedWriter!=null) {
						bufferedWriter.close();
						fileWrite.close();					}
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
