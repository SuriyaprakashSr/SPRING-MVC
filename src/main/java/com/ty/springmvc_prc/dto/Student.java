package com.ty.springmvc_prc.dto;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	private String name;
	private String school;
	private String  email;
	private String password;
	private long phone;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSchool() {
		return school;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public long getPhone() {
		return phone;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", school=" + school + ", email=" + email + ", password="
				+ password + ", phone=" + phone + "]";
	}
	
	
	
	
	
	
	



}