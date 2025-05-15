package org.exam.diemprojectsbackend.controller;

import org.exam.diemprojectsbackend.model.SubProject;
import org.exam.diemprojectsbackend.service.SubProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.exam.diemprojectsbackend.model.Project;
import org.exam.diemprojectsbackend.service.ProjectService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ProjectController {

    private final ProjectService projectService;
    private final SubProjectService subProjectService;

    public ProjectController(ProjectService projectService, SubProjectService subProjectService) {
        this.projectService = projectService;
        this.subProjectService = subProjectService;
    }
    // Create
    @PostMapping("/projects")
    @ResponseStatus(HttpStatus.CREATED)
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    // READ ALL
    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    // READ BY ID
    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable long id) {
        return ResponseEntity.ok(projectService.getProjectById(id));
    }

    //update
    @PutMapping("/projects/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable long id, @RequestBody Project project) {
        return ResponseEntity.ok(projectService.updateProject(id, project));
    }

    // DELETE
    @DeleteMapping("/projects/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/projects/{projectId}/subprojects")
    @ResponseStatus(HttpStatus.CREATED)
    public SubProject createSubProjectForProject(
            @PathVariable Long projectId,
            @RequestBody SubProject subProject
    ) {
        return subProjectService.createSubProjectForProject(projectId, subProject);
    }
}
