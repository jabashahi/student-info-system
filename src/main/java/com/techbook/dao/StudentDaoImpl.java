package com.techbook.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.techbook.domain.Student;
import com.techbook.util.DbConnectionUtil;

public class StudentDaoImpl implements StudentDao {

	public static final String INSERT_SQL = "insert into student_tbl(student_name, roll, address, email, mobile_no, dob)values(?,?,?,?,?,?)";

	@Override
	public int saveStudentInfo(Student student) {
		int saved = 0;

		try (PreparedStatement ps = DbConnectionUtil.getConnection().prepareStatement(INSERT_SQL);) {

			ps.setString(1, student.getStudentName());
			ps.setString(2, student.getRoll());
			ps.setString(3, student.getAddress());
			ps.setString(4, student.getEmail());
			ps.setLong(5, student.getMobileNo());
			ps.setDate(6, new Date(student.getDob().getTime()));
			saved = ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return saved;
	}

}
