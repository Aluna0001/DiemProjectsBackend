package org.exam.diemprojectsbackend.service;

import org.exam.diemprojectsbackend.model.Project;
import org.exam.diemprojectsbackend.model.SubProject;
import org.exam.diemprojectsbackend.model.Task;
import org.exam.diemprojectsbackend.repository.ProjectRepository;
import org.exam.diemprojectsbackend.repository.SubProjectRepository;
import org.exam.diemprojectsbackend.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubProjectService {

    private final SubProjectRepository subProjectRepository;
    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

    public SubProjectService(SubProjectRepository subProjectRepository, ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.subProjectRepository = subProjectRepository;
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    //Create
    public SubProject createSubProject(SubProject subProject) {
        return subProjectRepository.save(subProject);
    }

    //read
    public List<SubProject> getAllSubProjects() {
        return subProjectRepository.findAll();
    }

    public SubProject getSubProjectById(Long id) {
        return subProjectRepository.findById(id).orElse(null);
    }

    public SubProject updateSubProject(long id, SubProject updatedSubProject) {
        SubProject existingSubProject = getSubProjectById(id);

        existingSubProject.setSubProjectTitle(updatedSubProject.getSubProjectTitle());
        existingSubProject.setSubProjectDescription(updatedSubProject.getSubProjectDescription());

        return subProjectRepository.save(existingSubProject);
    }

    public void deleteSubProject(Long id) {
        subProjectRepository.deleteById(id);
    }

    public SubProject createSubProjectForProject(Long projectId, SubProject subProject) {
        Project parentProject = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        subProject.setProject(parentProject);
        return subProjectRepository.save(subProject);
    }

    public Task createTaskForSubProject(Long subProjectId, Task task) {
        SubProject subProject = subProjectRepository.findById(subProjectId)
                .orElseThrow(() -> new RuntimeException("SubProject not found with id " + subProjectId));
        task.setSubProject(subProject); // Associate task with subproject
        return taskRepository.save(task);
    }

    public List<Task> getTasksForSubProject(Long subProjectId) {
        SubProject subProject = subProjectRepository.findById(subProjectId)
                .orElseThrow(() -> new RuntimeException("SubProject not found with id " + subProjectId));
        return subProject.getTasks(); // Assuming SubProject has a `tasks` field
    }
}


