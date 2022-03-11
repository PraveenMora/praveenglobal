package com.seneca.global.dto;

import java.time.LocalDateTime;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "TaskDTO")
public class TaskDTO {
	
	@Schema(description = "Task Id")
    private Long taskid;
    
	@Schema(description = "Task Description")
    private String description;

	@Schema(description = "Task created Date")
    private LocalDateTime createDate;

	@Schema(description = "Task Updated Date")
    private LocalDateTime updateDate;

	@Schema(description = "Task Status(true means Active/ false means Done)")
    private boolean status;
}
