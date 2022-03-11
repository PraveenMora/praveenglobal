package com.seneca.global.todoservice.controller;



import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.seneca.global.dto.TaskDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;

@Tag(name = "TodoService API", description = "API related to Todo")
public interface TaskController {

	@Operation(summary = "Create TODO task", description = "API to create task")
	@ApiResponses({
			@ApiResponse(
					responseCode = "200",
					description = "Task created",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = TaskDTO.class))),
			@ApiResponse(
					responseCode = "400",
					description = "Invalid format",
					content = {@Content(mediaType = "application/json")}),
			@ApiResponse(
					responseCode = "500",
					description = "Internal Server Error",
					content = {@Content(mediaType = "application/json") })
	})
	ResponseEntity<TaskDTO> createTask(
			@Parameter(name = "taskDesc", description = "Description of the Task" ) @Valid String taskDesc
			);
	
	
	@Operation(summary = "Update Task Status ", description = "API to Update Task based on Task Id")
	@ApiResponses({
		@ApiResponse(
				responseCode = "200",
				description = "Task Status Updated To Done",
				content = {@Content(mediaType = "application/json")}),
		@ApiResponse(
                responseCode = "400",
                description = "Error Updating Task",
                content = {@Content(mediaType = "application/json"
                
                		)}),
        @ApiResponse(
                responseCode = "404",
                description = "Task Details not found",
                content = {@Content(mediaType = "application/json"
                )}),
        @ApiResponse(
                responseCode = "500",
                description = "Internal Server Error",
                content = {@Content(mediaType = "application/json"
                )})	})
	ResponseEntity<TaskDTO> updateTaskStatus(
			@Parameter(name = "taskID", description = "Task ID that has already exists" ) @Valid Long taskID
			);
	
	
	@Operation(summary = "Delete Task ", description = "API to Delete Task based on Task Id")
	@ApiResponses({
		@ApiResponse(
				responseCode = "200",
				description = "Task Deleted",
				content = {@Content(mediaType = "application/json")}),
		@ApiResponse(
                responseCode = "400",
                description = "Error Deleting Task",
                content = {@Content(mediaType = "application/json"
                
                		)}),
        @ApiResponse(
                responseCode = "404",
                description = "Task Details not found",
                content = {@Content(mediaType = "application/json"
                )}),
        @ApiResponse(
                responseCode = "500",
                description = "Internal Server Error",
                content = {@Content(mediaType = "application/json"
                )})	})
	ResponseEntity<TaskDTO> deleteTask(
			@Parameter(name = "taskID", description = "Task ID that has already exists" ) @Valid Long taskID);

	
	@Operation(summary = "Update Task Text", description = "API to Update Task based on Task Id")
	@ApiResponses({
		@ApiResponse(
				responseCode = "200",
				description = "Task Details Update",
				content = {@Content(mediaType = "application/json", schema = @Schema(implementation = TaskDTO.class))}),
		@ApiResponse(
                responseCode = "400",
                description = "Error Updating Task Details search",
                content = {@Content(mediaType = "application/json"
                
                		)}),
        @ApiResponse(
                responseCode = "404",
                description = "Task Details not found",
                content = {@Content(mediaType = "application/json"
                )}),
        @ApiResponse(
                responseCode = "500",
                description = "Internal Server Error",
                content = {@Content(mediaType = "application/json"
                )})	})
	ResponseEntity<TaskDTO> updateTaskText(
			@Parameter(name = "taskID", description = "Task ID that has already exists" ) @Valid Long taskID,
			@Parameter(name = "taskDesc", description = "Description of the Task to be updated" ) @Valid String taskDesc);
	
	
	
	@Operation(summary = "Fetch Task list", description = "API to Fetch Task List")
	@ApiResponses({ 
		@ApiResponse(
				responseCode = "200", 
				description = "Task List search",
				content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(type = "array", implementation = TaskDTO.class)))}),
		@ApiResponse(
                responseCode = "400",
                description = "Error Processing Task Details search",
                content = {@Content(mediaType = "application/json"
                )}),
        @ApiResponse(
                responseCode = "404",
                description = "Task Details not found",
                content = {@Content(mediaType = "application/json"
                )}),
        @ApiResponse(
                responseCode = "500",
                description = "Internal Server Error",
                content = {@Content(mediaType = "application/json"
                )})	})
	ResponseEntity<?> getTaskList();



	
	
	
	
	
	
}
