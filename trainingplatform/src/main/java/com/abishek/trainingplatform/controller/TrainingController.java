package com.abishek.trainingplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abishek.trainingplatform.model.Batch;
import com.abishek.trainingplatform.model.Student;
import com.abishek.trainingplatform.model.Trainer;
import com.abishek.trainingplatform.service.BatchService;
import com.abishek.trainingplatform.service.StudentService;
import com.abishek.trainingplatform.service.TrainerService;
import com.abishek.trainingplatform.util.AlgorithmUtil;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class TrainingController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	TrainerService trainerService;
	
	@Autowired
	BatchService batchService;
	
    @PostMapping("/students")
    public Student createStudent(@Valid @RequestBody Student s) { return studentService.add(s); }

    @PostMapping("/trainers")
    public Trainer createTrainer(@Valid @RequestBody Trainer t) { return trainerService.add(t); }

    @PostMapping("/batches")
    public Batch createBatch(@Valid @RequestBody Batch b) { return batchService.add(b); }

    @GetMapping("/batches/subject/{sub}")
    public List<Batch> listBatches(@PathVariable String sub) { return batchService.getBySubject(sub); }

    @PostMapping("/assign-trainer/{batchId}")
    public ResponseEntity<Batch> assignTrainer(@PathVariable Long batchId) {
        Batch batch = batchService.get(batchId);
        List<Trainer> allTrainers = trainerService.getAll();
        List<Batch> allBatches = batchService.getAll();

        Trainer best = AlgorithmUtil.findBestTrainer(batch, allTrainers, allBatches);
        if (best == null) {
            throw new RuntimeException("No suitable trainer found");
        }

        batch.setAssignedTrainer(best);
        return ResponseEntity.ok(batchService.add(batch));
    }

    @GetMapping("/recommend-batch/{studentId}")
    public ResponseEntity<Batch> recommendBatch(@PathVariable Long studentId) {
        Student student = studentService.get(studentId);
        List<Batch> allBatches = batchService.getAll();

        Batch recommended = AlgorithmUtil.recommendBestBatch(student, allBatches);
        if (recommended == null) {
            throw new RuntimeException("No suitable batch found");
        }

        return ResponseEntity.ok(recommended);
    }
}
