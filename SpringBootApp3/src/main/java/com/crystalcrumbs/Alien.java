package com.crystalcrumbs;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Alien {
	
	@PostConstruct
	public void init()
	{
		System.out.println("Init Method");
	}
	
	@PreDestroy
	public void destroy()
	{
		System.out.println("Clean Up Logic");
	}
	
	static {
		System.out.println("Static Block");
	}
	{
		System.out.println("Java Init Block");
	}
	public Alien()
	{
		System.out.println("Mad");;
	}
	
	
	public void disp()
	{
		System.out.println("Focus is the Key");
	}
	
	

}
