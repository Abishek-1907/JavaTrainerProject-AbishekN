package com.abishek.trainingplatform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abishek.trainingplatform.model.Batch;

public interface BatchRepository extends JpaRepository<Batch, Long> {
    List<Batch> findBySubject(String subject);
}
