package com.uncc.mhealth.service;

import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import com.uncc.mhealth.model.Student;

@Service
public class StudentService {

	// @Autowired
	private DataSource dataSource;

	public Student getStudent(int studentId) {
		Student s = new Student();
		s.setName("Kapil");
		s.setAge(26);
		return s;
	}

}
