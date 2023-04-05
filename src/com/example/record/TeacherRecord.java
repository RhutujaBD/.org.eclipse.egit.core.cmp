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

public class TeacherRecord {
	String branch;
	String dept;
	String specification;
	public TeacherRecord(College dept, Branch.Engineering branch, Specification specification) {
		this.dept = dept.name();
		this.branch = branch.name();
		this.specification = specification.name();
		Map<String,String> teacherDetailsMap=teacherRecordRead();
		fetchTeacherRecord(teacherDetailsMap);
}
	public TeacherRecord(College dept, Branch.Graduation branch, Specification specification) {
		this.dept = dept.name();
		this.branch = branch.name();
		this.specification = specification.name();
		Map<String,String> teacherDetailsMap=teacherRecordRead();
		fetchTeacherRecord(teacherDetailsMap);
	}
	public Map<String , String> teacherRecordRead() {
		String fileName = ".\\" + branch.toLowerCase() + "" + specification.toLowerCase() + "" + dept.toLowerCase()
				+ ".csv";

		Map<String, String> teacherMap = new HashMap<>();

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
						
						teacherMap.put(values[0], line);
						
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} else {
			System.out.println("File not found ");
		}
return teacherMap;
	}
public void fetchTeacherRecord(Map<String,String>teacherDetailsMap) {
	int count = 0;
	for(Map.Entry<String,String> me:teacherDetailsMap.entrySet()){
		
		String str ="Emp No";
		if(me.getKey().contains(str)) {
		System.out.println(me.getValue());
		}
	}
	
	for(Map.Entry<String,String> me:teacherDetailsMap.entrySet()){
		String str ="Emp No";
		if(!me.getKey().contains(str)) {
			count++;
		System.out.println(me.getValue());
		}
		}
	System.out.println("\n Total "+dept + " of "+branch +": "+ count);
}
	
	
}

