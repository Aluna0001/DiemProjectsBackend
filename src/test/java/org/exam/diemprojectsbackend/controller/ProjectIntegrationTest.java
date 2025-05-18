package org.exam.diemprojectsbackend.controller;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import org.exam.diemprojectsbackend.model.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
class ProjectIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createAndGetProjectIntegration() throws Exception {
        Project project = new Project();
        project.setProjectTitle("Integration Project");
        project.setProjectDescription("Integration Desc");
        project.setBudget(1000.0);
        project.setStartDate(LocalDate.of(2024, 1, 1));
        project.setEndDate(LocalDate.of(2024, 12, 31));

        // Create Project
        String response = mockMvc.perform(post("/projects")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(project)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.projectTitle").value("Integration Project"))
                .andReturn().getResponse().getContentAsString();

        Project created = objectMapper.readValue(response, Project.class);
        assertThat(created.getId()).isNotNull();

        // Get Project by ID
        mockMvc.perform(get("/projects/" + created.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.projectTitle").value("Integration Project"));
    }
}
