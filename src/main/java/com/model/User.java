package com.model;

public class User {
	

	private int id;
	private String name;
	private String bloodgroup;
	private String disease;
	
	
	
	public User(String name, String bloodgroup, String disease) {
		super();
		this.name = name;
		this.bloodgroup = bloodgroup;
		this.disease = disease;
	}
	
	
	public User(int id, String name, String bloodgroup, String disease) {
		super();
		this.id = id;
		this.name = name;
		this.bloodgroup = bloodgroup;
		this.disease = disease;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	
	
	
}
