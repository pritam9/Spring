package com.uncc.mhealth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uncc.mhealth.model.Student;
import com.uncc.mhealth.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/getStudent/{studentId}", method = RequestMethod.GET)
	public @ResponseBody Student getStudent(
			@PathVariable("studentId") int studentId) {
		System.out.println("rcvd studentId=" + studentId);

		return studentService.getStudent(studentId);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {
		return "index";
	}
}
