package org.exam.diemprojectsbackend.service;


import org.exam.diemprojectsbackend.model.Task;
import org.exam.diemprojectsbackend.repository.TaskRepository;
import org.springframework.stereotype.Service;

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

}
