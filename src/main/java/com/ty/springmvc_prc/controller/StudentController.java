package com.ty.springmvc_prc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

import com.ty.springmvc_prc.dto.Student;
import com.ty.springmvc_prc.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService service;


	@RequestMapping("login")
	public ModelAndView getView() {
		ModelAndView modelandView = new ModelAndView();
		modelandView.setViewName("login.jsp");
		modelandView.addObject("student",new Student());
		return modelandView;
	}


	@RequestMapping("signup")
	public ModelAndView signup() {
		ModelAndView modelandView = new ModelAndView();
		modelandView.setViewName("signup.jsp");
		modelandView.addObject("student",new Student());		
		return modelandView;
	}


	@RequestMapping("saveStudent")
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		service.saveStudent(student);
		ModelAndView andView = new ModelAndView();
		andView.setViewName("login.jsp");

		return andView;
	}

	@RequestMapping("loginstudent")
	public ModelAndView loginStudent(@ModelAttribute Student student) {

		ModelAndView andView = new ModelAndView();
		Student student2= service.LoginStudent(student);

		if(student2!=null) {
			andView.setViewName("view.jsp");
			andView.addObject("name",student2.getName());
			andView.addObject("slist",service.getallStudent());
		}
		else {
			andView.setViewName("login.jsp");
		}


		return andView;
	}
	@RequestMapping("view")
	public ModelAndView view() {
		ModelAndView modelandView = new ModelAndView();
		modelandView.addObject("slist",service.getallStudent());
		modelandView.setViewName("view.jsp");

		return modelandView;
	}


	@RequestMapping("delete")
	public void deleteStudent(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{

		service.deleteStudent(Integer.parseInt(req.getParameter("id")));
		RequestDispatcher dispatcher=req.getRequestDispatcher("view");
		dispatcher.forward(req, res);
	}
	@RequestMapping("edit")
	public ModelAndView editStudent(@RequestParam int id) {
		Student student = service.getstudent(id);
		ModelAndView modelandView = new ModelAndView();
		modelandView.addObject("student", student);
		modelandView.setViewName("edit.jsp");
    
		return modelandView;
	}
	@RequestMapping("updateStudent")
	public void updateStudent(@ModelAttribute Student student,HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		service.updateStudent(student);
		RequestDispatcher dispatcher=req.getRequestDispatcher("view");
		dispatcher.forward(req, res);
		
		
	}
}
