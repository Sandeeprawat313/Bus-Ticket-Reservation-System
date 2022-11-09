package com.project.model;

public class User {

	private int cid;
	private String uname;
	private String email;
	private String password;

	@Override
	public String toString() {
		return "User [cid=" + cid + ", uname=" + uname + ", email=" + email + ", password=" + password + "]";
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(int cid, String uname, String email, String password) {
		super();
		this.cid = cid;
		this.uname = uname;
		this.email = email;
		this.password = password;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

	}

}
