package com.dendrytdev.org.client.login;

import com.google.gwt.user.client.rpc.IsSerializable;

public class LoginDTO implements IsSerializable{
	
	private String login;
	private String password;

	public LoginDTO(String n, String p) {
		login=n;
		password=p;
	}
	
	public LoginDTO() {
		
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
}
