package org.exam.diemprojectsbackend.service;


import org.exam.diemprojectsbackend.model.Task;
import org.exam.diemprojectsbackend.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    //create
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    //read
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    public Task getTaskById(long id) {
        //skal måske ændres
        return taskRepository.findById(id).orElse(null);
    }

    //update
    public Task updateTask(long id, Task updatedTask) {
        Task existingTask = getTaskById(id); // Hent eksisterende

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setEstimatedTime(updatedTask.getEstimatedTime());
        existingTask.setSpentTime(updatedTask.getSpentTime());
        existingTask.setEstimatedCost(updatedTask.getEstimatedCost());
        existingTask.setSpentCost(updatedTask.getSpentCost());
        existingTask.setStatus(updatedTask.getStatus());

        return taskRepository.save(existingTask); // Gem opdateret
    }

    public void deleteTask(long id) {
        taskRepository.deleteById(id);
    }
}
