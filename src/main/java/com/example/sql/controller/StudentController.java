package com.example.sql.controller;

import com.example.sql.model.Student;
import com.example.sql.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        logger.info("POST /students - Creating student: {}", student);
        return studentService.createStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        logger.info("GET /students/{} - Fetching student", id);
        return studentService.getStudentById(id);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        logger.info("GET /students - Fetching all students");
        return studentService.getAllStudents();
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        logger.info("PUT /students/{} - Updating student: {}", id, student);
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long id) {
        logger.info("DELETE /students/{} - Deleting student", id);
        studentService.deleteStudent(id);
    }
}
