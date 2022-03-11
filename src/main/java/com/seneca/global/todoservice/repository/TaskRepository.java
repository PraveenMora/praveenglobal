package com.seneca.global.todoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seneca.global.todoservice.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
