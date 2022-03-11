package com.seneca.global.todoservice.service;

import java.util.List;

import com.seneca.global.dto.TaskDTO;
import com.seneca.global.todoservice.entity.Task;

public interface TaskService {
   
    
    TaskDTO create(String taskDesc);
    TaskDTO markAsDone(Long taskId);
    void deleteTask(Long taskId);
    TaskDTO updateDescription(Long taskID, String taskDesc);
    List<Task> fetchAllTasks();
}

