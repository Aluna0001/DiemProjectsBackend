package org.exam.diemprojectsbackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.exam.diemprojectsbackend.model.Task;
import org.exam.diemprojectsbackend.service.TaskService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createTask_shouldReturnCreatedTask() throws Exception {
        Task task = new Task("Title", "Desc", 1, 0, 100, 0, "NEW");
        Mockito.when(taskService.createTask(any(Task.class))).thenReturn(task);

        mockMvc.perform(post("/tasks/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(task)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Title"));
    }

    @Test
    void getAllTasks_shouldReturnListOfTasks() throws Exception {
        Task task = new Task("Title", "Desc", 1, 0, 100, 0, "NEW");
        Mockito.when(taskService.getAllTasks()).thenReturn(Collections.singletonList(task));

        mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Title"));
    }

    @Test
    void getTaskById_shouldReturnTask() throws Exception {
        Task task = new Task("Title", "Desc", 1, 0, 100, 0, "NEW");
        Mockito.when(taskService.getTaskById(1L)).thenReturn(task);

        mockMvc.perform(get("/tasks/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Title"));
    }

    @Test
    void updateTask_shouldReturnUpdatedTask() throws Exception {
        Task updatedTask = new Task("Updated", "Desc", 2, 1, 200, 50, "DONE");
        Mockito.when(taskService.updateTask(eq(1L), any(Task.class))).thenReturn(updatedTask);

        mockMvc.perform(put("/tasks/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedTask)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated"));
    }

    @Test
    void deleteTask_shouldReturnNoContent() throws Exception {
        Mockito.doNothing().when(taskService).deleteTask(1L);

        mockMvc.perform(delete("/tasks/1"))
                .andExpect(status().isNoContent());
    }
}
