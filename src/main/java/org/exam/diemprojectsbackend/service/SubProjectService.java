package org.exam.diemprojectsbackend.service;


import org.exam.diemprojectsbackend.model.Project;
import org.exam.diemprojectsbackend.model.SubProject;
import org.exam.diemprojectsbackend.repository.ProjectRepository;
import org.exam.diemprojectsbackend.repository.SubProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubProjectService {

private final SubProjectRepository subProjectRepository;
private final ProjectRepository projectRepository;


    public SubProjectService(SubProjectRepository subProjectRepository, ProjectRepository projectRepository ) {
        this.subProjectRepository = subProjectRepository;
        this.projectRepository = projectRepository;
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


}


