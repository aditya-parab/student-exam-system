package com.neebal.springexamSystem.controllers;


import com.neebal.springexamSystem.entities.Exam;
import com.neebal.springexamSystem.repository.ExamRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
public class ExamApiController {
    @Autowired
    private ExamRepository examRepository;

    //get all exams
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }
}
