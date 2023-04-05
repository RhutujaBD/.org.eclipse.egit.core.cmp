package com.example.college.management.teacher;
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

public class TeacherDetails {
	Teacher teacher;
	String branch;
	String dept;
	String specification;
	List<Teacher> teacherDetils;
	public TeacherDetails(Branch.Engineering branch, College dept, Specification specification) {
		this.branch = branch.name();
		this.dept = dept.name();
		this.specification = specification.name();
		List<Teacher> TeacherList = addTeacherDetails();
		writeTeacherDetailsFile(TeacherList);
	}

	public TeacherDetails(Branch.Graduation branch, College dept, Specification specification) {
		this.branch = branch.name();
		this.dept = dept.name();
		this.specification = specification.name();
		List<Teacher> teacherList = addTeacherDetails();
		writeTeacherDetailsFile(teacherList);
	}

	public List<Teacher> addTeacherDetails() {
		teacherDetils = new ArrayList<>();
		System.out.println("\nPlease Fill Teacher Details\n");
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter Your Emp ID : ");
			int rollNo = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter Your Name : ");
			String name = sc.nextLine();
			System.out.print("Enter Your Mobile No : ");
			Long mobileNo = sc.nextLong();
			sc.nextLine();
			System.out.print("Enter Your Email Id : ");
			String emailId = sc.nextLine();
			System.out.print("Enter Your Subject : ");
			String subSpecific = sc.nextLine();
			System.out.print("Enter Your Current Address : ");
			String cAddress = sc.nextLine();
			System.out.print("Enter Your Permanent Address : ");
			String pAddress = sc.nextLine();
			
			Address address = new Address(cAddress,pAddress);

			teacherDetils.add(new Teacher(rollNo, name, mobileNo, emailId, subSpecific, address, specification, branch));
		}
		return teacherDetils;
	}

	public void writeTeacherDetailsFile(List<Teacher> teacherList) {
		int empNoList=0;
		List<String> empNo = new ArrayList<String>();
		String[] values=null;
		String fileName = ".\\" + branch.toLowerCase() + "" + specification.toLowerCase() + "" + dept.toLowerCase()
				+ ".csv";
		File file = new File(fileName);
		BufferedReader bufferedReader = null;
		FileWriter fileWrite;
		try {

			file.createNewFile();

			fileWrite = new FileWriter(file, true);
			if (file.length() == 0) {
				fileWrite.write("Emp No ," + "Teacher Name ," + "Teacher Mobile No," + "Teacher Email ,"
						+ "Teacher Subject ," + "Teacher Current Address ," + "Teacher Permanent Address ," + "Teacher Branch," + "Teacher Specification\n");
			}
			bufferedReader = new BufferedReader(new FileReader(file));
			BufferedWriter bufferedWriter = new BufferedWriter(fileWrite);
			try {
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					values = line.split(",");
					empNo.add(values[0]);
				}
				for(Teacher t:teacherList) {
				for(String emp:empNo) {
					if(emp.contains(Integer.toString(t.getTeacherID()))) {
						empNoList = Integer.parseInt(emp);
					}
				}
				}
				for (Teacher teacher : teacherList) {
					if(file.length() == 0){
						bufferedWriter.append(teacher.getTeacherID() + "," + teacher.getTeacherName() + ","
								+ teacher.getTeacherMobileNo() + "," + teacher.getTeacherEmail() + ","
								+ teacher.getTeacherTeachSubject() + "," + teacher.teacherAddress+ ","
								+ teacher.getBranch() + ", " + teacher.getSpecification() + "\n");
						System.out.println("Record Created Succesfully1");
						System.out.println("Please Check Record in File : "+fileName);
					}else if (empNoList!=teacher.getTeacherID()) {
						bufferedWriter.append(teacher.getTeacherID() + "," + teacher.getTeacherName() + ","
								+ teacher.getTeacherMobileNo() + "," + teacher.getTeacherEmail() + ","
								+ teacher.getTeacherTeachSubject() + "," + teacher.teacherAddress+ ","
								+ teacher.getBranch() + ", " + teacher.getSpecification() + "\n");
						System.out.println("Record Created Succesfully");
						System.out.println("Please Check Record in File : "+fileName);
					} else {
						System.err.println("Roll Numberd Already Exists");
						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (bufferedWriter != null) {
						bufferedWriter.close();
						fileWrite.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}