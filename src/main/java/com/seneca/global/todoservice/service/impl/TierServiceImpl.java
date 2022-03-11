package com.seneca.global.todoservice.service.impl;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seneca.global.dto.TaskDTO;
import com.seneca.global.todoservice.entity.Task;
import com.seneca.global.todoservice.repository.TaskRepository;
import com.seneca.global.todoservice.service.TaskService;


@Service
public class TierServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
 

	@Override
	public TaskDTO create(String taskDesc) {
		//DTO to entity .. we can also use model mapper libray  instead of setitng here
				Task todoTask = new Task();
				todoTask.setCreateDate(LocalDateTime.now());
				todoTask.setDescription(taskDesc);
				todoTask.setStatus(true);
				
				Task task = taskRepository.save(todoTask);
				TaskDTO taskDTO = new TaskDTO();
				if(task.getId()!=null) {
					taskDTO = TaskDTO.builder()
							.taskid(task.getId())
							.description(taskDesc)
							.status(true)
							.createDate(task.getCreateDate())
							.build();
				}else {
					
				}
				
				return taskDTO;
		
	}

	@Override
	public TaskDTO markAsDone(Long taskId) {
		TaskDTO taskDTO = new TaskDTO();
		Optional<Task> task = taskRepository.findById(taskId);
		if(task.isPresent()) {
			task.get().setStatus(false); // setting false means it is done
			task.get().setUpdateDate(LocalDateTime.now()); // update the time for this status update
			Task taskUpdated = taskRepository.save(task.get());
			if(!taskUpdated.isStatus()) {
				taskDTO.setTaskid(taskId);
				taskDTO.setCreateDate(taskUpdated.getCreateDate());
				taskDTO.setDescription(taskUpdated.getDescription());
				taskDTO.setStatus(taskUpdated.isStatus());
			}else {
				
			}
		}
		
		return taskDTO;
	}

	@Override
	public void deleteTask(Long taskId) {
		taskRepository.deleteById(taskId);
	}
	
	@Override
	public TaskDTO updateDescription(Long taskID, String taskDesc) {
		TaskDTO taskDTO = new TaskDTO();
		Optional<Task> task = taskRepository.findById(taskID);
		
		if(task.isPresent()) {
			task.get().setDescription(taskDesc); // setting false means it is done
			task.get().setUpdateDate(LocalDateTime.now()); // update the time for this status update
			Task taskUpdated = taskRepository.save(task.get());
			if(!taskUpdated.isStatus()) {
				taskDTO.setTaskid(taskID);
				taskDTO.setCreateDate(taskUpdated.getCreateDate());
				taskDTO.setDescription(taskUpdated.getDescription());
				taskDTO.setStatus(taskUpdated.isStatus());
				taskDTO.setUpdateDate(taskUpdated.getUpdateDate());
			}else {
				
			}
		}
		return taskDTO;
	}

	@Override
	public List<Task> fetchAllTasks() {
		return taskRepository.findAll();
	}
}

