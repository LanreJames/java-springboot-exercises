package com.crystalcrumbs.model;

public class Course {
	private Integer cid;
	
	private String cname;
	
	private Double Cost;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Double getCost() {
		return Cost;
	}

	public void setCost(Double cost) {
		Cost = cost;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(Integer cid, String cname, Double cost) {
		super();
		this.cid = cid;
		this.cname = cname;
		Cost = cost;
	}

	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", Cost=" + Cost + "]";
	}
	
	

}
