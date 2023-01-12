package com.khadri.mvc.signup.pojo;

public class SignUp {

	private String name;
	private String userName;
	private String password;

	public SignUp(String name, String userName, String password) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

}
