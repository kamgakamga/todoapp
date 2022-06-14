package com.if5.todoapp.services.interfaces;

import java.util.Date;
import java.util.List;

import com.if5.todoapp.exceptions.handler.EntityNotFoundException;
import com.if5.todoapp.exceptions.handler.InvalidEntityException;
import com.if5.todoapp.models.dtos.AppTaskDto;
import com.if5.todoapp.models.dtos.NumberTaskDto;
import com.if5.todoapp.models.entities.AppTask;
import com.if5.todoapp.models.entities.TaskStatus;

public interface TaskServiceInterface {

	public List<AppTask> getAllTask();
	public AppTask saveTask(AppTaskDto appTaskDto) throws InvalidEntityException;
	public AppTask addTaskStatut(String taskname, TaskStatus taskstatus);
	public AppTask findByTaskTitle(String taskTitle);
	public void deleteTask(Long id);
	public AppTask updateTask(Long id,AppTaskDto appTaskDto) throws InvalidEntityException;
	public void showDetailsOfAtask (Long id) throws EntityNotFoundException;
	public void taskManager();
	public int numberOfTasksPerformedInAPeriod (NumberTaskDto numberTaskDto);
	public void CalculateTheNumberOfWorkingHours(Date debut, Date fin);
	public void changeTaskStatus( Long id, TaskStatus status);
	public void addParentTask(AppTask appTask, AppTask appTask1);
	public List<AppTask> taskAccordingToStatus( TaskStatus status);
}
