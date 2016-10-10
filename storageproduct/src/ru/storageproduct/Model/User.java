package ru.storageproduct.Model;

import java.io.Serializable;

public class User implements Serializable {

	private String login;
	private String password;
	private String email;
	private Integer permission;

	public User() {
	}

	public User(String login, String password, String email, Integer permission) {

		super();

		this.login = login;
		this.password = password;
		this.email = email;
		this.permission = permission;

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {

		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {

		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public Integer getPermission() {
		return permission;
	}

	public void setPermission(Integer permission) {

		this.permission = permission;
	}

}
