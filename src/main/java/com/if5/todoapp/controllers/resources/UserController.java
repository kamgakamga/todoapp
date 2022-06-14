package com.if5.todoapp.controllers.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.if5.todoapp.exceptions.handler.InvalidEntityException;
import com.if5.todoapp.models.dtos.AppUserDto;
import com.if5.todoapp.models.entities.AppUser;
import com.if5.todoapp.services.interfaces.AppUserServiceInterface;

@RestController
@RequestMapping("toDoApp/V1")
public class UserController {

	@Autowired private AppUserServiceInterface appUserServiceInterface;
	
	@PostMapping("/userRegister")
	public ResponseEntity<AppUser> saveUser(@RequestBody @Valid AppUserDto appUserDto){
		System.out.println(appUserDto.toString());
		if(!appUserDto.getPassword().equals(appUserDto.getPasswordConfirmation()) || appUserDto.getUsername() == null)
				                                         throw new RuntimeException("mot de passe incorrect");
		AppUser user = appUserServiceInterface.findByUsername(appUserDto.getUsername());
		if(user!=null)throw new RuntimeException("nom d'utilisateur deja present en base de donnée");
		appUserServiceInterface.saveUser(appUserDto);
		appUserServiceInterface.addRoleToUser(appUserDto.getUsername(), "USER");
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<AppUser>> getAllUsers (){
		return ResponseEntity.ok( appUserServiceInterface.getAllUsers());
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<AppUser> getUser(@PathVariable long id) throws InvalidEntityException{
		return ResponseEntity.ok(appUserServiceInterface.getUser(id));
	}
	
}
