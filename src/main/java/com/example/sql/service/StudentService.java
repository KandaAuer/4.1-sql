package com.example.sql.service;

import com.example.sql.model.Student;
import com.example.sql.repository.StudentRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public int getStudentCount() {
        return studentRepository.getStudentCount();
    }

    public double getAverageStudentAge() {
        return studentRepository.getAverageStudentAge();
    }

    public List<Student> getLastFiveStudents() {
        return studentRepository.findLastFiveStudents(PageRequest.of(0, 5));
    }
}
