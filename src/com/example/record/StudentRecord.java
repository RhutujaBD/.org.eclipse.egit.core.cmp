package com.example.record;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.example.branch.Branch;
import com.example.colleagestaff.College;
import com.example.specification.Specification;

public class StudentRecord {
	String branch;
	String dept;
	String specification;

	public StudentRecord(College dept, Branch.Engineering branch, Specification specification) {
		this.dept = dept.name();
		this.branch = branch.name();
		this.specification = specification.name();
		Map<String,String> studentDetailsMap=studentRecordRead();
		fetchStudentRecord(studentDetailsMap);
	}

	public StudentRecord(College dept, Branch.Graduation branch, Specification specification) {
		this.dept = dept.name();
		this.branch = branch.name();
		this.specification = specification.name();
		Map<String,String> studentDetailsMap=studentRecordRead();
		fetchStudentRecord(studentDetailsMap);
	}

	public Map<String , String> studentRecordRead() {
		String fileName = ".\\" + branch.toLowerCase() + "" + specification.toLowerCase() + "" + dept.toLowerCase()
				+ ".csv";

		Map<String, String> studentMap = new HashMap<>();

		Path path = Paths.get(fileName);
		if (Files.exists(path)) {
			if (Files.isDirectory(path)) {
				System.out.println("It is a directory");
			} else if (Files.isRegularFile(path)) {
				BufferedReader bufferedReader = null;
				try {
					bufferedReader = new BufferedReader(new FileReader(fileName));
					String[] values;
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						values = line.split(",");
						
						studentMap.put(values[0], line);
						
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} else {
			System.out.println("File not found ");
		}
return studentMap;
	}
public void fetchStudentRecord(Map<String,String>studentDetailsMap) {
	int count = 0;
	for(Map.Entry<String,String> me:studentDetailsMap.entrySet()){
		
		String str ="Roll No";
		if(me.getKey().contains(str)) {
		System.out.println(me.getValue());
		}
	}
	
	for(Map.Entry<String,String> me:studentDetailsMap.entrySet()){
		String str ="Roll No";
		if(!me.getKey().contains(str)) {
			count++;
		System.out.println(me.getValue());
		}
		}
	System.out.println("\n Total "+dept + " of "+branch +": "+ count);
}
	
	
}
