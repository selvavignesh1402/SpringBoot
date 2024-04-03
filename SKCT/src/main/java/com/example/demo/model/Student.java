package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue
	
	private long id;
	private String regno;
	private String name;
	private String dept;
	private double cgpa;
	
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	
	public void setRegno(String regno) {
		this.regno = regno;
	}
	
	public String getRegno() {
		return regno;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public String getDept() {
		return dept;
	}
	
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	
	public double getCgpa() {
		return cgpa;
	}
	
}
