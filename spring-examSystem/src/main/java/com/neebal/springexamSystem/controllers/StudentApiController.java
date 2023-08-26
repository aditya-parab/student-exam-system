package com.neebal.springexamSystem.controllers;

import com.neebal.springexamSystem.entities.Exam;
import com.neebal.springexamSystem.entities.StudentEntity;
import com.neebal.springexamSystem.entities.StudentExam;
import com.neebal.springexamSystem.repository.ExamRepository;
import com.neebal.springexamSystem.repository.StudentEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController

@RequestMapping("/api/students")
public class StudentApiController {

    @Autowired
    private StudentEntityRepository studentEntityRepository;


    @Autowired
    private ExamRepository examRepository;

    //get all students enrolled
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentEntity> getAllStudents() {
        return studentEntityRepository.findAll();
    }


    //get all students with high marks in an exam
    @GetMapping("/high-marks/{examTitle}")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentEntity> getStudentsWithHighMarks(@PathVariable String examTitle) {
        Exam exam = examRepository.findExamByTitle(examTitle);

        Set<StudentExam> studentExams = exam.getStudentsEnrolled();
        List<StudentEntity> studentsWithHighMarks = new ArrayList<>();

        for (StudentExam studentExam : studentExams) {
            if (studentExam.getMarksObtained() > 8) {
                studentsWithHighMarks.add(studentExam.getStudentEntity());
            }
        }

        return studentsWithHighMarks;
    }

    //get marks of a student in an exam
    @GetMapping("/{studentId}/total-marks/{examId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Integer> getStudentTotalMarks(
            @PathVariable Long studentId,
            @PathVariable Long examId) {

        Optional<StudentEntity> studentOptional = studentEntityRepository.findById(studentId);
        Optional<Exam> examOptional = examRepository.findById(examId);

        if (studentOptional.isEmpty() || examOptional.isEmpty()) {
            // Handle case when student or exam doesn't exist
            return ResponseEntity.notFound().build();
        }

        StudentEntity student = studentOptional.get();
        Exam exam = examOptional.get();

        int totalMarks = 0;
        for (StudentExam studentExam : student.getExamsEnrolled()) {
            if (studentExam.getExam().equals(exam)) {
                totalMarks = studentExam.getMarksObtained();
                break;
            }
        }

        return ResponseEntity.ok(totalMarks);
    }
}
