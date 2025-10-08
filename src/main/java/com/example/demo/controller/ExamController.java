package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Exam;
import com.example.demo.service.ExamService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
public class ExamController {
    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping("/test")
    public String test() {
        return "Hello World";
    }

    @GetMapping
    public List<Exam> getAllExams() {
        return examService.findAll();
    }

    @GetMapping("/{id}")
    public Exam getExamById(@PathVariable Long id) {
        return examService.getExamById(id);
    }

    @PostMapping
    public Exam createExam(@Valid @RequestBody Exam exam) {
        return examService.createExam(exam);
    }

    @PutMapping("/{id}")
    public Exam updateExam(@PathVariable Long id, @Valid @RequestBody Exam updatedExam) {
        return examService.updateExam(id, updatedExam);
    }

    @DeleteMapping("/{id}")
    public void deleteExam(@PathVariable Long id) {
        examService.deleteExam(id);
    }
}
