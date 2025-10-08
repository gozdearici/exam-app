package com.example.demo.service;

import com.example.demo.model.Exam;
import com.example.demo.repository.ExamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {
    private final ExamRepository examRepository;

    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public List<Exam> findAll() {
        return examRepository.findAll();
    }
    
    public Exam getExamById(Long id) {
        return examRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exam not found with id " + id));
    }

    public Exam createExam(Exam exam) {
        validateExam(exam);
        return examRepository.save(exam);
    }

    public Exam updateExam(Long id, Exam updatedExam) {
        validateExam(updatedExam);
        Exam exam = getExamById(id);
        exam.setTitle(updatedExam.getTitle());
        exam.setDescription(updatedExam.getDescription());
        exam.setQuestions(updatedExam.getQuestions());
        return examRepository.save(exam);
    }

    public void deleteExam(Long id) {
        examRepository.deleteById(id);
    }

    // Validation method
    private void validateExam(Exam exam) {
        if (exam.getTitle() == null || exam.getTitle().isBlank()) {
            throw new RuntimeException("Exam title cannot be empty");
        }
        if (exam.getQuestions() == null || exam.getQuestions().isEmpty()) {
            throw new RuntimeException("Exam must have at least one question");
        }
    }
}
