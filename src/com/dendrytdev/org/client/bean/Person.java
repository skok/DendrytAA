package com.dendrytdev.org.client.bean;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Unique;

import com.google.appengine.api.datastore.Key;
import com.google.gwt.user.client.rpc.IsSerializable;

//Unique(name="UNIQUE_LOGIN_PERSON", members={"login"})

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Person implements IsSerializable{
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

	@Persistent
	private String login;
	@Persistent
	private String name;
	@Persistent
	private String surname;
	@Persistent
	private String password;
	@Persistent
	private String email;
	@Persistent
	private String telephone;
	@Persistent
	private Function function;
	
	//policy-only for clients
	@Persistent
	private Boolean Policy;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public Boolean getPolicy() {
		return Policy;
	}
	public void setPolicy(Boolean policy) {
		Policy = policy;
	}
	public Function getFunction() {
		return function;
	}
	public void setFunction(Function function) {
		this.function = function;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
