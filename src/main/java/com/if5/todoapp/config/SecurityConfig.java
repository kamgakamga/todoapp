package com.if5.todoapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Autowired protected UserDetailsService userDetailsService;
	@Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(userDetailsService)
		     .passwordEncoder(bCryptPasswordEncoder);
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//cette ligne permet de desactiver le token csrf utililiser lors de l'authentification en memoire ou basique
				http.csrf().disable();
				//cette ligne permet d'activer l'authentification sans etat tout en desactivant l"authantification baser sur les session
				//http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
				http.formLogin();
				http.authorizeRequests().antMatchers("/login/**").permitAll();
				//http.authorizeRequests().antMatchers(HttpMethod.POST,"/userRegister/**").hasAnyAuthority("ADMIN","MANAGER","USER");
				http.authorizeRequests()
				    .anyRequest()
				    .authenticated();
	}

}
