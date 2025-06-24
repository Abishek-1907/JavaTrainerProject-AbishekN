package com.abishek.trainingplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abishek.trainingplatform.model.Student;
import com.abishek.trainingplatform.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepo;
    public Student add(Student s) { return studentRepo.save(s); }
    public Student get(Long id) { return studentRepo.findById(id).orElseThrow(); }
}

