package com.abishek.trainingplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abishek.trainingplatform.model.Trainer;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {}
