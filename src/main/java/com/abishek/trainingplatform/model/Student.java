package com.abishek.trainingplatform.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

@Entity
public class Student {
    @Id @GeneratedValue
    private Long id;

    @NotBlank private String name;
    @Email @NotBlank private String email;
    @NotBlank private String phone;
    @Past private LocalDate dateOfBirth;
    @ElementCollection private List<String> previousCourses;
    @NotBlank private String appliedSubject;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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

