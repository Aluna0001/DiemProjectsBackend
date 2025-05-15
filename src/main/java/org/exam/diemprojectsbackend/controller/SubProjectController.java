package org.exam.diemprojectsbackend.controller;

import org.exam.diemprojectsbackend.model.SubProject;
import org.exam.diemprojectsbackend.model.Task;
import org.exam.diemprojectsbackend.service.SubProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController()
@RequestMapping("/subprojects")
public class SubProjectController {
    private final SubProjectService subProjectService;

    public SubProjectController(SubProjectService subProjectService) {
        this.subProjectService = subProjectService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public SubProject createSubProject(@RequestBody SubProject subProject) {
        return subProjectService.createSubProject(subProject);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<SubProject>> getAllSubProjects() {
        return ResponseEntity.ok(subProjectService.getAllSubProjects());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<SubProject> getSubTaskById(@PathVariable long id) {
        return ResponseEntity.ok(subProjectService.getSubProjectById(id));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<SubProject> updateProject(@PathVariable long id, @RequestBody SubProject subTask) {
        return ResponseEntity.ok(subProjectService.updateSubProject(id, subTask));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubProject(@PathVariable long id) {
        subProjectService.deleteSubProject(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{subProjectId}/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTaskForSubProject(@PathVariable Long subProjectId, @RequestBody Task task) {
        return subProjectService.createTaskForSubProject(subProjectId, task);
    }

    @GetMapping("/{subProjectId}/tasks")
    public ResponseEntity<List<Task>> getTasksForSubProject(@PathVariable Long subProjectId) {
        return ResponseEntity.ok(subProjectService.getTasksForSubProject(subProjectId));
    }
}
