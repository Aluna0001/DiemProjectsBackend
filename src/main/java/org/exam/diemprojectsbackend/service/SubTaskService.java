package org.exam.diemprojectsbackend.service;


import org.exam.diemprojectsbackend.model.SubTask;
import org.exam.diemprojectsbackend.repository.SubTaskRepository;
import org.springframework.stereotype.Service;

@Service
public class SubTaskService {

private final SubTaskRepository subTaskRepository;

    public SubTaskService(SubTaskRepository subTaskRepository) {
        this.subTaskRepository = subTaskRepository;
    }
    //Create
    public SubTask createSubTask(SubTask subTask) {
        return subTaskRepository.save(subTask);
    }
}
