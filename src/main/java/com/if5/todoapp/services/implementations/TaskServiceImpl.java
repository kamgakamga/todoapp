package com.if5.todoapp.services.implementations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.if5.todoapp.models.dtos.AppTaskDto;
import com.if5.todoapp.models.entities.AppTask;
import com.if5.todoapp.models.entities.TaskStatus;
import com.if5.todoapp.models.mappers.AppTaskMapper;
import com.if5.todoapp.repositories.AppTaskRepository;
import com.if5.todoapp.services.interfaces.TaskServiceInterface;

@Service
public class TaskServiceImpl implements TaskServiceInterface{

	@Autowired private AppTaskRepository appTaskRepository;
	@Autowired private AppTaskMapper appTaskMapper;
	
	
	@Override
	public AppTask saveTask(AppTaskDto appTaskDto) {
		
		AppTask tasks = appTaskMapper.appTaskDtoToAppTask(appTaskDto);
		
			  Date d1 = tasks.getStartDate();
			  Date d2 = tasks.getEndDate();
			     if(d1.after(d2))
			    	 {
			    	 throw new RuntimeException("la date de debut ne peut etre inferieur a la date de fin de la tache");
			    	 }
			     if(d2.before(new Date()))
			     {
			    	 throw new RuntimeException("la date de fin ne doit pas etre avant la date courante");
			     }
			 
			
				tasks.setStartDate(tasks.getStartDate());
				tasks.setEndDate(tasks.getEndDate());
				tasks.setCreatedAT(new Date());
				tasks.setTaskStatus(TaskStatus.EN_ATTENTE);
				tasks.setRealiser(false);
	         
		
		return appTaskRepository.save(tasks);
	}

	@Override
	public AppTask addTaskStatut(String taskname, TaskStatus taskstatus) {
		
		AppTask appTask = appTaskRepository.findByTaskTitle(taskname);
		
		appTask.setTaskStatus(taskstatus);
		      
		return appTask;
		
	}

	@Override
	public AppTask findByTaskTitle(String taskTitle) {
		
		return appTaskRepository.findByTaskTitle(taskTitle);
	}

	
	  @Override 
	  public void deleteTask(Long id) {
		  AppTask task = appTaskRepository.getById(id);
		     if(task.getSubStasks().isEmpty()) 
		  try {
				  appTaskRepository.delete(task);   
		  }catch (Exception e) {
			System.out.print(e.getMessage());
		  }
	 }

	@Override
	public List<AppTask> getAllTask() {
		return appTaskRepository.findAll();
	}
	  
	
	  @Override 
	  public AppTask updateTask(Long id,  AppTaskDto appTaskDto) {
	        AppTask task = appTaskRepository.findById(id).get();
	       
	        if(task == null) throw new RuntimeException("cette tache n'existe pas");
	        
	        AppTask tasks =appTaskMapper.appTaskDtoToAppTask(appTaskDto);
	           Date d1 = tasks.getStartDate();
			   Date d2 = tasks.getEndDate();
			  
			   if(d1.after(d2))throw new RuntimeException("la date de debut ne peut etre inferieur a la date de fin de la tache");
	       
			        task.setTaskTitle(tasks.getTaskTitle());
			        task.setDescriptionTask(tasks.getDescriptionTask());
			        task.setStartDate(tasks.getStartDate());
			        task.setEndDate(tasks.getEndDate());
			        task.setReminderPlace(tasks.getReminderPlace());
			      //task.setLatitude(tasks.getLatitude());
			      //task.setLongitude(tasks.getLongitude());
			        task.setCreatedAT(tasks.getCreatedAT());
			        task.setUpdatedAt(new Date());
			        
		  return appTaskRepository.save(task); 
	  }

	@Override
	public void showDetailsOfAtask(Long id) {
		AppTask task = appTaskRepository.findById(id).get();
		
		List<String>  details = new ArrayList<String>();
		   details.add(task.getTaskTitle());
		   details.add(task.getDescriptionTask());
		   details.add(task.getReminderPlace());
	}

	@Override
	public List<AppTask> numberOfTasksPerformedInAPeriod(Date debut, Date fin) {
		
		return null;
	}

	@Override
	public void CalculateTheNumberOfWorkingHours(Date debut, Date fin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void taskManager() {
		
		Date dateActuel = new Date();
		
		List<AppTask> tasks = appTaskRepository.findAll();
		
		for (AppTask appTask : tasks) {
			
			if(appTask.getStartDate().compareTo(dateActuel) == 1) {
			appTask.setTaskStatus(TaskStatus.EN_COURS);
			appTaskRepository.save(appTask);
			}else if(dateActuel.after(appTask.getEndDate()) && appTask.isRealiser()== false) {
				appTask.setTaskStatus(TaskStatus.REALISEE);
				 
			}
		}
		 
	}

	@Override
	public void changeTaskStatus(Long id, TaskStatus statut) {
	
		 
		AppTask appTask = appTaskRepository.findById(id).get();
		
		 Date startDate = appTask.getStartDate();

		 Date actualDate = new Date();
		 
		 Date endDate = appTask.getEndDate();
		
		if (startDate.before(actualDate) && statut == TaskStatus.EN_COURS) {
			
			appTask.setTaskStatus(TaskStatus.EN_COURS);
			appTaskRepository.save(appTask);
			
		}else
		if((startDate.before(actualDate)) && (statut == TaskStatus.REALISEE)) {
			appTask.setTaskStatus(statut); 
			
			appTaskRepository.save(appTask);
			System.out.print("--------------------------------------------------------------------------------");
			System.out.print("-------------------------------REALISER-------------------------------------------------");
		}else
		if((startDate.before(actualDate)) && (endDate.after(actualDate)) && (statut == TaskStatus.EN_COURS )) {
			appTask.setTaskStatus(statut);	
			appTaskRepository.save(appTask);
			System.out.print("--------------------------------------------------------------------------------");
			System.out.print("-------------------------------EN_COURS-------------------------------------------------");
		}else
		if((endDate.before(actualDate)) && appTask.getTaskStatus() != TaskStatus.REALISEE) {
			appTask.setTaskStatus(TaskStatus.EN_RETARD);
			appTaskRepository.save(appTask);
			System.out.print("--------------------------------------------------------------------------------");
			System.out.print("-------------------------------EN RETARD-------------------------------------------------");
		}
			
		else {
			appTask.setTaskStatus(TaskStatus.ANNULE);
			appTaskRepository.save(appTask);
			System.out.print("--------------------------------------------------------------------------------");
			System.out.print("-------------------------------ANNULE-------------------------------------------------");
		}
	}
	
	@Override
	public void addParentTask(AppTask appTask, AppTask appTask1) {
		
		/*
		 * AppTask parentTask = appTaskRepository.findByTaskTitle(app) AppTask subTask =
		 * appTask.getParentTask(); if(appTask1 == null) throw new
		 * RuntimeException("verifier la tache parente");
		 * appTask.setParentTask(appTask1);
		 * 
		 * AppTask appTask = findByTaskTitle(parentTask.getTaskTitle()); if(appTask ==
		 * null) throw new RuntimeException("verifier la tache parente");
		 * 
		 * List<AppTask> subStasks = (List<AppTask>) tasks.getSubStasks();
		 * if(subStasks.size() == 0) throw new RuntimeException("pas de sous tache");
		 */
	}

	@Override
	public List<AppTask> taskAccordingToStatus(TaskStatus status) {
		
		List<AppTask> listOfTask = new ArrayList<>();
		 System.out.println("STATUT ===========> "+ status);
		listOfTask = appTaskRepository.findAllByTaskStatus(status);
		
		 System.out.println(listOfTask);
		listOfTask.forEach(task -> System.out.println(task));
		return listOfTask;
	}
	 
	 

}
