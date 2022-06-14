package com.if5.todoapp.services.implementations;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.if5.todoapp.exceptions.handler.InvalidEntityException;
import com.if5.todoapp.models.dtos.AppUserDto;
import com.if5.todoapp.models.entities.Role;
import com.if5.todoapp.models.entities.AppUser;
import com.if5.todoapp.models.mappers.AppUserMapper;
import com.if5.todoapp.repositories.RoleRepository;
import com.if5.todoapp.repositories.AppUserRepository;
import com.if5.todoapp.services.interfaces.AppUserServiceInterface;

@Service
@Transactional
public class AppUserServiceImpl implements AppUserServiceInterface {

	@Autowired
	private AppUserMapper userMapper;
	@Autowired
	private AppUserRepository appUserRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public AppUser saveUser(AppUserDto appUserDto) {
		AppUser appUser = userMapper.appUserDtoToAppUser(appUserDto);
		String hashPWD = bCryptPasswordEncoder.encode(appUser.getPassword());
		appUser.setPassword(hashPWD);
		System.out.print(appUser.toString());
		return appUserRepository.save(appUser);
	}

	@Override
	public List<AppUser> getAllUsers() {

		return appUserRepository.findAll();
	}

	@Override
	public AppUser getUser(Long id) throws InvalidEntityException {
		
		Optional<AppUser> optionalUser = appUserRepository.findById(id);
		if (optionalUser.isEmpty()) {
			throw new InvalidEntityException("l'utlisateeur avec l'ID "+ id +" n'existe pas!");
		}else {
			AppUser appUser = optionalUser.get();
			return appUser;
		}	
		
	}

	@Override
	public void updateUser(AppUser appUser) {

	}

	

	@Override
	public void addRoleToUser(String userName, String roleName) {
		AppUser user = appUserRepository.findByUsername(userName);
		Role roles = roleRepository.findByRoleName(roleName);
		user.getRoles().add(roles);

	}

	@Override
	public boolean isEmptyUser() {
		// TODO Auto-generated method stub
		return appUserRepository.count()==0;
	}

	
	  @Override 
	  public AppUser findByUsername(String userName) {
		  
		  return appUserRepository.findByUsername(userName);
	  }
	 
}
