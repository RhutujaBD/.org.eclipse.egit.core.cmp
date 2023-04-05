package com.example.record;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.colleagestaff.College;
import com.example.specification.Specification;

public class AllStudentRecord {
	String dept;
	String specification;
public AllStudentRecord(College dept,Specification specification) {
	
	this.dept = dept.name();
	this.specification = specification.name();
	List<String> studentDetailsList=allStudentDataBranch();
	fetchStudentRecord(studentDetailsList);
}

public List<String> allStudentDataBranch() {
	List<String> studentList = new ArrayList<>();
	if(!specification.equals("ENGINEERING")) {
		String[] fileName = {".\\" + "bca" + "" + specification.toLowerCase() + "" + dept.toLowerCase()
		+ ".csv",".\\" + "bba" + "" + specification.toLowerCase() + "" + dept.toLowerCase()
		+ ".csv",".\\" + "bcom" + "" + specification.toLowerCase() + "" + dept.toLowerCase()
		+ ".csv",".\\" + "bsc" + "" + specification.toLowerCase() + "" + dept.toLowerCase()
		+ ".csv",".\\" + "bcs" + "" + specification.toLowerCase() + "" + dept.toLowerCase()
		+ ".csv"};
		for(int i=0;i<fileName.length;i++) {
		String fileName1 = fileName[i];
		Path path = Paths.get(fileName1);
		if (Files.exists(path)) {
			if (Files.isDirectory(path)) {
				System.out.println("It is a directory");
			} else if (Files.isRegularFile(path)) {
				BufferedReader bufferedReader = null;
				try {
					bufferedReader = new BufferedReader(new FileReader(fileName1));
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						studentList.add(line);
						
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} 
	}
}else {
	String[] fileName = {".\\" + "civil" + "" + specification.toLowerCase() + "" + dept.toLowerCase()
	+ ".csv",".\\" + "mechanical" + "" + specification.toLowerCase() + "" + dept.toLowerCase()
	+ ".csv",".\\" + "it" + "" + specification.toLowerCase() + "" + dept.toLowerCase()
	+ ".csv",".\\" + "computer" + "" + specification.toLowerCase() + "" + dept.toLowerCase()
	+ ".csv",".\\" + "entc" + "" + specification.toLowerCase() + "" + dept.toLowerCase()
	+ ".csv"};
	for(int i=0;i<fileName.length;i++) {
		String fileName1 = fileName[i];
		Path path = Paths.get(fileName1);
		if (Files.exists(path)) {
			if (Files.isDirectory(path)) {
				System.out.println("It is a directory");
			} else if (Files.isRegularFile(path)) {
				BufferedReader bufferedReader = null;
				try {
					bufferedReader = new BufferedReader(new FileReader(fileName1));
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						studentList.add(line);
						
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} 
	}
}
	return studentList;
}
public void fetchStudentRecord(List<String>studentDetailsList) {
	int count = 0;
	String filename = "All"+specification.toLowerCase() + "" + dept.toLowerCase()
	+ ".csv";
	File file = new File(filename);
	FileWriter fileWrite =null;
	Map<String,String> studentlistheader = new HashMap<>();
	try {
		file.createNewFile();
	try {
		fileWrite = new FileWriter(file);
	for(String studentList:studentDetailsList){
		
		String str ="Roll No";
		if(studentList.contains(str)) {
			studentlistheader.put(str, studentList);
		}
	}
	for(Map.Entry<String, String> me:studentlistheader.entrySet()) {
		System.out.println(me.getValue());
		fileWrite.write(me.getValue()+"\n");
	}
	for(String studentList:studentDetailsList){
		String str ="Roll No";
		if(!studentList.contains(str)) {
			count++;
		System.out.println(studentList);
		fileWrite.write(studentList+"\n");
		}
		}
	
	System.out.println("\n Total "+dept + " of "+specification +": "+ count);
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		if(fileWrite !=null) {
			try {
				fileWrite.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}catch(Exception e) {
	e.printStackTrace();
}
	}
}
