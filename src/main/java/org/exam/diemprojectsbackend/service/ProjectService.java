package org.exam.diemprojectsbackend.service;

import org.springframework.stereotype.Service;
import org.exam.diemprojectsbackend.model.Project;
import org.exam.diemprojectsbackend.repository.ProjectRepository;

import java.util.List;

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

    //read
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
    //Read by one id
    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Project not found with id " + id));
    }
    //update
    public Project updateProject(long id, Project updatedProject) {
        Project existingProject = getProjectById(id); // Hent eksisterende

        existingProject.setProjectTitle(updatedProject.getProjectTitle());
        existingProject.setProjectDescription(updatedProject.getProjectDescription());
        existingProject.setBudget(updatedProject.getBudget());
        existingProject.setStartDate(updatedProject.getStartDate());
        existingProject.setEndDate(updatedProject.getEndDate());
        // Tilføj flere felter her efter behov

        return projectRepository.save(existingProject); // Gem opdateret
    }

    //delete
    public void deleteProject(long id) {
        projectRepository.deleteById(id);
    }
}
