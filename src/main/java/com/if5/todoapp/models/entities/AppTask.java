package com.if5.todoapp.models.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppTask {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column(unique = true)
	private String taskTitle;
    
    @Column(nullable = false)
	private String descriptionTask;
    
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	private String reminderPlace;
	
	private Double latitude;
	
	private Double longitude;
	
	//@Enumerated(EnumType.STRING)
	private TaskStatus taskStatus;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAT;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	
	private boolean realiser;
	@ManyToOne
	
	private AppUser user;
	
	@ManyToOne
	private AppTask parentTask;
	
	@OneToMany(mappedBy = "parentTask")
	private Collection<AppTask>  subStasks ;
	
	
	
	public AppTask(Long id, String taskTitle, String descriptionTask, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.taskTitle = taskTitle;
		this.descriptionTask = descriptionTask;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	
	
 
	
}
