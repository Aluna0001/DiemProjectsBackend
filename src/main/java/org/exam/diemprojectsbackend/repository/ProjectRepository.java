package org.exam.diemprojectsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.exam.diemprojectsbackend.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
