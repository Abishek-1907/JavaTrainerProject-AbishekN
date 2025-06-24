package com.abishek.trainingplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abishek.trainingplatform.model.Batch;
import com.abishek.trainingplatform.model.Trainer;
import com.abishek.trainingplatform.repository.BatchRepository;
import com.abishek.trainingplatform.repository.TrainerRepository;

@Service
public class TrainerService {
	
	@Autowired
	TrainerRepository trainerRepo;
	
	@Autowired
	BatchRepository batchRepo;
	
    public Trainer add(Trainer t) { return trainerRepo.save(t); }
    public List<Trainer> getAll() { return trainerRepo.findAll(); }
    public List<Batch> getBatches(Long id) {
        return batchRepo.findAll().stream().filter(b -> b.getAssignedTrainer().getId().equals(id)).toList();
    }
}
