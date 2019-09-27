package com.ust.beans;

public class Login_Details {
	private long user_Id;
	private String username;
	private String password;
	
	//getters and setters
	
	public long getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(long user_Id) {
		this.user_Id = user_Id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//no parameter constructor
	
	public Login_Details() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//all parameter constructor
	public Login_Details(long user_Id, String username, String password) {
		super();
		this.user_Id = user_Id;
		this.username = username;
		this.password = password;
	}
	//constructor without user id
	
	public Login_Details(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	//generate to string
	@Override
	public String toString() {
		return "Login [user_Id=" + user_Id + ", username=" + username
				+ ", password=" + password + "]";
	}
	
	
	
	
	
}
