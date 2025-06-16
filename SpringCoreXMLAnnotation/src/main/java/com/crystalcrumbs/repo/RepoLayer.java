package com.crystalcrumbs.repo;

import org.springframework.stereotype.Repository;

@Repository("repo")
public class RepoLayer {
	public RepoLayer() {
		System.out.println("RepoLayer is Created");
	}
	

}
