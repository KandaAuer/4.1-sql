package com.example.sql.service;

import com.example.sql.model.Faculty;
import com.example.sql.repository.FacultyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {

    private static final Logger logger = LoggerFactory.getLogger(FacultyService.class);

    @Autowired
    private FacultyRepository facultyRepository;

    public Faculty createFaculty(Faculty faculty) {
        logger.info("Был вызван метод createFaculty");
        return facultyRepository.save(faculty);
    }

    public List<Faculty> getAllFaculties() {
        logger.info("Был вызван метод getAllFaculties");
        return facultyRepository.findAll();
    }

    public Optional<Faculty> getFacultyById(Long id) {
        logger.info("Был вызван метод getFacultyById с id = {}", id);
        return facultyRepository.findById(id);
    }

    public Faculty updateFaculty(Long id, Faculty faculty) {
        logger.info("Был вызван метод updateFaculty с id = {}", id);
        if (!facultyRepository.existsById(id)) {
            logger.warn("Faculty with id = {} not found", id);
            return null;
        }
        faculty.setId(id);
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long id) {
        logger.info("Был вызван метод deleteFaculty с id = {}", id);
        if (!facultyRepository.existsById(id)) {
            logger.warn("Факультет с id = {} не найден для удаления", id);
            return;
        }
        facultyRepository.deleteById(id);
    }

    public String getLongestFacultyName() {
        logger.info("Был вызван метод getLongestFacultyName");
        return facultyRepository.findAll().stream()
                .map(Faculty::getName)
                .max((name1, name2) -> Integer.compare(name1.length(), name2.length()))
                .orElse("Факультетов нет");
    }
}
