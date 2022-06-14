package com.if5.todoapp.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.if5.todoapp.models.entities.AppTask;
import com.if5.todoapp.models.entities.TaskStatus;

public interface AppTaskRepository extends JpaRepository<AppTask, Long> {

	public AppTask findByTaskTitle(String tasktitle);
	
	List<AppTask> findAllByTaskStatus(TaskStatus taskStatus);
	
	@Query(value="SELECT * FROM AppTask WHRERE startDate =:startDate  endDate=:endDate AND task_status = 1")
	List<AppTask> findAllByTaskStatus (@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
}
