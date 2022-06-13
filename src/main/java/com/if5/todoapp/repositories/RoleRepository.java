package com.if5.todoapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.if5.todoapp.models.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findByRoleName(String roleName);
}
