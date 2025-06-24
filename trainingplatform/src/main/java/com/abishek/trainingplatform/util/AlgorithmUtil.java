package com.abishek.trainingplatform.util;

import com.abishek.trainingplatform.model.Batch;
import com.abishek.trainingplatform.model.Student;
import com.abishek.trainingplatform.model.Trainer;

import java.util.Comparator;
import java.util.List;

public class AlgorithmUtil {

    public static Trainer findBestTrainer(Batch batch, List<Trainer> trainers, List<Batch> allBatches) {
        return trainers.stream()
//        		Only consider trainers who are experts in the subject of the batch.
            .filter(trainer -> trainer.getSubjectExpertise().contains(batch.getSubject()))
//            Exclude trainers who already have a batch that overlaps with the current batch's dates.
            .filter(trainer -> allBatches.stream().noneMatch(
                b -> b.getAssignedTrainer() != null
                    && b.getAssignedTrainer().getId().equals(trainer.getId())
                    && !(b.getEndDate().isBefore(batch.getStartDate()) || b.getStartDate().isAfter(batch.getEndDate()))
            ))
//            Prioritize:Higher rating (descending order) && Then, fewer assigned batches (less workload)
            .sorted(Comparator
                .comparingDouble(Trainer::getRating).reversed()
                .thenComparing(t -> (int) allBatches.stream()
                    .filter(b -> b.getAssignedTrainer() != null && b.getAssignedTrainer().getId().equals(t.getId()))
                    .count()))
//             Return the top-ranked trainer, or null if none is eligible.
            .findFirst()
            .orElse(null);	
    }

    public static Batch recommendBestBatch(Student student, List<Batch> batches) {
        return batches.stream()
//        		If the batch subject matches the student's applied subject, give 2 points.
            .sorted(Comparator
                .comparingInt((Batch b) -> {
                    int score = 0;
                    if (b.getSubject().equalsIgnoreCase(student.getAppliedSubject())) score += 2;
//                    If the batch subject matches any previous courses, add +1 point per match.
                    long matches = student.getPreviousCourses().stream()
                        .filter(p -> p.equalsIgnoreCase(b.getSubject()))
                        .count();
                    score += matches;
//                    We sort by highest total score — more relevance = better recommendation.
                    return -score;
                })
//                If multiple batches have the same score, prefer the one starting sooner.
                .thenComparing(Batch::getStartDate))
//            Return the top recommended batch, or null if none match.
            .findFirst()
            .orElse(null);
    }
}
