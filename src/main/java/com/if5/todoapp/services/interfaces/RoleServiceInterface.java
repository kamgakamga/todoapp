package com.if5.todoapp.services.interfaces;

import com.if5.todoapp.models.dtos.RoleDto;
import com.if5.todoapp.models.entities.Role;

public interface RoleServiceInterface {

	public Role sauveRole(RoleDto roleDto); 
	public Role findByRoleName(String roleName);
		
	public boolean isEmptyRole();
}
