package com.crystalcrumbs.service;

import java.util.List;

import com.crystalcrumbs.model.Alien;

public interface IAlienService {
	Alien registerAlien (Alien alien);
	List<Alien> getAllAlienInfo();

}
