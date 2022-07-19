package com.techbook.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.techbook.domain.Student;
import com.techbook.service.StudentService;
import com.techbook.service.StudentServiceImpl;

public class StudentController {

	private StudentService studentService;

	public StudentController() {
		studentService = new StudentServiceImpl();
	}

	public int saveStudentInfo(Scanner input) {

		System.out.println("Enter studentname: ");
		String studentname = input.next();
		System.out.println("Enter roll: ");
		String roll = input.next();
		System.out.println("Enter address: ");
		String address = input.next();
		System.out.println("Enter email: ");
		String email = input.next();
		System.out.println("Enter mobile no: ");
		long mobileNo = input.nextLong();
		System.out.println("Enter dob: ");
		String dob = input.next();
		Date dateOfBirth = parseDate(dob);

		Student student = new Student();
		student.setStudentName(studentname);
		student.setRoll(roll);
		student.setAddress(address);
		student.setEmail(email);
		student.setMobileNo(mobileNo);
		student.setDob(dateOfBirth);

		return studentService.saveStudentInfo(student);

	}

	public Date parseDate(String dob) {
		Date dateOfBirth = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			dateOfBirth = sdf.parse(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateOfBirth;
	}

}
