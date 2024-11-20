package com.example.sql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetStudentNamesStartingWithA() throws Exception {
        mockMvc.perform(get("/students/names/starts-with-a"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0]").value("АЛЕКСАНДР"));
    }

    @Test
    void testGetAverageAge() throws Exception {
        mockMvc.perform(get("/students/average-age"))
                .andExpect(status().isOk())
                .andExpect(content().string("20.0"));
    }

    @Test
    void testGetLongestFacultyName() throws Exception {
        mockMvc.perform(get("/faculties/longest-name"))
                .andExpect(status().isOk())
                .andExpect(content().string("Факультет информационных технологий"));
    }

    @Test
    void testCalculateSum() throws Exception {
        mockMvc.perform(get("/students/calculate-sum"))
                .andExpect(status().isOk())
                .andExpect(content().string("200000200000"));
    }
}
