package com.if5.todoapp.controllers.resources;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.if5.todoapp.exceptions.handler.InvalidEntityException;
import com.if5.todoapp.models.dtos.AppTaskDto;
import com.if5.todoapp.models.dtos.NumberTaskDto;
import com.if5.todoapp.models.entities.AppTask;
import com.if5.todoapp.models.entities.TaskStatus;
import com.if5.todoapp.services.interfaces.TaskServiceInterface;

@RestController
@RequestMapping("/toDoApp/V1")
public class TaskController {

	@Autowired private TaskServiceInterface taskServiceInterface;
	
	@PostMapping("/task")
	public ResponseEntity<AppTask> saveTask(@RequestBody @Valid AppTaskDto appTaskDto, HttpServletRequest request) throws InvalidEntityException {
		AppTask appTask = taskServiceInterface.findByTaskTitle(appTaskDto.getTaskTitle());
		if(appTask != null) throw new RuntimeException("tache deja existante");
		//taskServiceInterface.addTaskStatut(appTaskDto.getTaskTitle(), TaskStatus.EN_ATTENTE);
	  
		return new ResponseEntity<>(taskServiceInterface.saveTask(appTaskDto), HttpStatus.CREATED);
		
	}
	
	
	  @GetMapping("/tasks")
	  public ResponseEntity<List<AppTask>> getAllTask(){
	  return ResponseEntity.ok(taskServiceInterface.getAllTask()); }
	 
	
	
	  @DeleteMapping("/task/delete/{id}") 
	  public void deleteTask(@PathVariable Long id) {
		          taskServiceInterface.deleteTask(id);
		  }
	 
	
	
	  @PutMapping("/task/update/{id}") 
	  public ResponseEntity<AppTask> updateTask(@PathVariable Long id, @RequestBody AppTaskDto appTaskDto) throws InvalidEntityException {
		  return new ResponseEntity<>(taskServiceInterface.updateTask(id, appTaskDto),HttpStatus.OK);
	  }
	  
	  @PutMapping("/change/statut/{id}")
	  public void changeTaskStatus(@PathVariable Long id, @RequestParam TaskStatus statut ) {
		  System.out.print(id+" "+ statut);
		  taskServiceInterface.changeTaskStatus(id, statut );
		  System.out.print(id+" "+ statut);
		  
	  }
	  
	  @GetMapping("/tasks/status")
	  
	  public ResponseEntity<List<AppTask>> taskAccordingToStatus(@RequestParam String status)  {
		  
		  TaskStatus statut = TaskStatus.valueOf(status);
		  
		  return ResponseEntity.ok( taskServiceInterface.taskAccordingToStatus(statut));
	}
	  
	  @PostMapping("/number/task")
	  public ResponseEntity<Integer> numberOfTasksPerformedInAPeriod(@RequestBody NumberTaskDto numberTaskDto  ){
		 
		 System.out.println(numberTaskDto.getStartDate());
		 System.out.println(numberTaskDto.getEndDate());
		 
		 Integer numberOfTask = taskServiceInterface.numberOfTasksPerformedInAPeriod(numberTaskDto); 
		  return ResponseEntity.ok(numberOfTask);
	  }
	 
}
