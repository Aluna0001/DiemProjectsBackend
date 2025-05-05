package org.tourexam.diemprojectsbackend.service;

import org.springframework.stereotype.Service;
import org.tourexam.diemprojectsbackend.model.Project;
import org.tourexam.diemprojectsbackend.repository.ProjectRepository;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }
}
