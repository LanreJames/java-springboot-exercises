package com.crystalcrumbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crystalcrumbs.model.Users;
import com.crystalcrumbs.repo.IUsersRepo;

@Service
public class UsersService {
	
	@Autowired
	private IUsersRepo repo;
	
	public Users addUsers(Users user) {
		
		return repo.save(user);
		
	}

}
