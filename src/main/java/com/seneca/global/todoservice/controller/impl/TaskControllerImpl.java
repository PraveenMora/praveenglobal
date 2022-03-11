package com.seneca.global.todoservice.controller.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seneca.global.dto.TaskDTO;
import com.seneca.global.todoservice.controller.TaskController;
import com.seneca.global.todoservice.service.TaskService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@Validated
@SecurityRequirement(name="todoapi")
public class TaskControllerImpl implements TaskController{
	
	@Autowired
	TaskService taskService;
	
	@Override
	@PostMapping("/create-task")
	public ResponseEntity<TaskDTO> createTask(
			@RequestParam(name = "taskDesc")  String taskDesc) {
		return new ResponseEntity<>(taskService.create(taskDesc), HttpStatus.OK);
	}

	@Override
	@PutMapping("/update-status")
	public ResponseEntity<TaskDTO> updateTaskStatus(
			@RequestParam(name = "taskID") Long taskID) {
		return new ResponseEntity<>(taskService.markAsDone(taskID), HttpStatus.OK);
	}

	@Override
	@DeleteMapping("/delete-task")
	public ResponseEntity<TaskDTO> deleteTask(@Valid Long taskID) {
		taskService.deleteTask(taskID);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@Override
	@PutMapping("/update-task")
	public ResponseEntity<TaskDTO> updateTaskText(
			@RequestParam(name = "taskID") Long taskID,
			@RequestParam(name = "taskDesc")  String taskDesc) {
		return new ResponseEntity<>(taskService.updateDescription(taskID, taskDesc), HttpStatus.OK);
	}
	
	@Override
	@GetMapping("/fetch-list")
	public ResponseEntity<?> getTaskList() {
		return new ResponseEntity<>(taskService.fetchAllTasks(),HttpStatus.OK);
	}

	

	

	
	
}
