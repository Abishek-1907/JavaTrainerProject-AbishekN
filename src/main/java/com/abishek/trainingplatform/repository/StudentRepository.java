package com.abishek.trainingplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abishek.trainingplatform.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {}