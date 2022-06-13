package com.if5.todoapp.models.mappers;

import org.mapstruct.Mapper;

import com.if5.todoapp.models.dtos.RoleDto;
import com.if5.todoapp.models.entities.Role;

@Mapper(
componentModel = "spring"
		)
public interface RoleMapper {

	Role roleDtoToRole (RoleDto roleDto);
	RoleDto roleToRoleDto (Role role);
}
