package com.crystalcrumbs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crystalcrumbs.model.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {

}
