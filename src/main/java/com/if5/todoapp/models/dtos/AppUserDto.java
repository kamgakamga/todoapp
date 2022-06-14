package com.if5.todoapp.models.dtos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.if5.todoapp.models.entities.Role;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserDto {

	private Long id;
	@NotNull(message = "le nom d'utilisateur est obligatoire")
	private String username;
	@NotNull(message = "le nom d'utilisateur est obligatoire")
	private String lastName;
	private String firstName;
	@NotNull(message = "le l'emeil de l'utilisateur est obligatoire")
	private String email;
	@NotNull(message = "le mot de passe est obligatoire")
	private String password;
	@NotNull(message = "vous devez entrer la confirmation du mot de passe")
	private String passwordConfirmation;
	@Min(5)
	@Max(10)
	private Integer phoneNumber;
	private String birthplace; 
	private Date birthDay;
	private String town;
	private String country;
	private Collection<Role> roles = new ArrayList<>();
	//Collection<Task> tasks = new ArrayList<>();
}
