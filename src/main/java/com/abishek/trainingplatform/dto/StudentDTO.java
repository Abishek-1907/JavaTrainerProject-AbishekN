package com.abishek.trainingplatform.dto;

import java.time.LocalDate;
import java.util.List;

public class StudentDTO {
    private String name;
    private String email;
    private String phone;
    private LocalDate dateOfBirth;
    private List<String> previousCourses;
    private String appliedSubject;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public List<String> getPreviousCourses() {
		return previousCourses;
	}
	public void setPreviousCourses(List<String> previousCourses) {
		this.previousCourses = previousCourses;
	}
	public String getAppliedSubject() {
		return appliedSubject;
	}
	public void setAppliedSubject(String appliedSubject) {
		this.appliedSubject = appliedSubject;
	}
}