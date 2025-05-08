package org.exam.diemprojectsbackend.controller;


import org.exam.diemprojectsbackend.model.SubTask;
import org.exam.diemprojectsbackend.service.SubTaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class SubTaskController {
    private final SubTaskService subTaskService;

    public SubTaskController(SubTaskService subTaskService) {
        this.subTaskService = subTaskService;
    }

    @PostMapping("/subtasks")
    @ResponseStatus(HttpStatus.CREATED)
    public SubTask createProject(@RequestBody SubTask subTask) {
        return subTaskService.createSubTask(subTask);
    }


}
