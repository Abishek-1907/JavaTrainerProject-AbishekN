package com.abishek.trainingplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abishek.trainingplatform.model.Batch;
import com.abishek.trainingplatform.repository.BatchRepository;

@Service
public class BatchService {
	
	@Autowired
	BatchRepository batchRepo;
	
    public Batch add(Batch b) { return batchRepo.save(b); }
    public List<Batch> getBySubject(String s) { return batchRepo.findBySubject(s); }
    public Batch get(Long id) { return batchRepo.findById(id).orElseThrow(); }
    public List<Batch> getAll() { return batchRepo.findAll(); }
}
