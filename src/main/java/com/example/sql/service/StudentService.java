package com.example.sql.service;

import com.example.sql.model.Student;
import com.example.sql.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void printStudentsInParallel() {
        logger.info("Был вызван метод printStudentsInParallel");

        List<Student> students = studentRepository.findAll();

        System.out.println("Основной поток: " + Thread.currentThread().getName());
        if (students.size() < 6) {
            System.out.println("Недостаточно студентов в базе данных.");
            return;
        }

        // Первые два имени в основном потоке
        System.out.println(students.get(0).getName());
        System.out.println(students.get(1).getName());

        // Имена 3 и 4 студента в параллельном потоке
        new Thread(() -> {
            System.out.println("Поток 1: " + Thread.currentThread().getName());
            System.out.println(students.get(2).getName());
            System.out.println(students.get(3).getName());
        }).start();

        // Имена 5 и 6 студента в другом параллельном потоке
        new Thread(() -> {
            System.out.println("Thread 2: " + Thread.currentThread().getName());
            System.out.println(students.get(4).getName());
            System.out.println(students.get(5).getName());
        }).start();
    }

    public void printStudentsInSynchronized() {
        logger.info("Был вызван метод printStudentsInSynchronized");

        List<Student> students = studentRepository.findAll();

        System.out.println("Основной поток: " + Thread.currentThread().getName());
        if (students.size() < 6) {
            System.out.println("Недостаточно студентов в базе данных.");
            return;
        }

        // Первые два имени в основном потоке
        printSynchronized(students.get(0).getName());
        printSynchronized(students.get(1).getName());

        // Имена 3 и 4 студента в параллельном потоке
        new Thread(() -> {
            System.out.println("Поток 1: " + Thread.currentThread().getName());
            printSynchronized(students.get(2).getName());
            printSynchronized(students.get(3).getName());
        }).start();

        // Имена 5 и 6 студента в другом параллельном потоке
        new Thread(() -> {
            System.out.println("Поток 2: " + Thread.currentThread().getName());
            printSynchronized(students.get(4).getName());
            printSynchronized(students.get(5).getName());
        }).start();
    }

    private synchronized void printSynchronized(String name) {
        System.out.println(name);
    }
}
