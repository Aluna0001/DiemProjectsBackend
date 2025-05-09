package org.exam.diemprojectsbackend.repository;

import org.exam.diemprojectsbackend.model.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTaskRepository extends JpaRepository<SubTask, Long> {
}
