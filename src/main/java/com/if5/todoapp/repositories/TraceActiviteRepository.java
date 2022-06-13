package com.if5.todoapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.if5.todoapp.models.entities.TraceActivite;

public interface TraceActiviteRepository extends JpaRepository<TraceActivite, Long> {

}
