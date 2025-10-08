package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "exams")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty(message = "Title cannot be empty")
    private String title;

    private String description;

    @ElementCollection
    @NotNull
    @NotEmpty(message = "Questions cannot be empty")
    private List<String> questions;

    public Exam() {}

    public Exam(String title, String description, List<String> questions) {
        this.title = title;
        this.description = description;
        this.questions = questions;
    }

    // Getters and Setters
    public Long getId() { 
        return id; 
    }
    public void setId(Long id) { 
        this.id = id; 
    }

    public String getTitle() { 
        return title; 
    }
    public void setTitle(String title) { 
        this.title = title; 
    }

    public String getDescription() { 
        return description; 
    }
    public void setDescription(String description) { 
        this.description = description; 
    }

    public List<String> getQuestions() { 
        return questions; 
    }
    public void setQuestions(List<String> questions) { 
        this.questions = questions; 
    }
}
