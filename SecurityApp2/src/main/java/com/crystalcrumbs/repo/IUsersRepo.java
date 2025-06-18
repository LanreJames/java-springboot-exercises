package com.crystalcrumbs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crystalcrumbs.model.Users;

@Repository
public interface IUsersRepo extends JpaRepository<Users, String> {
	Users findByName(String username);

}
