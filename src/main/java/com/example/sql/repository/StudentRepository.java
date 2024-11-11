package com.example.sql.repository;

import com.example.sql.model.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT COUNT(s) FROM Student s")
    int getStudentCount();

    @Query("SELECT AVG(s.age) FROM Student s")
    double getAverageStudentAge();

    @Query("SELECT s FROM Student s ORDER BY s.id DESC")
    List<Student> findLastFiveStudents(Pageable pageable);
}
