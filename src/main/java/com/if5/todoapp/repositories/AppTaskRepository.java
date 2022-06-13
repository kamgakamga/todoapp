package com.if5.todoapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.if5.todoapp.models.entities.AppTask;
import com.if5.todoapp.models.entities.TaskStatus;

public interface AppTaskRepository extends JpaRepository<AppTask, Long> {

	public AppTask findByTaskTitle(String tasktitle);
	
	List<AppTask> findAllByTaskStatus(TaskStatus taskStatus);
}
