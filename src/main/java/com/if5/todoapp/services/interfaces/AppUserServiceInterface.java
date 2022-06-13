package com.if5.todoapp.services.interfaces;

import java.util.List;

import com.if5.todoapp.models.dtos.AppUserDto;
import com.if5.todoapp.models.entities.AppUser;

public interface AppUserServiceInterface {
	
	public AppUser saveUser(AppUserDto appUserDto);
	public List<AppUser>  getAllUsers();
	public AppUser getUser(Long id);
	public void updateUser(AppUser appUser);
	
	public AppUser findByUsername(String userName);
	public void addRoleToUser(String userName, String roleName);
	
	public boolean isEmptyUser();

}
