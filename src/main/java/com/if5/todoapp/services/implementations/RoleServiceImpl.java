package com.if5.todoapp.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.if5.todoapp.models.dtos.RoleDto;
import com.if5.todoapp.models.entities.Role;
import com.if5.todoapp.models.mappers.RoleMapper;
import com.if5.todoapp.repositories.RoleRepository;
import com.if5.todoapp.services.interfaces.RoleServiceInterface;


@Service
public class RoleServiceImpl implements RoleServiceInterface {

	@Autowired private RoleRepository roleRepository;
	@Autowired private RoleMapper roleMapper;
	
	
	@Override
	public Role sauveRole(RoleDto roleDto) {
		Role role = roleMapper.roleDtoToRole(roleDto);
		return roleRepository.save(role);
	}

	@Override
	public Role findByRoleName(String roleName) {
		return roleRepository.findByRoleName(roleName);
	}

	@Override
	public boolean isEmptyRole() {
		return roleRepository.count()==0;
	}

}
