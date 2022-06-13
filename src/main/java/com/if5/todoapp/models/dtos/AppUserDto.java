package com.if5.todoapp.models.dtos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.if5.todoapp.models.entities.Role;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserDto {

	private Long id;
	private String username;
	private String lastName;
	private String firstName;
	private String email;
	private String password;
	private String passwordConfirmation;
	private Integer phoneNumber;
	private String birthplace; 
	private Date birthDay;
	private String town;
	private String country;
	private Collection<Role> roles = new ArrayList<>();
	//Collection<Task> tasks = new ArrayList<>();
}
