package com.crystalcrumbs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	@Autowired
	private UserDetailsService userDetailsService;


	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.csrf(Customizer->Customizer.disable());
		http.authorizeHttpRequests(authorizeHttp -> authorizeHttp.requestMatchers("add-user")
				.permitAll().anyRequest().authenticated());
		http.httpBasic(Customizer.withDefaults());
		http.sessionManagement(Session->Session.
				sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		
		return http.build();
	}
	
	
	@Bean
	public AuthenticationProvider authProvider() {
		
//		DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();// Deprecated
//		daoProvider.setUserDetailsService(UserDetailsService);//Deprecated
		DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider(userDetailsService);
		daoProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		
		
		return daoProvider;
	}
	
//	@Bean
//	public UserDetailsService userDetails() {
//		UserDetails user = User.withDefaultPasswordEncoder()
//				.username("james")
//				.password("banks")
//				.roles("USER")
//				.build();
//		
//		UserDetails admin = User.withDefaultPasswordEncoder()
//				.username("leyrab")
//				.password("banks")
//				.roles("ADMIN")
//				.build();
//		
//		return new InMemoryUserDetailsManager(user,admin);
//	}
	
	

}
