package com.abishek.trainingplatform.dto;

import java.util.List;

public class TrainerDTO {
    private String name;
    private List<String> subjectExpertise;
    private double rating;
    private int yearsOfExperience;
    private List<String> availabilityPeriods;
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