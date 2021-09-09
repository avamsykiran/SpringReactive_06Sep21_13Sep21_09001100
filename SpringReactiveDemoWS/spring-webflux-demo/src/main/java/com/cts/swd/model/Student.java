package com.cts.swd.model;

import java.time.LocalDate;

public class Student {

	private Long admNo;
	private String fullName;
	private String emailId;
	private LocalDate admDate;
	private Course course;
	
	public Student() {}

	public Student(Long admNo, String fullName, String emailId, LocalDate admDate, Course course) {
		super();
		this.admNo = admNo;
		this.fullName = fullName;
		this.emailId = emailId;
		this.admDate = admDate;
		this.course = course;
	}

	public Long getAdmNo() {
		return admNo;
	}

	public void setAdmNo(Long admNo) {
		this.admNo = admNo;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public LocalDate getAdmDate() {
		return admDate;
	}

	public void setAdmDate(LocalDate admDate) {
		this.admDate = admDate;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
