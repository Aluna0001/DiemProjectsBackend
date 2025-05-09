package org.exam.diemprojectsbackend.service;


import org.exam.diemprojectsbackend.model.SubProject;
import org.exam.diemprojectsbackend.repository.SubProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubProjectService {

private final SubProjectRepository subProjectRepository;

    public SubProjectService(SubProjectRepository subProjectRepository) {
        this.subProjectRepository = subProjectRepository;
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

}


