package com.abishek.trainingplatform.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Trainer {
    @Id @GeneratedValue
    private Long id;

    @NotBlank private String name;
    @ElementCollection private List<String> subjectExpertise;
    private double rating;
    private int yearsOfExperience;
    @ElementCollection private List<String> availabilityPeriods;
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
	public List<String> getSubjectExpertise() {
		return subjectExpertise;
	}
	public void setSubjectExpertise(List<String> subjectExpertise) {
		this.subjectExpertise = subjectExpertise;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	public List<String> getAvailabilityPeriods() {
		return availabilityPeriods;
	}
	public void setAvailabilityPeriods(List<String> availabilityPeriods) {
		this.availabilityPeriods = availabilityPeriods;
	}
    
    
}