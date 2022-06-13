package com.if5.todoapp.models.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String username;
	private String lastName;
	private String firstName;
	private String email;
	private String password;
	@Transient
	private String passwordConfirmation;
	private Integer phoneNumber;
	private String birthplace; 
    @Temporal(TemporalType.DATE)
	private Date birthDay;
	private String town;
	private String country;
	@ManyToMany(fetch = FetchType.EAGER)
	Collection<Role> roles = new ArrayList<>();
   // @OneToMany(mappedBy = "user")

	
	
	
	
}
