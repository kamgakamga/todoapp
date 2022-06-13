package com.if5.todoapp.services.interfaces;

import java.util.Date;
import java.util.List;


import com.if5.todoapp.models.dtos.AppTaskDto;
import com.if5.todoapp.models.entities.AppTask;
import com.if5.todoapp.models.entities.TaskStatus;

public interface TaskServiceInterface {

	public List<AppTask> getAllTask();
	public AppTask saveTask(AppTaskDto appTaskDto);
	public AppTask addTaskStatut(String taskname, TaskStatus taskstatus);
	public AppTask findByTaskTitle(String taskTitle);
	public void deleteTask(Long id);
	public AppTask updateTask(Long id,AppTaskDto appTaskDto);
	public void showDetailsOfAtask (Long id);
	public void taskManager();
	public List<AppTask> numberOfTasksPerformedInAPeriod (Date debut, Date fin);
	public void CalculateTheNumberOfWorkingHours(Date debut, Date fin);
	public void changeTaskStatus( Long id, TaskStatus status);
	public void addParentTask(AppTask appTask, AppTask appTask1);
	public List<AppTask> taskAccordingToStatus( TaskStatus status);
}
