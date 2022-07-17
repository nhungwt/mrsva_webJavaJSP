package com.servlet.model;

public class User {
	private String username, pass;

	public User() {
		
	}
	public User(String user, String pass) {
		this.username = user;
		this.pass = pass;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username; 
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
