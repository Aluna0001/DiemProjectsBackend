package org.exam.diemprojectsbackend.service;

import org.springframework.stereotype.Service;
import org.exam.diemprojectsbackend.model.Project;
import org.exam.diemprojectsbackend.repository.ProjectRepository;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

//Create
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }
}
