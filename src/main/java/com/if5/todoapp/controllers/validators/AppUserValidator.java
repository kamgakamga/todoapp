package com.if5.todoapp.controllers.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.if5.todoapp.models.dtos.AppUserDto;

public class AppUserValidator {

	public static List<String> validate(AppUserDto appUserDto ){
		List<String> errors = new ArrayList<>();
		
		if(appUserDto == null){
			errors.add("Le nom d'utilisateur est obligatoire");	
			errors.add("Le nom de famille est obligatoire");
			errors.add("L'email est obligatoire");	
			errors.add("la date de naissance est obligatiore");	
			errors.add("le mot de passe est obligatoire");	
			errors.add("vous devez confirmer votre mot de passe");	
		}
		
		if(!StringUtils.hasLength(appUserDto.getUsername())) {
			errors.add("Le nom d'utilisateur est obligatoire");	
		}
		if(!StringUtils.hasLength(appUserDto.getLastName())) {
			errors.add("Le nom de famille est obligatoire");	
		}
		if(!StringUtils.hasLength(appUserDto.getEmail())) {
			errors.add("L'email est obligatoire");	
		}
		if(appUserDto.getBirthDay()==null) {
			errors.add("la date de naissance est obligatiore");	
		}
		if(!StringUtils.hasLength(appUserDto.getPassword())) {
			errors.add("le mot de passe est obligatoire");	
		}
		if(!StringUtils.hasLength(appUserDto.getPasswordConfirmation())) {
			errors.add("vous devez confirmer votre mot de passe");	
		}
		
		
		
		return errors;
	}
}
