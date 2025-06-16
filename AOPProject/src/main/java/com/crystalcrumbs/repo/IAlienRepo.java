package com.crystalcrumbs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crystalcrumbs.model.Alien;

@Repository
public interface IAlienRepo extends JpaRepository<Alien, Integer> {

}
