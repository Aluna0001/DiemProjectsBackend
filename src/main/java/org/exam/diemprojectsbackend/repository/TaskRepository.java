package org.exam.diemprojectsbackend.repository;

import org.exam.diemprojectsbackend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
