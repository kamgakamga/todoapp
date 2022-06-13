package com.if5.todoapp.models.mappers;

import org.mapstruct.Mapper;

import com.if5.todoapp.models.dtos.AppUserDto;
import com.if5.todoapp.models.entities.AppUser;

@Mapper(
componentModel = "spring"
		)
public interface AppUserMapper {

	public AppUser appUserDtoToAppUser(AppUserDto appUserDto);
	public AppUserDto appUserToAppUserDto(AppUser appUser);

}
