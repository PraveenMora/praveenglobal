package com.seneca.global.todoservice.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TASK")
public class Task implements Serializable{
    private static final long serialVersionUID = 1L;

	/*
	 * taskID
	 * taskDescription 
	 * created_date 
	 * updated_date 
	 * status
	 */
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TASK_ID")
    private Long id;
    
    @Column(unique =true, name = "TASK_TEXT", nullable = false)
    private String description;

    @Column(name = "CREATE_DATE", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "UPDATE_DATE", nullable = false)
    private LocalDateTime updateDate;

    // true means active, false means Done
    @Column(name = "TASK_STATUS", nullable = false)
    private boolean status;
   
    
    @PrePersist
    public void preCreate() {
        final LocalDateTime taskCreateDate = LocalDateTime.now();
        setCreateDate(taskCreateDate);
        setUpdateDate(taskCreateDate);
    }

    @PreUpdate
    public void preUpdate() {
        final LocalDateTime taskUpdateDate = LocalDateTime.now();
        setUpdateDate(taskUpdateDate);
    }
}
