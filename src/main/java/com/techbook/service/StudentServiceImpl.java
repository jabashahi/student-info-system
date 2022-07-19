package com.techbook.service;

import com.techbook.dao.StudentDao;
import com.techbook.dao.StudentDaoImpl;
import com.techbook.domain.Student;

public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;

	public StudentServiceImpl() {
		studentDao = new StudentDaoImpl();
	}

	@Override
	public int saveStudentInfo(Student student) {
		return studentDao.saveStudentInfo(student);

	}

}
