package com.if5.todoapp.services.implementations;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.if5.todoapp.models.entities.AppUser;
import com.if5.todoapp.services.interfaces.AppUserServiceInterface;



@Service
public class UserDetailsServiceImpl implements UserDetailsService{

          @Autowired private AppUserServiceInterface appUserServiceInterface;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser appUser = appUserServiceInterface.findByUsername(username);
		System.out.println("l'utilisateur: "+appUser.toString());
		if(appUser == null) { throw new UsernameNotFoundException(username);}
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		          appUser.getRoles().forEach(r->{
		    	  authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
		    	  
		    	 
		      });
		return new User(appUser.getUsername(),appUser.getPassword(),authorities);
	} 

}
