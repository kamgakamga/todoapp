package com.if5.todoapp.models.dtos;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.if5.todoapp.models.entities.AppTask;
import com.if5.todoapp.models.entities.AppUser;
import com.if5.todoapp.models.entities.TaskStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppTaskDto {


	private Long id;
	@NotNull(message = "le lebelle d'une tache ne peut etre null")
	private String taskTitle;
	@NotNull(message = "la description d'une tache ne peut etre null")
	private String descriptionTask;
	private Date startDate;
	private Date endDate;
	private String reminderPlace;
	private Double latitude;
	private Double longitude;
	private TaskStatus taskStatus;
	private AppUser user;
	private Date createdAT;
	private Date updatedAt;
	private AppTask parentTask;
	private Collection<AppTask>  subStasks;
	
	
	
	public AppTaskDto(Long id, String taskTitle, String descriptionTask, Date startDate, Date endDate,TaskStatus taskStatus) {
		super();
		this.id = id;
		this.taskTitle = taskTitle;
		this.descriptionTask = descriptionTask;
		this.startDate = startDate;
		this.endDate = endDate;
		this.taskStatus = taskStatus;
	}
	
	
	
	
}
