package com.example.sql.service;

import com.example.sql.model.Student;
import com.example.sql.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        logger.info("Was invoked method for create student: {}", student);
        if (student == null) {
            logger.error("Attempted to create a null student");
            throw new IllegalArgumentException("Student cannot be null");
        }
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        logger.debug("Fetching student with id = {}", id);
        if (id == null) {
            logger.error("Invalid student id provided");
            throw new IllegalArgumentException("Student id cannot be null");
        }
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            logger.error("There is no student with id = {}", id);
            throw new IllegalArgumentException("Student not found");
        }
        return student.get();
    }

    public void deleteStudent(Long id) {
        logger.info("Was invoked method for delete student with id = {}", id);
        if (id == null) {
            logger.warn("Attempted to delete a student with null id");
            throw new IllegalArgumentException("Student id cannot be null");
        }
        if (!studentRepository.existsById(id)) {
            logger.warn("Student with id = {} does not exist", id);
            throw new IllegalArgumentException("Student not found");
        }
        studentRepository.deleteById(id);
        logger.info("Successfully deleted student with id = {}", id);
    }

    public List<Student> getAllStudents() {
        logger.info("Was invoked method to get all students");
        List<Student> students = studentRepository.findAll();
        logger.debug("Found {} students", students.size());
        return students;
    }

    public Student updateStudent(Long id, Student student) {
        logger.info("Was invoked method to update student with id = {}", id);
        if (id == null || student == null) {
            logger.error("Invalid input: id or student is null");
            throw new IllegalArgumentException("Id and student cannot be null");
        }
        if (!studentRepository.existsById(id)) {
            logger.error("Cannot update student: student with id = {} does not exist", id);
            throw new IllegalArgumentException("Student not found");
        }
        student.setId(id);
        Student updatedStudent = studentRepository.save(student);
        logger.info("Successfully updated student with id = {}", id);
        return updatedStudent;
    }
}
