package com.if5.todoapp.models.mappers;

import org.mapstruct.Mapper;

import com.if5.todoapp.models.dtos.AppTaskDto;
import com.if5.todoapp.models.entities.AppTask;

@Mapper(
  componentModel = "spring"		
)
public interface AppTaskMapper {

	 AppTaskDto appTaskToAppTaskDto(AppTask appTask);
	 AppTask appTaskDtoToAppTask(AppTaskDto appTaskDto);
}
