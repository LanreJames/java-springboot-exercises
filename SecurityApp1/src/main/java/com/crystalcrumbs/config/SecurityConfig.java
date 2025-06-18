package com.crystalcrumbs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.csrf(Customizer->Customizer.disable());
		http.httpBasic(Customizer.withDefaults());
		http.sessionManagement(Session->Session.
				sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		
		return http.build();
	}
	
	@Bean
	public UserDetailsService userDetails() {
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("james")
				.password("banks")
				.roles("USER")
				.build();
		
		UserDetails admin = User.withDefaultPasswordEncoder()
				.username("leyrab")
				.password("banks")
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user,admin);
	}

}
