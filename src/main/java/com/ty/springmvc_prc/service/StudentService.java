package com.ty.springmvc_prc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ty.springmvc_prc.dao.StudentDao;
import com.ty.springmvc_prc.dto.Student;

@Service
public class StudentService {
	@Autowired
	StudentDao dao;

	public Student saveStudent(Student student) {
		dao.savestudent(student);

		return student;
	}

	public Student LoginStudent(Student student) {
		Student receivedstudent = dao.getStudentByEmail(student.getEmail());

		if (student.getPassword().equals(receivedstudent.getPassword())) {
			return receivedstudent;
		} else {
			return null;
		}

	}

	public List<Student> getallStudent() {
		return dao.getAllStudent();
	}

	public void deleteStudent(int id) {
		dao.deleteStudent(id);
	}
	
	public  Student getstudent(int id) {
		return dao.getStudentById(id);
	}
	public  void updateStudent(Student student) {
		dao.UpdateStudent(student);
	}

}
