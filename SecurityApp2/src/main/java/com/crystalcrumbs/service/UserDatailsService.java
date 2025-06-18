package com.crystalcrumbs.service;

//import java.nio.file.attribute.UserPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.crystalcrumbs.model.Users;
import com.crystalcrumbs.repo.IUsersRepo;

@Service
public class UserDatailsService implements UserDetailsService {
	
	
	@Autowired
	private IUsersRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Users user = repo.findByName(username);
		//System.out.println("Loaded user: " + user.getName() + ", Password: " + user.getPassword());
		if(user==null) {
			throw new UsernameNotFoundException("User not found 404");
		}
		return new UserPrincipal(user);
	}
	
	

}
