package com.example.sql.controller;

import com.example.sql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/print-parallel")
    public void printStudentsInParallel() {
        studentService.printStudentsInParallel();
    }

    @GetMapping("/print-synchronized")
    public void printStudentsInSynchronized() {
        studentService.printStudentsInSynchronized();
    }
}
