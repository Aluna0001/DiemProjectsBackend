package org.tourexam.diemprojectsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tourexam.diemprojectsbackend.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
