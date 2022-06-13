package com.if5.todoapp;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.if5.todoapp.models.dtos.AppUserDto;
import com.if5.todoapp.models.dtos.RoleDto;
import com.if5.todoapp.services.interfaces.RoleServiceInterface;
import com.if5.todoapp.services.interfaces.AppUserServiceInterface;

@SpringBootApplication
public class ToDoAppApplication implements CommandLineRunner {

	
	@Autowired private AppUserServiceInterface appUserServiceInterface;
	@Autowired  private RoleServiceInterface roleServiceInterface;
	//@Autowired  private TaskServiceInterface taskServiceInterface;
	public static void main(String[] args) {
		SpringApplication.run(ToDoAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	 
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = simpleDateFormat.parse("25/12/2010"); 
		
		
		
		if(appUserServiceInterface.isEmptyUser()) {
			appUserServiceInterface.saveUser(new AppUserDto(null,"foto","foto","mena","mena@gmail.com","foto","foto", 676414224,"ebang",date,"yaounde","cameroun",null));
			appUserServiceInterface.saveUser(new AppUserDto(null,"kuate","kuate","jean","mena@gmail.com","foto","foto", 676414224,"ebang",date,"yaounde","cameroun",null));
			appUserServiceInterface.saveUser(new AppUserDto(null,"talla","talla","pierre","mena@gmail.com","foto","foto", 676414224,"ebang",date,"yaounde","cameroun",null));
			
		}
		if(roleServiceInterface.isEmptyRole()) {
			roleServiceInterface.sauveRole(new RoleDto(null, "ADMIN"));
			roleServiceInterface.sauveRole(new RoleDto(null, "USER"));
			roleServiceInterface.sauveRole(new RoleDto(null, "MANAGER"));
				
		}
		
		if(!appUserServiceInterface.isEmptyUser()) {
			appUserServiceInterface.getAllUsers().forEach(u->{
				if(u.getRoles().isEmpty()) {
					appUserServiceInterface.addRoleToUser(u.getUsername(), "USER");
					if(u.getUsername().equalsIgnoreCase("foto")) {
						appUserServiceInterface.addRoleToUser(u.getUsername(), "ADMIN");
						appUserServiceInterface.addRoleToUser(u.getUsername(), "MANAGER");
					} else if(u.getUsername().equalsIgnoreCase("talla")) {
						appUserServiceInterface.addRoleToUser(u.getUsername(), "ADMIN");
					}
				}
			});
		}
		
	}

}
