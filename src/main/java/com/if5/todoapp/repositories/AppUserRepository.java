package com.if5.todoapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.if5.todoapp.models.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

	public AppUser findByUsername(String userName);
}
