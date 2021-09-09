package com.cts.swd.model;

public class Course {
	
	private Long cid;
	private String title;
	private Double fee;
	
	public Course() {
		//left blank
	}

	public Course(Long cid, String title, Double fee) {
		super();
		this.cid = cid;
		this.title = title;
		this.fee = fee;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}
	
	

}
